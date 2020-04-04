'use strict'

var formularioA=document.getElementById("formPeliculasA");
var formularioB=document.getElementById("formPeliculasB");
var ul=document.getElementById("ul");

formularioA.addEventListener('submit',()=>{
	var titulo=document.getElementById("addPelicula").value;
	console.log("Entro a la primera");
	if(titulo.length>=1){
		localStorage.setItem(titulo,titulo);
	}
});

formularioB.addEventListener('submit',()=>{
	var titulo=document.getElementById("deletePelicula").value;
	console.log("Segunda a la primera");
	if(titulo.length>=1){
		localStorage.removeItem(titulo);
	}
});

for(var i in localStorage){
	console.log(localStorage[i]);
	if(typeof localStorage[i] == 'string'){
		var li=document.createElement("li");
		li.append(localStorage[i]);
		ul.append(li);
	}
}

