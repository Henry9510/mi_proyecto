
document.addEventListener('DOMContentLoaded', function () {
    // Selección del botón y asignación del evento
    let botonCrear = document.getElementById("btnNuevoProyecto");

    if (botonCrear) {
        botonCrear.addEventListener("click", async evento => {
            // Llama a la función para registrar un proyecto
            await registrarProyecto();


            console.log(campos);

            // Limpiar los campos del formulario
            document.getElementById('numeroProyecto').value = '';
            document.getElementById('descripcionProyecto').value = '';
            document.getElementById('horasEstimadas').value = '';
        });
    } else {
        console.error('El botón con ID no se encuentra en el DOM.');
    }
});

// Declaración de la función antes de su uso
let registrarProyecto = async () => {
    // Recolecta los datos del formulario

    let campos = {
        numeroProyecto: document.getElementById('numeroProyecto').value.trim(),
        descripcionProyecto: document.getElementById('descripcionProyecto').value.trim(),
        horasEstimadas: parseFloat(document.getElementById('horasEstimadas').value.trim())
    };



    try {
        const respuesta = await fetch('http://localhost:8080/api/proyecto', {
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
        console.log('Proyecto registrado con éxito:', datos);

        // Aquí podrías actualizar la lista de proyectos o realizar alguna otra acción
        // Por ejemplo: listarProyectos();

    } catch (error) {
        console.error('Error al registrar el proyecto:', error);
        alert('Ocurrió un error al registrar el proyecto. Por favor, inténtelo de nuevo.');
    }
}

