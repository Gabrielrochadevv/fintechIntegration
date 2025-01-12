<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>FiapStore</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./resources/css/bootstrap.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
    <div class="mt-5 ms-5 me-5">
        <div class="card mb-3">
            <div class="card-header">
                USUÁRIOS CADASTRADOS
            </div>
            <div class="card-body">
                <h5 class="card-title">Usuários</h5>

                <c:if test="${not empty mensagem }">
                    <div class="alert alert-success">${mensagem}</div>
                </c:if>
                <c:if test="${not empty erro }">
                    <div class="alert alert-danger">${erro}</div>
                </c:if>

                <table class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th class="text-end">Nome</th>
                        <th class="text-end">E-mail</th>
                        <th class="text-center">Data de Nascimento</th>
                        <th class="text-center"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${usuario}" var="usuario">
                        <tr>
                            <td>${usuario.idUsuario}</td>
                            <td class="text-end">${usuario.nome}</td>
                            <td class="text-end">${usuario.email}</td>
                            <td class="text-center">
                                <fmt:parseDate
                                        value="${usuario.dataNascimento}"
                                        pattern="yyyy-MM-dd"
                                        var="dataNascimentoFmt"/>

                                <fmt:formatDate
                                        value="${dataNascimentoFmt}"
                                        pattern="dd/MM/yyyy"/>
                            </td>
                                <%--INICIO BOTAO EDITAR--%>
                            <td class="text-center">
                                <c:url value="usuario" var="link">
                                    <c:param name="acao" value="abrir-form-edicao"/>
                                    <c:param name="idUsuario" value="${usuario.idUsuario}"/>
                                </c:url>
                                <a href="${link}" class="btn btn-primary">Editar</a>

                                <!-- Botão para abrir a modal -->
                                <button
                                        type="button"
                                        class="btn btn-danger"
                                        data-bs-toggle="modal"
                                        data-bs-target="#excluirModal"
                                        onclick="idUsuarioExcluir.value = ${usuario.idUsuario}"
                                >
                                    Excluir
                                </button>

                            </td>
                                <%--FIM BOTAO EDITAR--%>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <a href="cadastro.jsp" class="btn btn-primary">Cadastrar novo usuário</a>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div
        class="modal fade"
        id="excluirModal"
        tabindex="-1"
        aria-labelledby="exampleModalLabel"
        aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1
                        class="modal-title fs-5"
                        id="exampleModalLabel">
                    Confirmar Exclusão
                </h1>
                <button
                        type="button"
                        class="btn-close"
                        data-bs-dismiss="modal"
                        aria-label="Close">
                </button>
            </div>
            <div class="modal-body">
                <h4>Você confirma a exclusão deste produto?</h4>
                <p><strong>Atenção!</strong> Esta ação é irreversível.</p>
            </div>
            <div class="modal-footer">

                <form action="usuario" method="post">
                    <input
                            type="hidden"
                            name="acao"
                            value="excluir">
                    <input
                            type="hidden"
                            name="idUsuarioExcluir"
                            id="idUsuarioExcluir">
                    <button
                            type="button"
                            class="btn btn-secondary"
                            data-bs-dismiss="modal">
                        Não
                    </button>
                    <button
                            type="submit"
                            class="btn btn-danger">
                        Sim
                    </button>
                </form>

            </div>
        </div>
    </div>
</div>
<%--    fim modal--%>

<%@include file="footer.jsp" %>
<script src="resources/js/bootstrap.bundle.js"></script>
</body>
</html>