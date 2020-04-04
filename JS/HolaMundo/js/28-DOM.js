'use strict'


function crear(){
	var parrafo = document.createElement('p');
    var texto = document.createTextNode('Menos que Macbeth, pero más grande');
    parrafo.append(texto);
}

function cambiarColor(){
	var caja=document.getElementById("hola1");
	caja.style.background="red";
	caja.innerHTML="chao";
}
	
function modificar(){
	var caja=document.getElementsByTagName('h1');
	
	var nombre=["hola1","hola2","hola3","hola4"];

	for(var i=0;i<caja.length;i++){
		var elegido=caja[i].innerHTML="Hola estoy modificando";
		console.log(elegido);
	}
}
 cambiarColor();

	
	
