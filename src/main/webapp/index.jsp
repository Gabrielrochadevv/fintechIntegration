<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>PoupaBemFINANCE</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./resources/css/bootstrap.css">

</head>
<body>

<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card bg-dark text-white" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">
                        <div class="mb-md-3 mt-md-4 pb-3">

                            <h1 class="fw-bold mb-5 ">PoupaBemFinance</h1>
                            <h3 class="fw-bold mb-2 text-uppercase">Login</h3>
                            <p class="text-white-50 mb-5">Por favor, insira seu login e senha!</p>

                        </div>
                        <form action="login" method="post">
                            <div data-mdb-input-init class="form-outline form-white mb-4">
                                <input type="email" name="dsemail" id="typeEmailX"
                                       class="form-control form-control-lg"/>
                                <label class="form-label" for="typeEmailX">Email</label>
                            </div>

                            <div data-mdb-input-init class="form-outline form-white mb-4">
                                <input type="password" name="dssenha" id="typePasswordX"
                                       class="form-control form-control-lg"/>
                                <label class="form-label" for="typePasswordX">Senha</label>
                            </div>

                            <p class="small mb-5 pb-lg-2"><a class="text-white-50" href="#!">Esqueceu a Senha?</a>
                            </p>

                            <button data-mdb-button-init data-mdb-ripple-init
                                    class="btn btn-outline-light btn-lg px-5"
                                    type="submit">Login
                                <%--onclick="window.location.href='dashboard.jsp'"--%>
                            </button>


                            <div class="mb-md-3 mt-md-5 pb-3">
                                <p class="mb-0">Não tem uma conta?
                                    <a href="./inscricao.jsp" class="text-white-50 fw-bold">Inscreva-se</a>
                                </p>
                            </div>

                            <c:if test="${not empty erro}">
                            <div class="alert alert-danger">${erro}</div>
                            </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="resources/js/bootstrap.bundle.js"></script>
</body>
</html>