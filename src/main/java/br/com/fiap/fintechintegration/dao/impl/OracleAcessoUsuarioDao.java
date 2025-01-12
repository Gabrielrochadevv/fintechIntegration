package br.com.fiap.fintechintegration.dao.impl;

import br.com.fiap.fintechintegration.dao.AcessoUsuarioDao;
import br.com.fiap.fintechintegration.dao.ConnectionManager;
import br.com.fiap.fintechintegration.model.AcessoUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleAcessoUsuarioDao implements AcessoUsuarioDao {

    private Connection conexao;

    @Override
    public boolean validaAcessoUsuario(AcessoUsuario acessoUsuario) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conexao = ConnectionManager
                    .getInstance()
                    .getConnection();

            String sql = "SELECT * FROM TB_ACESSO_USUARIO " +
                    "WHERE DS_EMAIL = ? AND DS_SENHA = ?";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, acessoUsuario.getDsemail());
            stmt.setString(2, acessoUsuario.getDssenha());
            rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
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
        return false;
    }
}
