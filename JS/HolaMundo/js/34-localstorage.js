'use strict'

//Localstorate

//Comprobar disponibilidad no es disponibilidad 

if (typeof(Storage)!=='undefined') {
	console.log("Localstorate disponible");
}else{
	console.log("Localstorate no disponible");
}

//guardar datos
localStorage.setItem("titulo","Curso de js");

//recuperar elemento

console.log(localStorage.getItem("titulo"));

document.getElementById("peliculas").innerHTML=localStorage.getItem("titulo");


//Guardar objetos

var usuario={
	cedula: "0928914464",
	nombre: "Bryan",
	email:"bryan.zamora@goitsa.me",
	celular:"0979908642"
};

localStorage.setItem("usuario",JSON.stringify(usuario));//convierte el objeto a JSON string

//Recuperar objeto

var userjs=JSON.parse(localStorage.getItem("usuario"));//convierte de json string a objeto
document.getElementById("peliculas").append(userjs.email);

console.log(userjs);

localStorage.removeItem("usuario");//elimina el local storage

localStorage.clear();//limpia