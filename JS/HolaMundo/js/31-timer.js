
'use strict'

window.addEventListener('load',() => {
	//Timer

	function intervalo(){
		var tiempo=setInterval(() => {
			console.log("set interval ejecutando");
		}, 3000);

		return tiempo;
	}

	var tiempo=intervalo();

	var stop=document.getElementById("stop");
	stop.addEventListener("click",() => {
		clearInterval(tiempo);
		console.log("Se detuvo");
		var miCaja=document.getElementById("micaja").innerHTML="Se detuvo";
	});

	var start=document.getElementById("start");
	start.addEventListener("click",() => {
		intervalo();
		console.log("Comienza");
		var miCaja=document.getElementById("micaja").innerHTML="Comienza";
	});
});