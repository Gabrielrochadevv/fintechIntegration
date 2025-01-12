package br.com.fiap.fintechintegration.dao;

import br.com.fiap.fintechintegration.model.AcessoUsuario;
import br.com.fiap.fintechintegration.model.Usuario;

public interface AcessoUsuarioDao {

    boolean validaAcessoUsuario(AcessoUsuario acessoUsuario);
}
