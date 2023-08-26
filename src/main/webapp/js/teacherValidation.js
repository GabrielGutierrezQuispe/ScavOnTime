// Validacion de campo N° de Documrnto.
const frmNumeroDocumento = document.getElementById('frmNumeroDocumento');
const inputNumeroDocumentoError = document.getElementById('inputNumeroDocumentoError');
const frmTipoDocumento = document.getElementById('frmTipoDocumento');

frmNumeroDocumento.addEventListener('keydown', function(event) {
	const keyCode = event.keyCode || event.which;
	const inputValue = this.value.trim();
	const tipoDocumento = frmTipoDocumento.value;
	const maxDigitos = tipoDocumento === 'CNE' ? 9 : tipoDocumento === 'DNI' ? 8 : 0;

	if ((keyCode < 48 || keyCode > 57) && ![8, 46].includes(keyCode)) {
		event.preventDefault();
	} else if (inputValue.length >= maxDigitos && ![8, 46].includes(keyCode)) {
		event.preventDefault();
	}
});

function validarNumeroDocumento() {
	const inputValue = frmNumeroDocumento.value.trim();
	const tipoDocumento = frmTipoDocumento.value;
	const maxDigitos = tipoDocumento === 'CNE' ? 9 : tipoDocumento === 'DNI' ? 8 : 0;

	frmNumeroDocumento.classList.toggle('is-invalid', inputValue === '' || inputValue.length !== maxDigitos);
	frmNumeroDocumento.classList.toggle('is-valid', inputValue !== '' && inputValue.length === maxDigitos);

	inputNumeroDocumentoError.textContent = inputValue === '' ? 'Este campo es obligatorio.' : inputValue.length !== maxDigitos ? `Se requieren ${maxDigitos} números para ${tipoDocumento}.` : '';
}

frmNumeroDocumento.addEventListener('input', validarNumeroDocumento);
frmNumeroDocumento.addEventListener('blur', validarNumeroDocumento);
frmTipoDocumento.addEventListener('change', validarNumeroDocumento);


// Validacion de campo Nombres
var inputNombres = document.getElementById('frmNombres');
var inputNombresError = document.getElementById('inputNombresError');
var regex = /^[a-zA-Z\s]*$/; // Expresión regular para permitir solo letras y espacios

inputNombres.addEventListener('keydown', function(event) {
    var isValidKey = event.key.match(/^[a-zA-Z\s]|\s|Backspace|Delete|ArrowLeft|ArrowRight$/);
    if (!isValidKey) {
        event.preventDefault();
        inputNombresError.textContent = 'Solo puedes ingresar letras.';
    } else {
        inputNombresError.textContent = '';
    }
});

inputNombres.addEventListener('blur', function() {
    var inputValue = this.value.trim();
    if (inputValue === '') {
        inputNombres.classList.add('is-invalid');
        inputNombresError.textContent = 'Este campo es obligatorio.';
    } else if (!regex.test(inputValue)) {
        inputNombres.classList.add('is-invalid');
        inputNombresError.textContent = 'Por favor, ingresa solo letras y espacios.';
    } else {
        inputNombres.classList.remove('is-invalid');
        inputNombres.classList.add('is-valid');
        inputNombresError.textContent = '';
    }
});




// Validacion de campo Apellidos
var inputApellidos = document.getElementById('frmApellidos');
var inputApellidosError = document.getElementById('inputApellidosError');
var regex = /^[a-zA-Z\s]*$/; // Expresión regular para permitir solo letras y espacios

inputApellidos.addEventListener('keydown', function(event) {
    var isValidKey = event.key.match(/^[a-zA-Z\s]|\s|Backspace|Delete|ArrowLeft|ArrowRight$/);
    if (!isValidKey) {
        event.preventDefault();
        inputApellidosError.textContent = 'Solo puedes ingresar letras.';
    } else {
        inputApellidosError.textContent = '';
    }
});

inputApellidos.addEventListener('blur', function() {
    var inputValue = this.value.trim();
    if (inputValue === '') {
        inputApellidos.classList.add('is-invalid');
        inputApellidosError.textContent = 'Este campo es obligatorio.';
    } else if (!regex.test(inputValue)) {
        inputApellidos.classList.add('is-invalid');
        inputApellidosError.textContent = 'Por favor, ingresa solo letras y espacios.';
    } else {
        inputApellidos.classList.remove('is-invalid');
        inputApellidos.classList.add('is-valid');
        inputApellidosError.textContent = '';
    }
});

//Valiciones para jornada laboral
var inputJornadaLaboral = document.getElementById('frmJornadaLaboral');
var inputJornadaLaboralError = document.getElementById('inputJornadaLaboralError');

inputJornadaLaboral.addEventListener('input', function() {
    var inputValue = this.value.trim();
    inputValue = inputValue.replace(/\D/g, ''); // Eliminar cualquier carácter que no sea un dígito
    inputValue = inputValue.slice(0, 2); // Limitar la longitud máxima a 2 dígitos
    this.value = inputValue;

    if (inputValue === '') {
        inputJornadaLaboral.classList.add('is-invalid');
        inputJornadaLaboralError.textContent = 'Este campo es obligatorio.';
    } else {
        inputJornadaLaboral.classList.remove('is-invalid');
        inputJornadaLaboral.classList.add('is-valid');
        inputJornadaLaboralError.textContent = '';
    }
});


//Evento de activacion e inactivacion de button crear segun restricion brindada
document.getElementById('formProfesor').addEventListener('input', function() {
	var form = this;
	var isFormValid = form.checkValidity();
	document.getElementById('btnGuardarProfesor').disabled = !isFormValid;
});





