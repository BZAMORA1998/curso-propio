'use strict'

//pida 6 numero por pantalla y los meta en un array
var numeros=new Array(6);
var encontrar=parseInt(prompt("Ingrese un numero a buscar: "));

for(var i=0;i<6;i++){
	numeros[i]=parseInt(prompt("Ingrese un numero: "));
}

//mostrar un array entero (todos sus elementos) en el cuerpo de la pagina y en la pantalla
var j=0;
while(j<numeros.length){
	document.write("<h2>"+numeros[j]+"</h2>");
	j++;
}
document.write("<br> <br> <br>");
//ordenarlos y mostrarlo
numeros.sort();
j=0;
while(j<numeros.length){
	document.write("<h2>"+numeros[j]+"</h2>");
	j++;
}


//invertir su orden y mostrarlo
numeros.reverse();
j=0;
while(j<numeros.length){
	document.write("<h2>"+numeros[j]+"</h2>");
	j++;
}
//mostrar cuantos elementos tiene un array
document.write("<h1>En el array hay "+numeros.length+" elementos </h1>");
//busqueda de un valor introducido por el usuario, que nos diga si lo encuentra y su indice


var encontrado=numeros.find(element => element==encontrar);

if(encontrado){
	document.write("<h1>Lo encontro </h1>");
}else{
	document.write("<h1>no lo encontro </h1>");
}