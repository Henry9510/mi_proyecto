document.addEventListener('DOMContentLoaded', function () {
    // Selección del botón y asignación del evento
    let botonCrear = document.getElementById("btnCrearEmpleado");

    if (botonCrear) {
        botonCrear.addEventListener("click", async evento => {
            evento.preventDefault(); // Evita que el formulario se envíe de la manera tradicional
            // Llama a la función para registrar un empleado
            await registrarEmpleado();
        });
    } else {
        console.error('El botón con ID no se encuentra en el DOM.');
    }
});

// Declaración de la función antes de su uso
let registrarEmpleado = async () => {
    // Recolecta los datos del formulario
    let campos = {
        cedula: parseInt(document.getElementById('cedula').value.trim()),
        nombre: document.getElementById('primer_nombre').value.trim(),
        segundoNombre: document.getElementById('segundo_nombre').value.trim(),
        apellido: document.getElementById('primer_apellido').value.trim(),
        segundoApellido: document.getElementById('segundo_apellido').value.trim(),
        edad: parseInt(document.getElementById('edad').value.trim(), 10),
        cargo: document.getElementById('cargo').value,
        fechaIngreso: document.getElementById('fecha_ingreso').value
    };

    try {
        const respuesta = await fetch('http://localhost:8080/api/empleado', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(campos)
        });

        if (!respuesta.ok) {
            throw new Error(`Error en la solicitud: ${respuesta.statusText}`);
        }

        const datos = await respuesta.json();
        console.log('Empleado registrado con éxito:', datos);

        // Limpiar los campos del formulario
        document.getElementById('formEmpleado').reset();

    } catch (error) {
        console.error('Error al registrar el empleado:', error);
        alert('Ocurrió un error al registrar el empleado. Por favor, inténtelo de nuevo.');
    }
}



document.addEventListener("DOMContentLoaded", function() {
    function openTab(evt, tabName) {
        var i, tabcontent, tablinks;

        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++) {
            tabcontent[i].style.display = "none";  
        }

        tablinks = document.getElementsByClassName("tablinks");
        for (i = 0; i < tablinks.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" active", "");
        }

        document.getElementById(tabName).style.display = "block";  
        evt.currentTarget.className += " active";
    }

    // Open the default tab
    document.querySelector(".tab button").click();
});