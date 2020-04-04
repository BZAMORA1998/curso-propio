function holaMundo(texto){
	console.log(texto);
	console.log(numero.toString	);
}

var numero=12;
var texto="hola mundo soy una variable global";

//holaMundo(texto)

//funciones texto 

var numero=444;
var text1="Curso de JS ";
var text2="es un buen curso";

var num=numero.toString();
var textoTotal=text1+text2;

console.log(typeof num);
//console.log(textoTotal);

console.log(text2.indexOf("buen"));
console.log(textoTotal.search("JS"));

var busqueda=textoTotal.replace("JS","PHP");
console.log(textoTotal.trim());
console.log(busqueda);

