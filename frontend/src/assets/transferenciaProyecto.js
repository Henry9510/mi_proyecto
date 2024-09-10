document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('materialForm');
    const materialList = document.querySelector('#materialList tbody');
    const pedidosList = document.getElementById('pedidosList');
    const generateArrayButton = document.getElementById('generateArrayButton');

    form.addEventListener('submit', (event) => {
        event.preventDefault();

        // Obtener los valores del formulario
        const fecha = document.getElementById('fecha').value;
        const proyecto = document.getElementById('Proyecto').value;
        const codigo = document.getElementById('codigo').value;
        const descripcion = document.getElementById('nombre').value;
        const partNumber = document.getElementById('partNumber').value;
        const cantidad = document.getElementById('cantidad').value;

        // Crear una nueva fila para la tabla
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${proyecto}</td>
            <td>${codigo}</td>
            <td>${descripcion}</td>
            <td>${partNumber}</td>
            <td>${cantidad}</td>
            <td><button class="deleteBtn">Eliminar</button></td>
        `;

        // Agregar la fila a la tabla
        materialList.appendChild(row);

        // Limpiar el formulario
        form.reset();
    });

    // Delegar el evento de eliminación para las filas
    materialList.addEventListener('click', (event) => {
        if (event.target.classList.contains('deleteBtn')) {
            event.target.closest('tr').remove();
        }
    });

    // Función para generar el arreglo y agregar pedidos a la lista
    generateArrayButton.addEventListener('click', () => {
        const rows = materialList.querySelectorAll('tr');
        const dataArray = Array.from(rows).map(row => {
            const cells = row.querySelectorAll('td');
            return {
                proyecto: cells[0].textContent.trim(),
                codigo: cells[1].textContent.trim(),
                descripcion: cells[2].textContent.trim(),
                partNumber: cells[3].textContent.trim(),
                cantidad: cells[4].textContent.trim()
            };
        });

        console.log('Arreglo de Datos:', dataArray);

        // Limpiar la lista de pedidos antes de agregar nuevos
        pedidosList.innerHTML = '';

        // Agregar los pedidos a la lista
        dataArray.forEach(item => {
            const pedidoItem = document.createElement('li');
            pedidoItem.textContent = `Proyecto: ${item.proyecto}, Código: ${item.codigo}, Descripción: ${item.descripcion}, Número de Parte: ${item.partNumber}, Cantidad: ${item.cantidad}`;
            pedidosList.appendChild(pedidoItem);
        });
    });
});