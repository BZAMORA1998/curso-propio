$(document).ready(function(){
	
	
	 //Posts

	 if(window.location.href.indexOf('index') > -1){

	 		//slider
			 $('.bxslider').bxSlider({
			    mode: 'fade',
			    captions: true,
			    slideWidth: 1200,
			  });


			 var posts=[
			 			{
			 				title:'Prueba de titulo 1',
			 				date: moment().format("DD/MM/YYYY"),
			 				content:'Lorem ipsum es el texto que se usa habitualmente en diseño gráfico en demostraciones de tipografías o de borradores de diseño para probar el diseño visual antes de insertar el texto final.Aunque no posee actualmente fuentes para justificar sus hipótesis, el profesor de filología clásica Richard McClintock asegura que su uso se remonta a los impresores de comienzos del siglo XVI.1​ Su uso en algunos editores de texto muy conocidos en la actualidad ha dado al texto lorem ipsum nueva popularidad.'
			 			},
			 			{
			 				title:'Prueba de titulo 2',
			 				date: moment().format("DD/MM/YYYY"),
			 				content:'Lorem ipsum es el texto que se usa habitualmente en diseño gráfico en demostraciones de tipografías o de borradores de diseño para probar el diseño visual antes de insertar el texto final.Aunque no posee actualmente fuentes para justificar sus hipótesis, el profesor de filología clásica Richard McClintock asegura que su uso se remonta a los impresores de comienzos del siglo XVI.1​ Su uso en algunos editores de texto muy conocidos en la actualidad ha dado al texto lorem ipsum nueva popularidad.'
			 			},
			 			{
			 				title:'Prueba de titulo 3',
			 				date: moment().format("DD/MM/YYYY"),
			 				content:'Lorem ipsum es el texto que se usa habitualmente en diseño gráfico en demostraciones de tipografías o de borradores de diseño para probar el diseño visual antes de insertar el texto final.Aunque no posee actualmente fuentes para justificar sus hipótesis, el profesor de filología clásica Richard McClintock asegura que su uso se remonta a los impresores de comienzos del siglo XVI.1​ Su uso en algunos editores de texto muy conocidos en la actualidad ha dado al texto lorem ipsum nueva popularidad.'
			 			},
			 			{
			 				title:'Prueba de titulo 4',
			 				date: moment().format("DD/MM/YYYY"),
			 				content:'Lorem ipsum es el texto que se usa habitualmente en diseño gráfico en demostraciones de tipografías o de borradores de diseño para probar el diseño visual antes de insertar el texto final.Aunque no posee actualmente fuentes para justificar sus hipótesis, el profesor de filología clásica Richard McClintock asegura que su uso se remonta a los impresores de comienzos del siglo XVI.1​ Su uso en algunos editores de texto muy conocidos en la actualidad ha dado al texto lorem ipsum nueva popularidad.'
			 			},
			 			{
			 				title:'Prueba de titulo 5',
			 				date: moment().format("DD/MM/YYYY"),
			 				content:'Lorem ipsum es el texto que se usa habitualmente en diseño gráfico en demostraciones de tipografías o de borradores de diseño para probar el diseño visual antes de insertar el texto final.Aunque no posee actualmente fuentes para justificar sus hipótesis, el profesor de filología clásica Richard McClintock asegura que su uso se remonta a los impresores de comienzos del siglo XVI.1​ Su uso en algunos editores de texto muy conocidos en la actualidad ha dado al texto lorem ipsum nueva popularidad.'
			 			},
			 		];

			 		posts.forEach((item,index)=>{
			 			var post=`
								<article class="post">
									<h2>${item.title}</h2>
									<span class="date">${item.date}</span>
									<p>
										${item.content}
									</p>
									<a href="#" class="button-more">Leer mas</a>
								</article>
							`;
						$("#posts").append(post);
			 		});
			 }

	 		var theme =$("#theme");
	 		$("#to-green").click(function(){
	 			theme.attr("href","css/green.css");
	 		});

			$("#to-red").click(function(){
				theme.attr("href","css/red.css"); 			
			});

			$("#to-blue").click(function(){
				 theme.attr("href","css/blue.css");		
			});

			//scroll arriba de la web
			$('.subir').click(function(){

				e.preventDefault();
				$('html,body').animate(function(){
					scrollTop:0;
				},500);

				return false;
			});

			$("#login form").submit(function(){
				var form_name=$("#form_name").val();

				localStorage.setItem("form_name",form_name);
				location.reload();
			});

			var form_name=localStorage.getItem("form_name");

			if(form_name!=null && form_name!="undefined"){
				var about_parrafo=$("#about p");

				about_parrafo.html("Bienvenido, "+form_name);

				about_parrafo.append(" <a href='#' id='logout'>Cerrar sesion</a>");

				$("#login").hide();

				$("#logout").click(function(){
					localStorage.clear();
					location.reload();
				});
			}

	if(window.location.href.indexOf('about') > -1){
		$("#acordeon").accordion();
	}

	if(window.location.href.indexOf('reloj') > -1){

		setInterval(function(){
			var reloj=moment().format("h:mm:ss");
			$('#reloj').html(reloj);
		});
	}

	if(window.location.href.indexOf('contact') > -1){

			$("form input[name='date']").datepicker();
		  $.validate({
		    lang: 'es'
		  });
	}
});
