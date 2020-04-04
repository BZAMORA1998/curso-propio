$(document).ready(function(){
	//mouseOver y mouseOut
	var caja=$("#caja");

	/*caja.mouseover(function(){
		$(this).css("background","green");
	});

	caja.mouseout(function(){
		$(this).css("background","yellow");
	});*/

	function cambiarVerde(){
		$(this).css("background","green");
	}

	function cambiarAmarillo(){
		$(this).css("background","red");
	}
	//hover
	caja.hover(cambiarVerde,cambiarAmarillo);

	//click y dobleclick

	caja.click(function(){
		$(this).css("background","yellow");
	});

	caja.dblclick(function(){
		$(this).css("background","blue");
	});

	//Focus y blur

	var texto=$("#nombre");
	var datos=$("#datos")
	texto.focus(function(){//dentro de la caja de texto
		$(this).css("border","2px solid green");
	});

	texto.blur(function(){//salir de la caja de texto
		$(this).css("border","2px solid red");
		var t=$(this).val();
		datos.text(t).show();
	});

	//mousedown y mouseup
	datos.mousedown(function(){//click sostenido
		$(this).css("border-color","blue");
	});

	datos.mouseup(function(){//click levantado
		$(this).css("border-color","red");
	});

	//mousemove

	$(document).mousemove(function(){//seguir cursor
		var sigueme=$("#sigueme")
		sigueme.css("left",event.clientX)
						.css("top",event.clientY);
	});

});