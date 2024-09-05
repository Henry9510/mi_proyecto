


/*

let registrarEmpleado = async () => {
    // Datos de ejemplo para enviar al servidor
    let empleados = [
        { "nombre": "Carla", "primerNombre": "Sofía", "segundoNombre": "", "apellido": "Castro", "segundoApellido": "Moreno", "cargo": "Diseñador UX/UI", "edad": 27, "cedula": "301234567", "fechaIngreso": "01/03/2024" },
        { "nombre": "Ricardo", "primerNombre": "Alejandro", "segundoNombre": "", "apellido": "Hernández", "segundoApellido": "Reyes", "cargo": "Arquitecto de Datos", "edad": 34, "cedula": "312345678", "fechaIngreso": "05/03/2024" },
        { "nombre": "Laura", "primerNombre": "Carolina", "segundoNombre": "", "apellido": "Mendoza", "segundoApellido": "García", "cargo": "Especialista en SEO", "edad": 29, "cedula": "323456789", "fechaIngreso": "12/03/2024" },
        { "nombre": "Jorge", "primerNombre": "Luis", "segundoNombre": "", "apellido": "Sierra", "segundoApellido": "Martínez", "cargo": "Consultor de IT", "edad": 38, "cedula": "334567890", "fechaIngreso": "15/03/2024" },
        { "nombre": "Marta", "primerNombre": "Isabel", "segundoNombre": "", "apellido": "Jaramillo", "segundoApellido": "Pérez", "cargo": "Gestor de Proyectos", "edad": 42, "cedula": "345678901", "fechaIngreso": "20/03/2024" },
        { "nombre": "Héctor", "primerNombre": "Gabriel", "segundoNombre": "", "apellido": "Vega", "segundoApellido": "Ruiz", "cargo": "Desarrollador de Back-end", "edad": 31, "cedula": "356789012", "fechaIngreso": "25/03/2024" },
        { "nombre": "Pablo", "primerNombre": "Eduardo", "segundoNombre": "", "apellido": "Torres", "segundoApellido": "Hernández", "cargo": "Analista de Seguridad", "edad": 33, "cedula": "367890123", "fechaIngreso": "28/03/2024" },
        { "nombre": "Sabrina", "primerNombre": "Alejandra", "segundoNombre": "", "apellido": "Martínez", "segundoApellido": "Castaño", "cargo": "Administrador de Sistemas", "edad": 30, "cedula": "378901234", "fechaIngreso": "02/04/2024" },
        { "nombre": "Felipe", "primerNombre": "Andrés", "segundoNombre": "", "apellido": "Cuellar", "segundoApellido": "Gómez", "cargo": "Ingeniero de DevOps", "edad": 36, "cedula": "389012345", "fechaIngreso": "05/04/2024" },
        { "nombre": "Natalia", "primerNombre": "Catalina", "segundoNombre": "", "apellido": "García", "segundoApellido": "Martínez", "cargo": "Especialista en Big Data", "edad": 32, "cedula": "390123456", "fechaIngreso": "10/04/2024" },
        { "nombre": "Ricardo", "primerNombre": "Daniel", "segundoNombre": "", "apellido": "Molina", "segundoApellido": "Ríos", "cargo": "Desarrollador Full-Stack", "edad": 28, "cedula": "401234567", "fechaIngreso": "15/04/2024" },
        { "nombre": "Isabel", "primerNombre": "Cristina", "segundoNombre": "", "apellido": "Reyes", "segundoApellido": "Moreno", "cargo": "Ingeniero de Software", "edad": 37, "cedula": "412345678", "fechaIngreso": "18/04/2024" },
        { "nombre": "Daniel", "primerNombre": "Alejandro", "segundoNombre": "", "apellido": "Gómez", "segundoApellido": "García", "cargo": "Analista de Negocios", "edad": 29, "cedula": "423456789", "fechaIngreso": "22/04/2024" },
        { "nombre": "Andrea", "primerNombre": "Valentina", "segundoNombre": "", "apellido": "Paredes", "segundoApellido": "Sánchez", "cargo": "Desarrollador Web", "edad": 26, "cedula": "434567890", "fechaIngreso": "25/04/2024" },
        { "nombre": "Luis", "primerNombre": "Fernando", "segundoNombre": "", "apellido": "Salazar", "segundoApellido": "Pérez", "cargo": "Administrador de Redes", "edad": 33, "cedula": "445678901", "fechaIngreso": "28/04/2024" },
        { "nombre": "María", "primerNombre": "José", "segundoNombre": "", "apellido": "Castro", "segundoApellido": "Gutiérrez", "cargo": "Consultor de Marketing", "edad": 40, "cedula": "456789012", "fechaIngreso": "01/05/2024" },
        { "nombre": "Julián", "primerNombre": "David", "segundoNombre": "", "apellido": "Tovar", "segundoApellido": "Vargas", "cargo": "Desarrollador Front-end", "edad": 27, "cedula": "467890123", "fechaIngreso": "05/05/2024" },
        { "nombre": "Camila", "primerNombre": "Fernanda", "segundoNombre": "", "apellido": "Vásquez", "segundoApellido": "Hernández", "cargo": "Ingeniero de Software", "edad": 31, "cedula": "478901234", "fechaIngreso": "10/05/2024" },
        { "nombre": "Santiago", "primerNombre": "Alejandro", "segundoNombre": "", "apellido": "Montoya", "segundoApellido": "Gómez", "cargo": "Desarrollador de Aplicaciones", "edad": 28, "cedula": "489012345", "fechaIngreso": "15/05/2024" },
        { "nombre": "Valentina", "primerNombre": "Mariana", "segundoNombre": "", "apellido": "Cruz", "segundoApellido": "Sánchez", "cargo": "Especialista en UX/UI", "edad": 30, "cedula": "490123456", "fechaIngreso": "20/05/2024" },
        { "nombre": "Nicolás", "primerNombre": "Gabriel", "segundoNombre": "", "apellido": "Mendoza", "segundoApellido": "Hernández", "cargo": "Arquitecto de Soluciones", "edad": 35, "cedula": "501234567", "fechaIngreso": "25/05/2024" },
        { "nombre": "Juliana", "primerNombre": "Andrea", "segundoNombre": "", "apellido": "Ríos", "segundoApellido": "Cuéllar", "cargo": "Ingeniero de QA", "edad": 29, "cedula": "512345678", "fechaIngreso": "30/05/2024" },
        { "nombre": "Fernando", "primerNombre": "Antonio", "segundoNombre": "", "apellido": "García", "segundoApellido": "Ríos", "cargo": "Analista de Sistemas", "edad": 32, "cedula": "523456789", "fechaIngreso": "01/06/2024" }
    ];

    for (let empleado of empleados) {
        try {
            // Enviar el dato del empleado al servidor
            const respuesta = await fetch('http://localhost:8080/api/empleado', {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(empleado) // Convierte el objeto a una cadena JSON
            });

            // Verifica si la respuesta es exitosa
            if (!respuesta.ok) {
                const respuestaTexto = await respuesta.text(); // Obtener respuesta en texto
                console.log('Respuesta del servidor:', respuestaTexto);
                throw new Error(`Error en la solicitud: ${respuesta.statusText}`);
            }

            // Procesa la respuesta JSON
            const datos = await respuesta.json();
            console.log('Empleado registrado con éxito:', datos);

        } catch (error) {
            console.error('Error al registrar el empleado:', error);
            alert('Ocurrió un error al registrar el empleado. Por favor, inténtelo de nuevo.');
        }
    }


}*/
// Obtener el elemento de entrada y el contenedor de salida


// Función para actualizar el contenido del contenedor de salida


let timeoutId; // Variable para almacenar el identificador del temporizador

document.getElementById('cedula').addEventListener('input', function () {
    // Limpia el temporizador anterior si existe
    clearTimeout(timeoutId);

    // Configura un nuevo temporizador para hacer la búsqueda después de 500 ms
    timeoutId = setTimeout(buscarEmpleado, 500);
});

async function buscarEmpleado() {
    const cedulaBuscada = document.getElementById('cedula').value.trim();
    
    // Convertir la cédula a número si es necesario
    const cedulaBuscadaNumero = parseInt(cedulaBuscada, 10);
    if (!cedulaBuscada) {
        // Si no hay cédula, no hacer nada
        return;
    }

    try {
        const respuesta = await fetch(`http://localhost:8080/api/empleado`, {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
        });

        if (!respuesta.ok) {
            throw new Error(`Error en la respuesta de la red: ${respuesta.statusText}`);
        }

        const empleado = await respuesta.json(); // Aquí se espera que sea un objeto, no un array

        console.log('Datos recibidos:', empleado);

        console.log('Cédula Buscada:', cedulaBuscada);

        const empleadoEncontrado = empleado.find(emp => emp.cedula === cedulaBuscadaNumero);

        if (empleadoEncontrado) {
            console.log('Empleado encontrado:', empleadoEncontrado);

            
            
            // Actualiza los campos del formulario
            document.getElementById('primer_nombre').value = empleadoEncontrado.nombre || '';
            document.getElementById('segundo_nombre').value = empleadoEncontrado.segundoNombre || '';
            document.getElementById('primer_apellido').value = empleadoEncontrado.apellido || '';
            document.getElementById('segundo_apellido').value = empleadoEncontrado.segundoApellido || '';
        } else {
            console.log('No se encontró ningún empleado con esa cédula.');
            // Limpiar los campos si no se encuentra el empleado
            document.getElementById('primer_nombre').value = '';
            document.getElementById('segundo_nombre').value = '';
            document.getElementById('primer_apellido').value = '';
            document.getElementById('segundo_apellido').value = '';
            console.log('No se encontró ningún empleado con esa cédula.');
        }

    } catch (error) {
        console.error('Error:', error);
        console.log('Hubo un problema al buscar el empleado: ' + error.message);
    }
}





let registrarHoras = async () => {
    // Recolecta los datos del formulario

    let campos = {
        numeroProyecto: document.getElementById('proyecto').value.trim(),
        descripcionProyecto: document.getElementById('horas').value.trim(),
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

