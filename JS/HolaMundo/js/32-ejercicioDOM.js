'use strict'

window.addEventListener('load',() => {
	console.log("DOM cargado!");
	var formulario=document.getElementById("formulario");
	var box_dashed=document.querySelector(".dashed");
	box_dashed.style.display="none";

	formulario.addEventListener("submit",() => {

		console.log("Evento submit capturado");
		var nombre=document.getElementById("nombre").value;
		var apellido=document.getElementById("apellido").value;
		var edad=document.getElementById("edad").value;

		if(nombre==null || nombre.length==0){
			alert("El nombre no es valido");
		}

		if(apellido==null || apellido.length==0){
			alert("El apellido no es valido");
		}

		if(!isNaN(edad)){
			alert("El edad no es valido");
		}


		box_dashed.style.display="block";

		var datos_usuario=[nombre,apellido,edad];

		var indice;

		for(indice in datos_usuario){
			var parrafo=document.createElement("p");
				parrafo.append(datos_usuario[indice]);
				box_dashed.append(parrafo);
		}

	});
});