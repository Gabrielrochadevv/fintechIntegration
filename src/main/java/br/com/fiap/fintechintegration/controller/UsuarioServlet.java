package br.com.fiap.fintechintegration.controller;

import br.com.fiap.fintechintegration.dao.UsuarioDao;
import br.com.fiap.fintechintegration.exeception.DBException;
import br.com.fiap.fintechintegration.factory.DaoFactory;
import br.com.fiap.fintechintegration.model.Usuario;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {

    private static UsuarioDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        dao = DaoFactory.getUsuarioDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String acao = req.getParameter("acao");

        switch (acao) {
            case "cadastrar":
                cadastrar(req, resp);
                break;
            case "editar":
                editar(req, resp);
                break;
            case "excluir":
                excluir(req, resp);
        }


    }

    private void excluir(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idUsuario = Integer.parseInt(req.getParameter("idUsuarioExcluir"));

        try {
            dao.remover(idUsuario);
            req.setAttribute("mensagem", "Usuario removido com sucesso");
        } catch (DBException e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao atualizar");
        }

        listar(req, resp);
    }

    private void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        LocalDate dataNascimento = LocalDate.parse(req.getParameter("datanascimento"));

        Usuario usuario = new Usuario(
                0,
                nome,
                email,
                senha,
                dataNascimento

        );
        try {
            dao.cadastrar(usuario);
            req.setAttribute("mensagem", "Produto cadastrado com sucesso!");
        } catch (DBException e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao cadastrar usuário");
        }

        req.getRequestDispatcher("cadastro.jsp").forward(req, resp);
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int idUsuario = Integer.parseInt(req.getParameter("idUsuario"));
            String nome = req.getParameter("nome");
            String email = req.getParameter("email");
            String senha = req.getParameter("senha");
            LocalDate dataNascimento = LocalDate
                    .parse(req.getParameter("dataNascimento"));

            Usuario usuario = new Usuario(idUsuario, nome, email, senha, dataNascimento);
            dao.atualizar(usuario);


            req.setAttribute("mensagem", "Usuario atualizado!");
        } catch (DBException db) {
            db.printStackTrace();
            req.setAttribute("erro", "Erro ao atualizar");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("erro", "Por favor, valide os dados");
        }
        listar(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String acao = req.getParameter("acao");

        switch (acao) {
            case "listar":
                listar(req, resp);
                break;
            case "abrir-form-edicao":
                abrirForm(req, resp);
                break;
        }
    }

    private static void abrirForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idUsuario = Integer.parseInt(req.getParameter("idUsuario"));
        Usuario usuario = dao.buscar(idUsuario);
        req.setAttribute("usuario", usuario);
        req.getRequestDispatcher("editar-usuario.jsp")
                .forward(req, resp);
    }

    private static void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Usuario> lista = dao.listar();
        req.setAttribute("usuario", lista);
        req.getRequestDispatcher("usuario.jsp").forward(req, resp);
    }

}
