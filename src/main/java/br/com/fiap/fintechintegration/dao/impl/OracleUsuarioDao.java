package br.com.fiap.fintechintegration.dao.impl;

import br.com.fiap.fintechintegration.dao.ConnectionManager;
import br.com.fiap.fintechintegration.dao.UsuarioDao;
import br.com.fiap.fintechintegration.exeception.DBException;
import br.com.fiap.fintechintegration.model.Usuario;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OracleUsuarioDao implements UsuarioDao {

    private Connection conexao;

    @Override
    public void cadastrar(Usuario usuario) throws DBException {

        PreparedStatement stmt = null;

        conexao = ConnectionManager.getInstance().getConnection();

        try {

            String sql = "INSERT INTO TB_PESSOA_FISICA " +
                    "(ID_USUARIO, NOME, EMAIL, " +
                    "SENHA, DATA_NASCIMENTO) " +
                    "VALUES (SQ_TB_PESSOA_FISICA.NEXTVAL, ?, ?, ?, ?)";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setDate(4, Date.valueOf(usuario.getDataNascimento()));
            stmt.executeUpdate();

            System.out.println("Produto cadastrado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar.");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void atualizar(Usuario usuario) throws DBException {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            String sql = "UPDATE TB_PESSOA_FISICA SET " +
                    "NOME = ?, " +
                    "EMAIL = ?, " +
                    "SENHA = ?, " +
                    "DATA_NASCIMENTO = ? " +
                    "WHERE ID_USUARIO = ?";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setDate(4, Date.valueOf(usuario.getDataNascimento()));
            stmt.setInt(5, usuario.getIdUsuario());
            stmt.executeUpdate();

            System.out.println("Produto atualizado.");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao atualizar.");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void remover(int idUsuario) throws DBException {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM TB_PESSOA_FISICA WHERE ID_USUARIO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();

            System.out.println("Produto removido.");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao remover.");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Usuario buscar(int id) {

        Usuario usuario = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM TB_PESSOA_FISICA WHERE ID_USUARIO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int idUsuario = rs.getInt("ID_USUARIO");
                String nome = rs.getString("NOME");
                String email = rs.getString("EMAIL");
                String senha = rs.getString("SENHA");
                LocalDate dataNascimento = rs.getDate("DATA_NASCIMENTO").toLocalDate();

                usuario = new Usuario(idUsuario, nome, email, senha, dataNascimento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usuario;

    }

    @Override
    public List<Usuario> listar() {

        List<Usuario> lista = new ArrayList<Usuario>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM TB_PESSOA_FISICA";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            //Percorre todos os registros encontrados
            while (rs.next()) {
                int idUsuario = rs.getInt("ID_USUARIO");
                String nome = rs.getString("NOME");
                String email = rs.getString("EMAIL");
                String senha = rs.getString("SENHA");
                java.sql.Date data = rs.getDate("DATA_NASCIMENTO");
                LocalDate dataNascimento = rs.getDate("DATA_NASCIMENTO")
                        .toLocalDate();

                Usuario usuario = new Usuario(idUsuario, nome, email, senha, dataNascimento);
                lista.add(usuario);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;

    }
}
