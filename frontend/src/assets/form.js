// Declaración de la función antes de su uso
let registrarProducto = async () => {

    // Recolecta los datos del formulario
    let campos = {};
    campos.Nombre = document.getElementById('nombre').value;
    campos.PartNumber = document.getElementById('PartNumber').value;
    campos.Unidad = document.getElementById('unidad').value;
    campos.Procedencia = document.getElementById('procedencia').value;
    campos.Material = document.getElementById('material').value;
    campos.Precio = document.getElementById('precio').value;

    const respuesta = await fetch("http://127.0.0.1:8080/api/producto", {
        method: 'POST',
        headers: {
            'Accept':'application/json',
            'Content-Type':'application/json'
        },
        body: JSON.stringify(campos)
    });
};


// Selección del botón y asignación del evento
let boton = document.getElementById("btncrear");

boton.addEventListener("click", Event => {
    registrarProducto();
});