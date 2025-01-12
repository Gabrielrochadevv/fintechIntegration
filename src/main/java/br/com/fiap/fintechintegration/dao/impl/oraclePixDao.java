package br.com.fiap.fintechintegration.dao.impl;

import br.com.fiap.fintechintegration.dao.ConnectionManager;
import br.com.fiap.fintechintegration.dao.PixDao;
import br.com.fiap.fintechintegration.exeception.DBException;
import br.com.fiap.fintechintegration.model.Pix;
import br.com.fiap.fintechintegration.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class oraclePixDao implements PixDao {

    private Connection conexao;

    @Override
    public void cadastrarPix(Pix pix) throws DBException {

        PreparedStatement stmt = null;

        conexao = ConnectionManager.getInstance().getConnection();

        try {

            String sql = "INSERT INTO TB_PIX (chavePix,valorPix, descricaoPix) VALUES (?, ?, ?)";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pix.getChavePix());
            stmt.setDouble(2, pix.getValorPix());
            stmt.setString(3, pix.getDescricaoPix());
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
    public void atualizarPix(Pix pix) throws DBException {

    }

    @Override
    public void removerPix(String chavePix) throws DBException {

    }

    @Override
    public Pix buscarPix(String chavePix) {
        return null;
    }

    @Override
    public List<Pix> listarPix() {

        List<Pix> lista = new ArrayList<Pix>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM TB_PIX";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            //Percorre todos os registros encontrados
            while (rs.next()) {
                String chavePix = rs.getString("chavePix");
                Double valorPix = rs.getDouble("valorPix");
                String descricaoPix = rs.getString("descricaoPix");

                Pix pix = new Pix(chavePix, valorPix, descricaoPix);
                lista.add(pix);

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

