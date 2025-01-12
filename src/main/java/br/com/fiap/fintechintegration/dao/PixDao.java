package br.com.fiap.fintechintegration.dao;

import br.com.fiap.fintechintegration.exeception.DBException;
import br.com.fiap.fintechintegration.model.Pix;

import java.util.List;

public interface PixDao {

    void cadastrarPix(Pix pix) throws DBException;

    void atualizarPix(Pix pix) throws DBException;

    void removerPix(String chavePix) throws DBException;

    Pix buscarPix(String chavePix);

    List<Pix> listarPix();

}
