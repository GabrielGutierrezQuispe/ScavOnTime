<%@ page pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
	<%@include file="component/allcss.jsp" %>
</head>
<body>

<jsp:include page="component/header.jsp"></jsp:include>

<jsp:include page="component/navbar.jsp"></jsp:include>

<jsp:include page="component/toast.jsp"></jsp:include>

<div class="container">

	<div class="my-3 p-3 bg-body rounded shadow-sm">
		<h5 class="border-bottom pb-2 mb-0">Docentes</h5>
		<div class="row mt-3">
			<div class="col-md-5">
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1"><i class='bx bx-search-alt-2' ></i></span>
					<input type="search" class="form-control" placeholder="Buscar..." id="idBuscarProfesor">
				</div>
			</div>
			
			<div class="col">
					<select class="form-select" id="idSelectTipoDocumento">
						<option value="">Tipo Doc.</option>
						<option value="DNI">DNI</option>
						<option value="CNE">CNE</option>
					</select>
				</div>
					
			<div class="col">
				<div class="form-check form-check-inline mt-2 mb-2">
					<input class="form-check-input" type="checkbox" id="idActiveCheckbox" checked>
					<label class="form-check-label" for="inlineCheckbox1">Activos</label>
				</div>
			</div>
			<div class="col">
				<div class="dropdown">
					<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
						Exportar
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
						<li><a class="dropdown-item" href="#" id="descargarPDF">Pdf</a></li>
						<li><a class="dropdown-item" href="#" id="descargarEXCEL">Excel</a></li>
						<li><a class="dropdown-item" href="#" id="descargarCSV">Csv</a></li>
					</ul>
				</div>
			</div>
			<div class="col">
				<button type="button" class="btn btn-primary" id="btnNuevo">Agregar</button>
			</div>
		</div>
	</div>

	<div class="my-3 p-3 bg-body rounded shadow-sm">
		<table class="table table-sm table-hover" id="tablaTeacher">
			<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Tipo Doc.</th>
				<th scope="col">N° Documento</th>
				<th scope="col">Nombres</th>
				<th scope="col">Apellidos</th>
				<th scope="col">Fec. nacimiento</th>
				<th scope="col">Cargo</th>
				<th scope="col">Condicion</th>
				<th scope="col">J. laboral</th>
				<th scope="col">Acciones</th>
			</tr>
			</thead>
			<tbody id="detalleTabla">
			</tbody>
		</table>
	</div>

	<!-- Formulario para crear Profesor -->
	<div class="modal fade" id="profesorModal" tabindex="-1"
		 aria-labelledby="profesorModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="profesorModalLabel">Crear nuevo
						profesor</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
				</div>
				<div class="modal-body">

					<form class="row g-2" id="formProfesor">
						<input type="hidden" id="accion" name="accion"> <input
							type="hidden" class="form-control" id="frmId">
						<div class="col-md-4 input-group-sm">
							<label for="frmTipoDocumento" class="form-label">Tipo documento:</label> 
							<select class="form-select" aria-label="Seleccionar" id="frmTipoDocumento">
							<option value="DNI">DNI</option>
							<option value="CNE">CNE</option>
						</select>
						</div>

						<div class="col-md-8 input-group-sm">
							<label for="frmNumeroDocumento" class="form-label">N&deg;
								Documento:</label> <input type="text" class="form-control"
														  id="frmNumeroDocumento" required>
							<div id="errorDocumentNumber" class="error-messageT"></div>
							<div id="inputNumeroDocumentoError" class="invalid-feedback"></div>
						</div>

						<div class="col-md-12 input-group-sm">
							<label for="frmNombres" class="form-label">Nombres:</label> <input
								type="text" class="form-control" id="frmNombres" required>
							<div id="errorNames" class="error-messageT1"></div>
							<div id="inputNombresError" class="invalid-feedback"></div>
						</div>

						<div class="col-md-12 input-group-sm">
							<label for="frmApellidos" class="form-label">Apellidos:</label>
							<input type="text" class="form-control" id="frmApellidos"
								   required>
							<div id="errorLastnames" class="error-messageT2"></div>
							<div id="inputApellidosError" class="invalid-feedback"></div>
						</div>

						<div class="col-md-12 input-group-sm">
							<label for="frmFechaNacimiento" class="form-label">Fecha
								de nacimiento:</label> <input type="date" class="form-control"
															  id="frmFechaNacimiento" required>
						</div>

						<div class="col-md-6 input-group-sm">
							<label for="frmTipoCargo" class="form-label">Cargo:</label> <select
								class="form-select" aria-label="Seleccionar" id="frmTipoCargo">
							<option value="DOCT. POR HRS">DOCT. POR HRS</option>
							<option value="SUB. DIRECTORA">SUB. DIRECTORA</option>
							<option value="DIRECTOR">DIRECTOR</option>
							<option value="COORD.PEDAG">COORD.PEDAG</option>
							<option value="COORD DE TUT.">COORD DE TUT.</option>
							<option value="JEIE DE LABORA.">JEIE DE LABORA.</option>
							<option value="DOCT. DE PIP.">DOCT. DE PIP.</option>
						</select>
						</div>

						<div class="col-md-6 input-group-sm">
							<label for="frmTipoCondicion" class="form-label">Condición:</label>
							<select class="form-select" aria-label="Seleccionar"
									id="frmTipoCondicion">
								<option value="N">NOMBRADO</option>
								<option value="E">ENCARGADO</option>
								<option value="C">CONTRATADO</option>
							</select>
						</div>

						<div class="col-md-4 input-group-sm">
							<label for="frmJornadaLaboral" class="form-label">Jornada
								laboral:</label> <input type="number" class="form-control"
														id="frmJornadaLaboral" required>
						</div>

					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal" id="btnCancelarProfesor">Cancelar</button>
					<button type="submit" class="btn btn-primary"
							id="btnGuardarProfesor" disabled>Guardar</button>
				</div>
			</div>
		</div>
	</div>

	
	<!-- Modal -->
	<div class="modal fade" id="confirmacionModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="staticBackdropLabel">Confirmación</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        ¿Estas seguro de desactivar a este profesor?
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
	        <button type="button" class="btn btn-primary" id="btnConfirmar">Confirmar</button>
	      </div>
	    </div>
	  </div>
	</div>
	
</div>

<!-- Es importante que este "allscript.jsp" este primero -->
<%@include file="component/allscript.jsp" %>

<!-- 	Script para gestionar las funciones de esta vista -->
<script type="text/javascript" src="js/teacher.js"></script>
<script type="text/javascript" src="js/teacherExportaciones.js"></script>
<script type="text/javascript" src="js/teacherValidation.js"></script>

</body>
</html>