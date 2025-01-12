package br.com.fiap.fintechintegration.dao;

import br.com.fiap.fintechintegration.exeception.DBException;
import br.com.fiap.fintechintegration.model.Usuario;

import java.util.List;

public interface UsuarioDao {

    void cadastrar(Usuario usuario) throws DBException;

    void atualizar(Usuario usuario) throws DBException;

    void remover(int idUsuario) throws DBException;

    Usuario buscar(int id);

    List<Usuario> listar();
}
