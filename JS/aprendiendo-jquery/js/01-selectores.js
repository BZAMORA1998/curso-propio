'use strict'

$(document).ready(()=>{
	$("#rojo").css("background","red")
					   .css("color","white");

	$("#amarillo").css("background","yellow")
								.css("color","white");

	$("#verde").css("background","green")
							.css("color","white");

	//selectores

	/*var mi_clase=$(".zebra");

	$('#amarillo').click(function(){
		console.log("Click dado!");
		$(this).addClass("zebra");
	});*/

	//selector de etiquetas

	var parrafos=$('p');

	parrafos.click(function(){

		var that=$(this);//Especifica cual etiqueta hace el cambio

		if(!that.hasClass('zebra')){//si no tiene la clase zebra

			console.log("verdadero");
			that.addClass('zebra');

		}else{

			console.log("falso");
			that.removeClass('zebra');

		}
	});

	$('[title="google"]').css("background","blue");


	$('p,a').addClass('margen-superior');

	var busqued=$("#caja").find(".resaltado");

	console.log(busqueda);

});