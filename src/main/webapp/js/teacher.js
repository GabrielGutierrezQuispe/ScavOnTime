//import {createToast} from './toast.js';

// Constantes del CRUD
const ACCION_NUEVO = "NUEVO";
const ACCION_EDITAR = "EDITAR";
let soloActivos = 'A';
let personaIdSeleccionada;

//Acceder a control de boton buscar
let inputBuscarProfesor = document.getElementById('idBuscarProfesor');
let filtroTipoDocumento = document.getElementById('idSelectTipoDocumento');

//Accerder a control de boton guardar 
let btnGuardarProfesor = document.getElementById('btnGuardarProfesor');
btnGuardarProfesor.addEventListener('click', fnProcesarProfesor);

// Acceder al modal
//let profesorModal = document.getElementById('profesorModal');
//let modal;
//			
//window.addEventListener('load', function() {
//  modal = bootstrap.Modal.getInstance(profesorModal); // Returns a Bootstrap modal instance
//});

profesorModal.addEventListener('hidden.bs.modal', function (event) {
  fnLimpiarForm();
});

let btnNuevo = document.getElementById('btnNuevo');
btnNuevo.addEventListener('click', fnCrearProfesor);

//Filtro para activar por DNI O CNE
filtroTipoDocumento.addEventListener('change', fnBuscarProfesor);

let activeCheckbox = document.getElementById("idActiveCheckbox");
activeCheckbox.addEventListener('change', function() {
	if (activeCheckbox.checked) {
		soloActivos = 'A';
	} else {
		soloActivos = 'I';
	}
	fnBuscarProfesor();
});

let listaProfesores = [];

let timeoutId;
window.onload = fnBuscarProfesor;

inputBuscarProfesor.addEventListener('input', function() {
  clearTimeout(timeoutId);
});

inputBuscarProfesor.addEventListener('keyup', () => {
	clearTimeout(timeoutId);

	timeoutId = setTimeout(function() {
		console.log('Han pasado 0.5 segundos');
		fnBuscarProfesor();
	}, 500);
});

inputBuscarProfesor.addEventListener('search', fnBuscarProfesor);


//Funcion para crear profesor
function fnCrearProfesor(){
	let profesorModal = document.querySelector('#profesorModal');
	let modal = bootstrap.Modal.getOrCreateInstance(profesorModal);
	modal.show();
	
	document.getElementById("accion").value = ACCION_NUEVO;
	document.getElementById('profesorModalLabel').innerHTML = 'Crear nuevo profesor';
}



//Funcion para crear o editar un profesor.
function fnProcesarProfesor() {
	console.log('Guardando.......');

	//	 Obteniendo los datos del formulario de profesores
	let accionSeleccionada = document.getElementById('accion').value
	let datos = 'accion=' + accionSeleccionada;
	datos += "&id=" + document.getElementById("frmId").value;
	datos += '&document_type=' + document.getElementById('frmTipoDocumento').value;
	datos += '&document_number=' + document.getElementById('frmNumeroDocumento').value;
	datos += '&names=' + document.getElementById('frmNombres').value;
	datos += '&lastnames=' + document.getElementById('frmApellidos').value;
	datos += '&birthdate=' + document.getElementById('frmFechaNacimiento').value;
	datos += '&type_charge=' + document.getElementById('frmTipoCargo').value;
	datos += '&type_condition=' + document.getElementById('frmTipoCondicion').value;
	datos += '&workday=' + document.getElementById('frmJornadaLaboral').value;

	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'TeacherProcesar', true);
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {
			// La solicitud se completó correctamente
			console.log(xhr.responseText);
			let profesorModal = document.querySelector('#profesorModal');
			let modal = bootstrap.Modal.getOrCreateInstance(profesorModal);

			modal.hide();
			fnLimpiarForm();
			fnBuscarProfesor();
			
			if (accionSeleccionada == ACCION_NUEVO) {
				createToast('success', 'Profesor creado correctamente');
			}
			if (accionSeleccionada === ACCION_EDITAR) {
				createToast('success', 'Profesor editado correctamente');
			}
		}
	};
	xhr.send(datos);

	console.log('Datos: ', datos);
}



//Funcion para listar profesores
function fnBuscarProfesor() {
	console.log('Buscando.......');

	//datos
	let filter = inputBuscarProfesor.value;
	
	//Preparando la URL
	let url = 'TeacherBuscar?active='+ soloActivos + '&filter=' + filter + '&documentType=' + filtroTipoDocumento.value;
	//La llama AJAX
	let xhttp = new XMLHttpRequest();
	xhttp.open('GET', url, true);
	xhttp.onreadystatechange = function() {

		if (this.readyState == 4 && this.status == 200) {
			let respuesta = xhttp.responseText;
			listaProfesores = JSON.parse(respuesta);
			let detalleTabla = '';
			listaProfesores
				.forEach(function(item) {
					
					detalleTabla += `
						<tr>
							<td>${item.id}</td>
							<td>${item.documentType}</td>
							<td>${item.documentNumber}</td>
							<td>${item.names}</td>
							<td>${item.lastnames}</td>
							<td>${moment(item.birthdate).format('DD MMM YYYY')}</td>
							<td>${item.typeCharge}</td>
							<td>${obtenerTipoCondicion(item.typeCondition)}</td>
							<td>${item.workday}</td>
							<td>
								<div class='d-flex gap-2'>
									${obtenerBtnEditar(item.id)}
									${obtenerTipoBtnActivo(item.active, item.id)}
								</div>
							</td>
						</tr>
					`;
				});
			document.getElementById("detalleTabla").innerHTML = detalleTabla;
		}
	};
	xhttp.send();
}

function obtenerBtnEditar(profesorId) {
	if (soloActivos === 'A') {
		return `
			<button type='button' class='btn btn-light' onclick='fnEditarProfesor(${profesorId})'>
				<i class='bx bxs-edit'></i>
			</button>		
		`;
	} 
	
	if (soloActivos === 'I') {
		return '';
	}
}

function obtenerTipoBtnActivo(estado, profesorId) {
	if (estado === 'A') {
			return `<button type='button' class='btn btn-light' onclick='abrirModalConfirmar(${profesorId})'>
						<i class='bx bxs-trash' style='color: #dc3545;'></i>
					</button>`;
	} else {
		return `<button type='button' class='btn btn-light' onclick='fnActivar(${profesorId})'>
					<i class='bx bxs-share' style='color: #20c997;'></i>

				</button>`;
	}
}	

function abrirModalConfirmar(profesorId) {
	personaIdSeleccionada = profesorId;
	let confirmacionModal = document.querySelector('#confirmacionModal');
	let modal = bootstrap.Modal.getOrCreateInstance(confirmacionModal);
	modal.show();
}

let btnConfirmar = document.getElementById('btnConfirmar');
btnConfirmar.addEventListener('click', () => fnEliminar(personaIdSeleccionada));
	
//Funcion para reactivar profesor
function fnActivar(id) {
  console.log('id: ', id);
  
  let datos = 'id=' + id;
  
  let xhr = new XMLHttpRequest();
  xhr.open('POST', 'TeacherActivar', true);
  xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4 && xhr.status === 200) {
      // La solicitud se completó correctamente
      console.log(xhr.responseText);
      createToast('success', 'Profesor reactivado correctamente');
      fnBuscarProfesor();
    }
  };
  xhr.send(datos);
}
//Funcion para editar o actualizar profesor
function fnEditarProfesor(id) {
	console.log('id: ', id);
	document.getElementById("accion").value = ACCION_EDITAR;
	document.getElementById('profesorModalLabel').innerHTML = 'Editar profesor';
	
	let profesorModal = document.querySelector('#profesorModal');
	let modal = bootstrap.Modal.getOrCreateInstance(profesorModal);
	modal.show();
	
	fnCargarForm(id);


	profesorModal.addEventListener("hidden.bs.modal", fnLimpiarForm);
}


//Funcion para eliminar profesor
function fnEliminar(id) {
	console.log('id: ', id);
	
	let datos = 'id=' + id;
	
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'TeacherEliminar', true);
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {
			// La solicitud se completó correctamente
			console.log(xhr.responseText);
			createToast('info', 'Profesor desactivado correctamente');
			
			let confirmacionModal = document.querySelector('#confirmacionModal');
			let modal = bootstrap.Modal.getOrCreateInstance(confirmacionModal);
			modal.hide();
			
			fnBuscarProfesor();
		}
	};
	xhr.send(datos);

}

//Funcion para cargar formulario de profesor
function fnCargarForm(id){
	const profesorEncontrado = listaProfesores.find(profesor => profesor.id === id);
	document.getElementById('frmId').value = profesorEncontrado.id;
	document.getElementById('frmTipoDocumento').value = profesorEncontrado.documentType;
	document.getElementById('frmNumeroDocumento').value = profesorEncontrado.documentNumber;
	document.getElementById('frmNombres').value = profesorEncontrado.names;
	document.getElementById('frmApellidos').value = profesorEncontrado.lastnames;
	document.getElementById('frmFechaNacimiento').value = new Date(profesorEncontrado.birthdate).toISOString().split("T")[0];
	document.getElementById('frmTipoCargo').value = profesorEncontrado.typeCharge;
	document.getElementById('frmTipoCondicion').value = profesorEncontrado.typeCondition;
	document.getElementById('frmJornadaLaboral').value = profesorEncontrado.workday;
	
	console.log('profesor', profesorEncontrado);
}

//Funcion para limpiar el formulario de profesor
function fnLimpiarForm(){
	document.getElementById('frmId').value = '';
	document.getElementById('frmTipoDocumento').selectedIndex = 0;
	document.getElementById('frmNumeroDocumento').value = '';
	document.getElementById('frmNombres').value = '';
	document.getElementById('frmApellidos').value = '';
	document.getElementById('frmFechaNacimiento').value = '';
	document.getElementById('frmTipoCargo').selectedIndex = 0;
	document.getElementById('frmTipoCondicion').selectedIndex = 0;
	document.getElementById('frmJornadaLaboral').value = '';
	
	fnLimpiarValidaciones();
	
}

function fnLimpiarValidaciones() {	
	document.getElementById('frmNumeroDocumento').classList.remove('is-invalid');
    document.getElementById('frmNumeroDocumento').classList.remove('is-valid');
    
    document.getElementById('frmNombres').classList.remove('is-invalid');
    document.getElementById('frmNombres').classList.remove('is-valid');
    
    document.getElementById('frmApellidos').classList.remove('is-invalid');
    document.getElementById('frmApellidos').classList.remove('is-valid');
    
    document.getElementById('frmJornadaLaboral').classList.remove('is-invalid');
    document.getElementById('frmJornadaLaboral').classList.remove('is-valid');
}

function obtenerTipoCondicion(condicion){
	if (condicion === 'E') {
		return 'Encargado';
	} else if (condicion === 'C') {
		return 'Contratado';
	} else if (condicion === 'N'){
		return 'Nombrado';
	} else {
		return 'No definido';
	}
}	
	