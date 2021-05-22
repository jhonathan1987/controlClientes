<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>



<section id="cliente">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Clienes</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="table-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Saldo</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <!<!-- iteramos los elementos -->
                            <c:forEach var="cliente" items="${clientes}">
                                <tr>
                                    <td>${cliente.id}</td>
                                    <td>${cliente.nombre} ${cliente.apellido}</td>
                                    <td><fmt:formatNumber value="${cliente.saldo}" type="currency"/> </td>
                                    <td><a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletControlador?accion=editar&id=${cliente.id}">
                                            <i class="fas fa-angle-double-right"></i>Editart </a>
                                    </td>
                                </tr>

                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
            <!-- tarjetas para los totales -->
            <div class="col-md-4">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Saldo Total</h3>
                        <h4 class="display-4">
                            <fmt:formatNumber value="${saldoTotal}" type="currency"/>
                        </h4>
                    </div>
                </div>
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total Clientes</h3>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i>${totalClientes}
                        </h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- agregar cliente modal -->
<jsp:include page="/WEB-INF/paginas/cliente/agregarCliente.jsp"/>