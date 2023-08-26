function updateSelection(field, value) {
	document.getElementById(field + "Selection").textContent = value;
}


function actualizarHora() {
	var fecha = new Date();
	var hora = fecha.getHours();
	var minutos = fecha.getMinutes();
	var segundos = fecha.getSeconds();
	var amPm = hora >= 12 ? "PM" : "AM";
	hora = hora % 12;
	hora = hora ? hora : 12;
	var horaActual = hora + ':' + minutos + ':' + segundos + ' ' + amPm;
	document.getElementById('horaActual').innerText = horaActual;
}

setInterval(actualizarHora, 1000);


/*Funcion contnedor de seleccion*/
document.getElementById("primero").addEventListener("click", function() {
	document.getElementById("gradoSeleccionado").textContent = "1\u00B0 Grado";
});

document.getElementById("segundo").addEventListener("click", function() {
	document.getElementById("gradoSeleccionado").textContent = "2\u00B0 Grado";
});

document.getElementById("tercero").addEventListener("click", function() {
	document.getElementById("gradoSeleccionado").textContent = "3\u00B0 Grado";
});

document.getElementById("cuarto").addEventListener("click", function() {
	document.getElementById("gradoSeleccionado").textContent = "4\u00B0 Grado";
});

document.getElementById("quinto").addEventListener("click", function() {
	document.getElementById("gradoSeleccionado").textContent = "5\u00B0 Grado";
});

document.getElementById("seccionA").addEventListener("click", function() {
	document.getElementById("seccionSeleccionada").textContent = "A";
});

document.getElementById("seccionB").addEventListener("click", function() {
	document.getElementById("seccionSeleccionada").textContent = "B";
});

document.getElementById("seccionC").addEventListener("click", function() {
	document.getElementById("seccionSeleccionada").textContent = "C";
});

document.getElementById("materiaM").addEventListener("click", function() {
	document.getElementById("materiaSeleccionada").textContent = "Matematicas";
});

document.getElementById("materiaE").addEventListener("click", function() {
	document.getElementById("materiaSeleccionada").textContent = "Educacion Fisica";
});

document.getElementById("materiaC").addEventListener("click", function() {
	document.getElementById("materiaSeleccionada").textContent = "Comunicacion";
});

document.getElementById("materiaI").addEventListener("click", function() {
	document.getElementById("materiaSeleccionada").textContent = "Ingles";
});

document.getElementById("materiaA").addEventListener("click", function() {
	document.getElementById("materiaSeleccionada").textContent = "Arte";
});

document.getElementById("materiaDP").addEventListener("click", function() {
	document.getElementById("materiaSeleccionada").textContent = "DPCC";
});

document.getElementById("materiaF").addEventListener("click", function() {
	document.getElementById("materiaSeleccionada").textContent = "Fisica";
});

document.getElementById("materiaCS").addEventListener("click", function() {
	document.getElementById("materiaSeleccionada").textContent = "Ciencias Sociales";
});

document.getElementById("materiaEPT").addEventListener("click", function() {
	document.getElementById("materiaSeleccionada").textContent = "EPT";
});

document.getElementById("materiaER").addEventListener("click", function() {
	document.getElementById("materiaSeleccionada").textContent = "Educacion Religiosa";
});

document.getElementById("materiaCT").addEventListener("click", function() {
	document.getElementById("materiaSeleccionada").textContent = "Ciencia y Tecnologia";
});

document.getElementById("materiaT").addEventListener("click", function() {
	document.getElementById("materiaSeleccionada").textContent = "Tutoria";
});

function actualizarTurno() {
	var horaActual = new Date().getHours();
	var turno = horaActual >= 12 ? "Tarde" : "Ma\u00F1ana";
	document.getElementById("turnoActual").textContent = turno;
}

setInterval(actualizarTurno, 1000);
actualizarTurno();