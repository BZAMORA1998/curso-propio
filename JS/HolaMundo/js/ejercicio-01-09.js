var a=parseInt(prompt("Ingrese un numero"));
var b=parseInt(prompt("Ingrese otro numero"));


while(a<0 || b<0 || isNaN(a) || isNaN(b)){//si es positivo se ejecuta el bucle
	a=parseInt(prompt("Ingrese un numero"));
	b=parseInt(prompt("Ingrese otro numero"));
}

alert("El resultado es: "+(a+b));

if(a==b){
	alert("El numero "+a+" es igual al numero "+b);
}else if(a>b){
	alert("El numero "+a+" es mayor al numero "+b);
}else{
	alert("El numero "+a+" es menor al numero "+b);
}

var c=0;

do{

	a=parseInt(prompt("Ingrese un numero"));
	b=parseInt(prompt("Ingrese otro numero"));
	c++;
	document.write("<h1> El numero es: "+c+"</h1>");

}while(a<0 || b<0 || isNaN(a) || isNaN(b))//si es negativo se ejecuta el bucle

alert("El resultado es: "+(a+b));

if(a==b){
	alert("El numero "+a+" es igual al numero "+b);
}else if(a>b){
	alert("El numero "+a+" es mayor al numero "+b);
}else{
	alert("El numero "+a+" es menor al numero "+b);
}



