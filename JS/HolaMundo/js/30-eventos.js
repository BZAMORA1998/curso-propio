'use strict'
//eventos del raton

window.addEventListener('load',() => {
	var boton=document.getElementById("boton");

	function cambiarColor(){
		var bg=boton.style.background;
		if(bg=="green"){
			boton.style.background="red";
		}else{
			boton.style.background="green";
		}

		boton.style.padding="10px";
		boton.style.border="1px solid";
	}

	//boton.addEventListener('click',cambiarColor,false);

	//mouseover
	boton.addEventListener('mouseover',function(){
		boton.style.background="red";
		boton.style.padding="10px";
		boton.style.border="1px solid";
	});


	//mouseout
	boton.addEventListener('mouseout',function(){
		boton.style.background="green";
		boton.style.padding="10px";
		boton.style.border="1px solid";
	});

	//focus
	var texto=document.getElementById("texto");

	texto.addEventListener('focus',function(){
		console.log("Ha entrado");
	});

	//keydown
	texto.addEventListener('keydown',function(){
		console.log("[keydown] Pulsando esta tecla ",String.fromCharCode(event.keyCode));
	});

	//keypress
	texto.addEventListener('keypress',function(){
		console.log("[keypress] Presiona tecla",String.fromCharCode(event.keyCode));
	});

	//keyup
	texto.addEventListener('keyup',function(){
		console.log("[keyup] Presiona tecla",String.fromCharCode(event.keyCode));
	});
});
