'use strict'
//array ,arreglos, Matrices

var nombre=["bryan","steven","zamora","listardo"]
nombre.push(prompt("Ingrese un nombre al array"));
nombre.sort();
for(var i=0;i<nombre.length;i++){
	document.write("<h3>"+nombre[i]+"</h3>");
}

nombre.forEach((elemento,index,data)=>{
	document.write("<h3>"+elemento+"</h3>");
});

nombre=["bryan","steven"];
var apellido=["zamora","litardo"];

var lista=[nombre,apellido];

console.log(lista[0][0]);


var busqueda=apellido.find(elemento => elemento == "zamora");

console.log(busqueda);