// Función para abrir la pestaña especificada
function openTab(evt, tabName) {
    // Obtener todos los elementos con la clase "tabcontent" y ocultarlos
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    // Obtener todos los elementos con la clase "tablinks" y eliminar la clase "active"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    // Mostrar la pestaña actual y agregar una clase "active" al botón que abrió la pestaña
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}

// Abrir la primera pestaña por defecto
document.addEventListener('DOMContentLoaded', function() {
    document.querySelector('.tab button').click();
});
