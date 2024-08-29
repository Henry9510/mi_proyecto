window.onload = function () {
    listarProductos();
}

let listarProductos = async () => {
    try {
        // Obtener los productos desde la API
        const respuesta = await fetch('http://localhost:8080/api/producto', {
            method: 'GET',
            headers: { 
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
        });

        // Verificar si la respuesta es correcta
        if (!respuesta.ok) throw new Error(`Error: ${respuesta.statusText}`);

        // Convertir la respuesta en JSON
        const productos = await respuesta.json(); // Corregido: respuesta.json()

        // Crear contenido para la tabla
        let contenidoTabla = "";

        for (let producto of productos) {
            let contenidoFila = `
                <tr>
                    <td>${producto.id}</td>
                    <td>${producto.nombre}</td>
                    <td>${producto.partNumber}</td>
                    <td>${producto.unidad}</td>
                    <td>${producto.procedencia}</td>
                    <td>${producto.material}</td>
                    <td>${producto.precio.toFixed(2)}</td>
                    <td><button class="btn-editar" data-id="${producto.id}">Editar</button></td>
                    <td><button onClick = "borrarProducto(${producto.id})" class="btn-eliminar">Eliminar</button></td>
                </tr>
            `;
            contenidoTabla += contenidoFila;
        }

        // Actualizar solo el contenido del tbody
        document.querySelector('#tablaProductos tbody').innerHTML = contenidoTabla; // Corregido: innerHTML
    } catch (error) {
        console.error('Error al listar productos:', error); // Agregado para manejo de errores
    }
}



let borrarProducto = async(id)=>{
    const respuesta = await fetch('http://localhost:8080/api/producto/'+id,{
        method: 'DELETE',
        headers: { 
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });
    
    await listarProductos();

}