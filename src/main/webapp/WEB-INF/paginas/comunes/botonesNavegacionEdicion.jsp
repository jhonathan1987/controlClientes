<section id="action" class="py4 mb-4 bg_light">
    <div class="container">
        <div class="row">
            <div class="col-md-3 d-grid gap-2">
                <a href="index.jsp" class="btn btn-light btn-block"><i class="fas fa-arrow-left"></i> Regredar al Inicio</a>
            </div>
            <div class="col-md-3 d-grid gap-2">
                <button type="submit" class="btn btn-success" btn-block><i class="fas fa-check"></i> Guardar cliente</button>
            </div>
             <div class="col-md-3 d-grid gap-2">
                <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&id=${cliente.id}" class="btn btn-danger btn-block"><i class="fas fa-trash"></i> Eliminar Cliente</a>
            </div>
        </div>
    </div>
</section>