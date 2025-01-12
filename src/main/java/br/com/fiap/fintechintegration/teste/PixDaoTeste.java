package br.com.fiap.fintechintegration.teste;

import br.com.fiap.fintechintegration.dao.PixDao;
import br.com.fiap.fintechintegration.exeception.DBException;
import br.com.fiap.fintechintegration.factory.DaoFactory;
import br.com.fiap.fintechintegration.model.Pix;
import br.com.fiap.fintechintegration.model.Usuario;

import java.util.List;

public class PixDaoTeste {

    public static void main(String[] args) {
        PixDao daopix = DaoFactory.getPixDao();

        Pix pix = new Pix(
                "2c3c4c",
                300.00,
                "pagamento loja"
        );

        try {
            daopix.cadastrarPix(pix);

        } catch (DBException e) {
            throw new RuntimeException(e);
        }

        List<Pix> lista = daopix.listarPix();
        for (Pix valor : lista) {
            System.out.println(
                    valor.getChavePix() + " " +
                            valor.getValorPix() + " " +
                            valor.getDescricaoPix());
        }

        //Remover um produto
//        try {
//            daopix.removerPix("123456");
//
//        } catch (DBException e) {
//            e.printStackTrace();
//        }

    }
}
