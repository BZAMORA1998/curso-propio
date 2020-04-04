'use strict'

var nombre=prompt("Tu nombre: ");
var apellido=prompt("Tu apeliido");

var texto=`
			<h1>Hola q tal</h1>
			<h2>Mi nombre es ${nombre}</h2>
			<h3>Mi apellido es ${apellido}</h3>
			`;

document.write(texto);