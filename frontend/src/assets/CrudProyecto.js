window.onload = function () {
    listarProyectos();
}

let listarProyectos = async () => {
    // Obtener los proyectos desde la API
    const respuesta = await fetch('http://localhost:8080/api/proyecto', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });

    // Convertir la respuesta en JSON
    const proyectos = await respuesta.json(); // Corregido: respuesta.json()

    // Crear contenido para la tabla
    let contenidoTabla = "";

    for (let proyecto of proyectos) {
        let contenidoFila = `
            <tr>
                <td>${proyecto.id}</td>
                <td>${proyecto.nombre}</td>
                <td>${proyecto.descripcion}</td>
                <td><button onClick="editarProyecto(${proyecto.id})" class="btn-editar">Editar</button></td>
                <td><button onClick="borrarProyecto(${proyecto.id})" class="btn-eliminar">Eliminar</button></td>
            </tr>
        `;
        contenidoTabla += contenidoFila;
    }

    // Actualizar solo el contenido del tbody
    document.querySelector('#tablaProyectos tbody').innerHTML = contenidoTabla; // Corregido: innerHTML
}

let borrarProyecto = async (id) => {
    const respuesta = await fetch(`http://localhost:8080/api/proyecto/${id}`, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });

    listarProyectos();
}

function mostrarFormulario() {
    let formulario = document.getElementById("formEditarProyecto");
    if (formulario) {
        formulario.style.visibility = "visible";
    } else {
        console.error('Formulario con ID "formEditarProyecto" no encontrado.');
    }
}

function ocultarFormulario() {
    let formulario = document.getElementById("formEditarProyecto");
    if (formulario) {
        formulario.style.visibility = "hidden";
    } else {
        console.error('Formulario con ID "formEditarProyecto" no encontrado.');
    }
}

let idEditar;

let editarProyecto = async (id) => {
    mostrarFormulario();
    idEditar = id;

    const peticion = await fetch(`http://localhost:8080/api/proyecto/${id}`, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    const proyecto = await peticion.json();

    console.log('Proyecto recibido:', proyecto);

    document.getElementById("codigoProyecto").value = proyecto.codigoProyecto;
    document.getElementById("descripcionProyecto").value = proyecto.descripcionProyecto;
    document.getElementById("horasProyecto").value = proyecto.horasProyecto;
    // Asegúrate de que el formulario tiene los campos correspondientes
}

document.addEventListener('DOMContentLoaded', function() {
    let btnModificar = document.getElementById("btnModificar");
    if (btnModificar) {
        btnModificar.addEventListener("click", evento => {
            evento.preventDefault(); // Evita el envío del formulario para la demostración
            aplicarActualizacion(idEditar);
        });
    } else {
        console.error('El botón con ID "btnModificar" no se encuentra en el DOM.');
    }
});

let aplicarActualizacion = async (id) => {
    // Recopilar datos de los campos del formulario
    let campos = {
        id: id,  // Usa el ID que recibes como parámetro
        codigoProyecto: document.getElementById('codigoProyecto').value,
        descripcionProyecto: document.getElementById('descripcionProyecto').value,
        horasProyecto: document.getElementById('horasProyecto').value
        // Asegúrate de que el formulario tiene los campos correspondientes
    };

    try {
        // Realizar la solicitud PUT
        const respuesta = await fetch(`http://localhost:8080/api/proyecto/${id}`, {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(campos)
        });

        // Verificar si la respuesta es exitosa
        if (!respuesta.ok) {
            const errorText = await respuesta.text();
            throw new Error(`Error en la solicitud: ${respuesta.status} ${respuesta.statusText} - ${errorText}`);
        }

        // Procesar la respuesta si es exitosa
        const datos = await respuesta.json();
        console.log('Proyecto actualizado con éxito:', datos);

        // Llama a una función para actualizar la lista de proyectos
        listarProyectos();
        ocultarFormulario();

    } catch (error) {
        console.error('Detalles del error:', error);
        alert('Ocurrió un error al actualizar el proyecto. Por favor, inténtelo de nuevo.');
    }
}
