<div class="modal fade" id="agregarClienteModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Cliente</h5>
                <button class="btn-close" data-bs-dismiss="modal"></button>

            </div>
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar" method="post" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required placeholder="Ingrese nombres">                       
                    </div>
                    <div class="form-group">
                        <label for="apellido">Apellido</label>
                        <input type="text" class="form-control" name="apellido" required placeholder="Ingrese apellidos">                       
                    </div>
                    <div class="form-group">
                        <label for="email">E-mail</label>
                        <input type="email" class="form-control" name="email" required placeholder="Ingrese e-mail">                       
                    </div>
                    <div class="form-group">
                        <label for="telefono">Teléfono</label>
                        <input type="tel" class="form-control" name="telefono" required placeholder="Ingrese numero de telefono">                       
                    </div>
                    <div class="form-group">
                        <label for="saldo">Saldo</label>
                        <input type="number" class="form-control" name="saldo" placeholder="Ingrese el saldo">                       
                    </div>

                </div>
                <div class="modal-footer">
                    <input  type="submit" class="btn btn-primary" value="Guardar">
                </div>

            </form>
        </div>
    </div>
</div>
