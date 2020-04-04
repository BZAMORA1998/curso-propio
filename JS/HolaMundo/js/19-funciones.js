'uso strict'

//funciones

function calculador(){
	return "Hola soy calculadora";
}

//con paramtametros
function calculadora(a,b,mostrar){
	if(mostrar){
		return parseInt(a) + parseInt(b);
	}else{
		return parseInt(a) - parseInt(b);
	}
}

/*var calcular=calculador();
var resul=calculadora(1,2,true);

document.write("<h1>"+calcular+"</h1>");
document.write("<h2>El resultado es: "+resul+"</h1>");*/

//parametros rest spread
function listadoFrutas(fruta1,fruta2,...restofruta){
	console.log("Fruta 1: "+fruta1);
	console.log("Fruta 2: "+fruta2);
	console.log("Resto: "+restofruta);
}

//listadoFrutas("manzana","pera","mango","renaclaudia","sandia");

//var frutas=["manzana","pera"];
//listadoFrutas(...frutas,"mango","renaclaudia","sandia");


//funciones anonimas

var nombre="Bryan";

function pelicula(nombre){
	return "La pelicula es: "+nombre;
}


//funcion con flecha

function sumame(num1,num2,sumaymuestra,sumaPorDos){
	var sumar=num1+num2;

	sumaymuestra(sumar);
	sumaPorDos(sumar);

	return sumar;
}


sumame(5,
		7,
		(dato)=>{console.log("La suma: ",dato);},
		(dato)=>{console.log("La suma por dos es: "+(dato*2));}
		);
