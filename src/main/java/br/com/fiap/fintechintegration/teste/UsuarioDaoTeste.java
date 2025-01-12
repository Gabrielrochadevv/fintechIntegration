package br.com.fiap.fintechintegration.teste;

import br.com.fiap.fintechintegration.dao.UsuarioDao;
import br.com.fiap.fintechintegration.exeception.DBException;
import br.com.fiap.fintechintegration.factory.DaoFactory;
import br.com.fiap.fintechintegration.model.Usuario;

import java.time.LocalDate;
import java.util.List;

public class UsuarioDaoTeste {

    public static void main(String[] args) {

        // Cadastrar um Usuário
        UsuarioDao dao = DaoFactory.getUsuarioDao();

        Usuario usuario = new Usuario(
                0,
                "Layza",
                "Layza@gmail.com",
                "5678",
                LocalDate.of(2024, 9, 16)
        );

//        try {
//           // dao.cadastrar(usuario);
//
//        } catch (DBException e) {
//            throw new RuntimeException(e);
//        }


        //Buscar um produto pelo código e atualizar
//        usuario = dao.buscar(2);
//        usuario.setNome("Eliana");
//        usuario.setEmail("Eliana@gmail.com");
//        try {
//            dao.atualizar(usuario);
//
//        } catch (DBException e) {
//            e.printStackTrace();
//        }

        //Listar os produtos
        List<Usuario> lista = dao.listar();
        for (Usuario item : lista) {
            System.out.println(
                    item.getNome() + " " +
                            item.getEmail() + " " +
                            item.getSenha());
        }

        //Remover um produto
        try {
            dao.remover(7);

        } catch (DBException e) {
            e.printStackTrace();
        }


    }

}
