<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PoupaBem</title>
    <!-- Link do Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-primary text-white">

<!-- Header -->
<header class="d-flex justify-content-between align-items-center py-3 px-4 bg-dark">
    <div>
        <img src="${pageContext.request.contextPath}/resources/img/notificacao.png" alt="Notificação" class="img-fluid"
             width="24">
    </div>
    <div class="fw-bold fs-4">PoupaBem</div>
    <div>
        <a href="#" class="text-white fw-bold">AJUDA</a>
    </div>
</header>

<!-- Profile Section -->
<section class="container mt-4">
    <div class="row align-items-center">
        <div class="col-8 d-flex align-items-center">
            <img src="${pageContext.request.contextPath}/resources/img/perfil.png" alt="Foto de perfil" width="100">
            <span class="ms-3 fs-5 fw-bold">Gabriel</span>
        </div>
        <div class="col-4 text-end">
            <img src="${pageContext.request.contextPath}/resources/img/configuracao.png" alt="Configurações"
                 class="img-fluid" width="50" style="cursor:pointer">
        </div>
    </div>
</section>

<!-- Account Balance Section -->
<section class="container text-center mt-4">
    <p>SALDO DA CONTA-CORRENTE</p>
    <div class="d-flex justify-content-center align-items-center">
        <span class="fs-2 fw-bold">R$ ************</span>
        <img src="${pageContext.request.contextPath}/resources/img/visualizar.png" alt="Visualizar saldo" class="ms-2"
             width="40" style="cursor:pointer">
    </div>
</section>

<!-- Action Buttons Section -->
<section class="container mt-5">
    <div class="row text-center">
        <div class="col-3">
            <img src="${pageContext.request.contextPath}/resources/img/saldoExtrato.png" alt="Saldo e Extrato"
                 class="img-fluid mb-2" width="80" style="cursor:pointer">
            <p>Saldo e Extrato</p>
        </div>
        <div class="col-3">
            <a href="${pageContext.request.contextPath}/pix.jsp">
                <img src="${pageContext.request.contextPath}/resources/img/pix.png" alt="Pix" class="img-fluid mb-2"
                     width="80">
            </a>
            <p>Pix</p>
        </div>
        <div class="col-3">
            <img src="${pageContext.request.contextPath}/resources/img/pagamento.png" alt="Pagamentos"
                 class="img-fluid mb-2" width="80" style="cursor:pointer">
            <p>Pagamentos</p>
        </div>

        <div class="col-3">
            <a href="${pageContext.request.contextPath}/usuario?acao=listar">
                <img src="${pageContext.request.contextPath}/resources/img/usuario.png" alt="usuario" class="img-fluid mb-2"
                     width="80">
            </a>
            <p>Usuario</p>
        </div>

    </div>
</section>

<!-- Ver Mais Button -->
<div class="container text-center mt-4">
    <button class="btn btn-light text-primary fw-bold rounded-pill px-5 mt-3">Ver mais</button>
    <a href="index.jsp" class="btn btn-warning mt-3 fw-bold rounded-pill px-5">Sair</a>
</div>

<!-- Link do JavaScript do Bootstrap CDN -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
