<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pix</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./resources/css/bootstrap.css">
</head>
<body class="bg-primary text-white">

<header class="d-flex justify-content-between align-items-center py-3 px-4 bg-dark">
    <div>
        <img src="${pageContext.request.contextPath}/resources/img/notificacao.png" alt="Notificação" class="img-fluid"
             width="24">
    </div>
    <div class="fw-bold fs-4 ">PoupaBem</div>
    <div>
        <a href="#" class="text-white fw-bold">AJUDA</a>
    </div>
</header>

<div class="container">
    <div class="mt-5 ms-5 me-5">
        <div class="card mb-3">
            <div class="card-header">
                <h3>PIX</h3>
            </div>

            <div class="card-body">
                <form action="pix" method="post">
                    <div class="form-group">
                        <label for="chave-pix">Chave ou pix copia e cola</label>
                        <input type="text" name="pix" id="chave-pix" class="form-control" placeholder="Chave Aleaória, CPF, CNPJ, ou celular">
                    </div>
                    <div class="form-group">
                        <label for="valor-pix">Valor</label>
                        <input type="number" name="valorpix" id="valor-pix" class="form-control " placeholder="R$00.00">
                    </div>
                    <div class="form-group">
                        <label for="descricao-pix">Descrição</label>
                        <input type="text" name="descricaopix" id="descricao-pix" class="form-control" placeholder="breve descrição">
                    </div>
                    <input type="submit" value="Enviar" class="btn btn-primary mt-3">

                    <a href="dashboard.jsp" class="btn btn-warning mt-3">Voltar a tela inicial</a>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="resources/js/bootstrap.bundle.js"></script>
</body>
</html>