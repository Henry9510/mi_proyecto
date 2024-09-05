window.onload = function () {
    listarEmpleado();
}





let listarEmpleado = async () => {

    const respuesta = await fetch('http://localhost:8080/api/empleado', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });

    // Convertir la respuesta en JSON
    const empleados = await respuesta.json(); // Corregido: respuesta.json()

    // Crear contenido para la tabla
    let contenidoTabla = "";


    for (let empleado of empleados) {
        let contenidoFila = `<tr>
                <td>${empleado.id}</td>
                <td>${empleado.cedula}</td>
                <td>${empleado.nombre}</td>
                <td>${empleado.segundoNombre || ''}</td>
                <td>${empleado.apellido}</td>
                <td>${empleado.segundoApellido || ''}</td>
                <td>${empleado.edad}</td>
                <td>${empleado.cargo}</td>
                <td>${empleado.fechaIngreso}</td>
                <td><button onclick="editarEmpleado(${empleado.id})" class="btn-editar">Editar</button></td>
                <td><button onclick="borrarEmpleado(${empleado.id})" class="btn-eliminar">Eliminar</button></td>
            </tr>`;
        contenidoTabla += contenidoFila;
    }

    // Actualizar solo el contenido del tbody
    document.querySelector('#tablaEmpleados tbody').innerHTML = contenidoTabla; // Corregido: innerHTML
}



// Función para borrar un empleado
window.borrarEmpleado = async (id) => {
    try {
        const respuesta = await fetch(`http://localhost:8080/api/empleado/${id}`, {
            method: 'DELETE'
        });

        if (!respuesta.ok) {
            throw new Error(`Error en la solicitud: ${respuesta.statusText}`);
        }

        console.log('Empleado borrado con éxito');
        await listarEmpleado();
    } catch (error) {
        console.error('Error al borrar el empleado:', error);
        alert('Ocurrió un error al borrar el empleado. Por favor, inténtelo de nuevo.');
    }
}



function mostrarFormulario() {
    let formulario = document.getElementById("formEditarEmpleado");
    if (formulario) {
        formulario.style.visibility = "visible";
    } else {
        console.error('Formulario con ID "formEditarProyecto" no encontrado.');
    }
}

function ocultarFormulario() {
    let formulario = document.getElementById("formEditarEmpleado");
    if (formulario) {
        formulario.style.visibility = "hidden";
    } else {
        console.error('Formulario con ID "formEditarProyecto" no encontrado.');
    }
}

let idEditar;

let editarEmpleado = async (id) => {
    mostrarFormulario();
    idEditar = id;


    try {
        const respuesta = await fetch(`http://localhost:8080/api/empleado/${id}`);
        if (!respuesta.ok) {
            throw new Error(`Error en la solicitud: ${respuesta.statusText}`);
        }

        const empleado = await respuesta.json();

        document.getElementById('cedula').value = empleado.cedula;
        document.getElementById('primer_nombre').value = empleado.nombre;
        document.getElementById('segundo_nombre').value = empleado.segundoNombre || '';
        document.getElementById('primer_apellido').value = empleado.apellido;
        document.getElementById('segundo_apellido').value = empleado.segundoApellido || '';
        document.getElementById('edad').value = empleado.edad;
        document.getElementById('cargo').value = empleado.cargo;
        document.getElementById('fecha_ingreso').value = empleado.fechaIngreso;
    } catch (error) {
        console.error('Error al cargar los datos del empleado:', error);
    }
}



document.addEventListener('DOMContentLoaded', function() {
    let btnModificar = document.getElementById("btnModificarEmpleado");
    if (btnModificar) {
        btnModificar.addEventListener("click", evento => {
            evento.preventDefault(); // Evita el envío del formulario para la demostración
            actualizarEmpleado(idEditar);
            ocultarFormulario()
        });
    } else {
        console.error('El botón con ID "btnModificar" no se encuentra en el DOM.');
    }
});




// Función para actualizar la información de un empleado existente
let actualizarEmpleado = async (id) => {
     // Asume que tienes un campo oculto o de otro tipo para el ID del empleado
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
        const respuesta = await fetch(`http://localhost:8080/api/empleado/${id}`, {
            method: 'PUT',
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
        console.log('Empleado actualizado con éxito:', datos);

        await listarEmpleado();

    } catch (error) {
        console.error('Error al actualizar el empleado:', error);
        alert('Ocurrió un error al actualizar el empleado. Por favor, inténtelo de nuevo.');
    }
}

