$(document).ready(function(){

	//puedes mover los componentes de una pagina
	$(".elemento").draggable();

	//redimiencionar
	$(".elemento").resizable();

	//Seleccionar elementos
	//$(".lista-seleccionable").selectable();
	$(".lista-seleccionable").sortable({
		update:function(event,ui){
			console.log("Ha cambiado la lista");
		}
	});

	//drop
	$("#elemento-movido").draggable();
	$("#area").draggable();


	//efectos
	$("#mostrar").click(function(){
		$(".caja-efectos").toggle("shake",1000);
	});

	//tooltip
	$(document).tooltip();

	//dialog
	$("#lanzar-popup").click(function(){
		$("#popup").dialog();
	});

	//calendario

	$("#calendario").datepicker();

	//Tabs
	$("#pestanas").tabs();
		
});