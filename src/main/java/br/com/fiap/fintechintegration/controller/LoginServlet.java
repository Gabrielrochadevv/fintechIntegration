package br.com.fiap.fintechintegration.controller;

import br.com.fiap.fintechintegration.bo.EmailBo;
import br.com.fiap.fintechintegration.dao.AcessoUsuarioDao;
import br.com.fiap.fintechintegration.dao.UsuarioDao;
import br.com.fiap.fintechintegration.exeception.EmailException;
import br.com.fiap.fintechintegration.factory.DaoFactory;
import br.com.fiap.fintechintegration.model.AcessoUsuario;
import br.com.fiap.fintechintegration.model.Usuario;
import br.com.fiap.fintechintegration.util.CriptografiaUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private AcessoUsuarioDao acessoUsuarioDao;
    private EmailBo bo;

    public LoginServlet() {
        acessoUsuarioDao = DaoFactory.getAcessoUsuarioDao();
        bo = new EmailBo();
    }

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String dsemail = request.getParameter("dsemail");
        String dssenha = request.getParameter("dssenha");

        try {
            // Criptografar a senha antes de validar
            String senhaCriptografada = CriptografiaUtils.criptografar(dssenha);

            // Cria objeto AcessoUsuario com a senha criptografada
            AcessoUsuario acessoUsuario = new AcessoUsuario(dsemail, senhaCriptografada);

            if (acessoUsuarioDao.validaAcessoUsuario(acessoUsuario)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", dsemail);

                String mensagem = "Um login foi realizado na plataforma em " + LocalDate.now();
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);

                try {
                    bo.enviarEmail(dsemail, "Login Realizado", mensagem);
                } catch (EmailException e) {
                    e.printStackTrace();
                }

            } else {
                request.setAttribute("erro", "Usuário e/ou senha inválidos");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            request.setAttribute("erro", "Erro ao processar a senha");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
