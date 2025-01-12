package br.com.fiap.fintechintegration.factory;

import br.com.fiap.fintechintegration.dao.AcessoUsuarioDao;
import br.com.fiap.fintechintegration.dao.PixDao;
import br.com.fiap.fintechintegration.dao.UsuarioDao;
import br.com.fiap.fintechintegration.dao.impl.OracleAcessoUsuarioDao;
import br.com.fiap.fintechintegration.dao.impl.OracleUsuarioDao;
import br.com.fiap.fintechintegration.dao.impl.oraclePixDao;

public class DaoFactory {

    public static UsuarioDao getUsuarioDao() {
        return new OracleUsuarioDao();

    }

    public static PixDao getPixDao() {
        return new oraclePixDao();
    }

    public static AcessoUsuarioDao getAcessoUsuarioDao() {
        return new OracleAcessoUsuarioDao();
    }
}
