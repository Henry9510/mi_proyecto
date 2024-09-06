document.addEventListener('DOMContentLoaded', function () {
    // Selección del botón y asignación del evento
    let botonRegistrarHoras = document.getElementById("BtnRegistrarHoras");

    if (botonRegistrarHoras) {
        botonRegistrarHoras.addEventListener("click", async evento => {
            evento.preventDefault(); // Evita que el formulario se envíe de la manera tradicional
            // Llama a la función para registrar un empleado
            await realizarRegistro();
        });
    } else {
        console.error('El botón con ID no se encuentra en el DOM.');
    }
});

// Declaración de la función antes de su uso
let realizarRegistro = async () => {
    // Recolecta los datos del formulario
    let campoHoras = {
        fecha: document.getElementById("fecha").value.trim(),
        usuario: parseInt(document.getElementById('cedula').value.trim(), 10),
        empleador: parseInt(document.getElementById('cedula').value.trim(), 10),
        proyecto: parseInt(document.getElementById('proyecto').value.trim(), 10),
        horasTrabajadasnar: parseInt(document.getElementById('horas').value.trim(), 10)
    };

    try {
        const respuesta = await fetch('http://localhost:8080/api/registro_horas', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(campoHoras)
        });

        if (!respuesta.ok) {
            throw new Error(`Error en la solicitud: ${respuesta.statusText}`);
        }

        const datos = await respuesta.json();
        console.log('Hora registrada con éxito:', datos);

        // Limpiar los campos del formulario
        document.getElementById('formregistrohoras').reset();

    } catch (error) {
        console.error('Error al registrar la hora:', error);
        alert('Ocurrió un error al registrar la hora. Por favor, inténtelo de nuevo.');
    }
}