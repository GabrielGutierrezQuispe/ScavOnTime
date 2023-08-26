//Acceder a control de boton buscar
let btnBuscarAsistencia = document.getElementById('btnBuscar');
btnBuscarAsistencia.addEventListener('click', fnBuscarAsistencia);

let listaAsistencia = [];

// Funcion para buscar estudiantes
function fnBuscarAsistencia() {
	console.log('Buscando.......');

	// Preparando la URL
//	let url = 'StudentBuscar?search_criteria=' + searchCriteria + '&search_value=' + searchValue;
	let url = 'AssistanceBuscar?';

	// Llamada AJAX
	let xhttp = new XMLHttpRequest();
	xhttp.open('GET', url, true);
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			let respuesta = xhttp.responseText;
			listaAsistencia = JSON.parse(respuesta); // Actualizar la lista de estudiantes

			let detalleTabla = '';
			listaAsistencia.forEach(function(item) {
				detalleTabla += `
					<tr>
						<td class="text-center">${item.ID}</td>
						<td class="text-center">${item.ESTUDIANTE}</td>
						<td>${item.MATERIA}</td>
						<td>
							<div class='d-flex gap-2'>
								<button type='button' class='btn btn-light' onclick='fnEditar(${item.ID})'>
									<i class='bx bxs-edit'></i>
								</button>
								<button type='button' class='btn btn-light' onclick='fnEliminar(${item.ID})'>
									<i class='bx bxs-trash' style='color: #dc3545;'></i>
								</button>
								<button type='button' class='btn btn-light' onclick='fnEliminar(${item.ID})'>
									<i class='bx bxs-trash' style='color: #dc3545;'></i>
								</button>
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