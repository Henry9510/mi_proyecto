


// Selección del botón y asignación del evento
let boton = document.getElementById("btncrear");

boton.addEventListener("click", evento => {
    registrarProducto();
});

// Declaración de la función antes de su uso
let registrarProducto = async () => {
    // Recolecta los datos del formulario
    let campos = {
        nombre: document.getElementById('nombre').value.trim(),
        partNumber: document.getElementById('PartNumber').value.trim(),
        unidad: document.getElementById('unidad').value.trim(),
        procedencia: document.getElementById('procedencia').value.trim(),
        material: document.getElementById('material').value.trim(),
        precio: parseFloat(document.getElementById('precio').value.trim())
     };

     
    const respuesta = await fetch('http://localhost:8080/api/producto',
        {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(campos)
        });
        
}