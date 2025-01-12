package br.com.fiap.fintechintegration.controller;

import br.com.fiap.fintechintegration.dao.PixDao;
import br.com.fiap.fintechintegration.exeception.DBException;
import br.com.fiap.fintechintegration.factory.DaoFactory;
import br.com.fiap.fintechintegration.model.Pix;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/Pix")
public class PixServlet extends HttpServlet {

    private PixDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        dao = DaoFactory.getPixDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Double valorPix = Double.valueOf(req.getParameter("valorPix"));
        String descricaoPix = req.getParameter("descricaoPix");

        Pix pix = new Pix(
                "a1b2c3",
                valorPix,
                descricaoPix
        );
        try {

            // Cadastrando o Pix no banco de dados
            dao.cadastrarPix(pix);
            req.setAttribute("mensagem", "PIX cadastrado com sucesso!");
        } catch (DBException e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao cadastrar o PIX.");

        }
        req.getRequestDispatcher("pix.jps").forward(req, resp);
    }
}


