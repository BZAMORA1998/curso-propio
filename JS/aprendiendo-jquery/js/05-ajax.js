$(document).ready(function(){

	//load
	$("#datos").load("https://reqres.in/");

	//get y post
	$.get("https://reqres.in/api/users",{page:2},function(response){
		response.data.forEach((element,index)=>{//data es el nombre de el json
			$("#datos").append("<p>"+element.first_name+"</p>");
		});
	});


	$("#formulario").submit(function(e){

		e.preventDefault();

		var user={
			nombre:$('input[name="name"]').val(),
			job:$('input[name="job"]').val() 
		};

			console.log(user);

		/*$.post($(this).attr("action"),user,function(response){//extrae la url de acction
			console.log(response);
		}).done(function(){
			alert("Usuario Añadido correctamente");
		});	*/

		$.ajax({
			type:'POST',
			url:$(this).attr("action"),
			data:user,
			beforeSend:function(){
				console.log("Enviando usuario...");
			},
			success:function(response){
				console.log(response);
			},
			error:function(){
				console.log("A ocurrido un error");
			},
			timeout:2000
		});

		return false;
	});

});

