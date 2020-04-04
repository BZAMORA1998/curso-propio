'use strict'
//api rest
var div_usuarios=document.getElementById("usuarios");
var div_janet=document.getElementById("usuario");

//lista usuarios
	getUsuarios()//no va el punto y coma es una promesa
		.then(data=>data.json())
		.then(users=>{
			listarUsuarios(users.data);
		})

	getJanet()	
		.then(data=>data.json())
		.then(user=>{
			mostrarJanet(user.data);
		})

	getInfo()//ya no se llama el data xq ya esta convertido
		.then(info=>{
			console.log(info);
		})

	.catch(error =>{
		console.log(error);
	});

///////////////////////////////////////////////////////////////////////////////
function getUsuarios(){
	return fetch('https://reqres.in/api/users');
}

function listarUsuarios(usuarios){
	usuarios.map((user,i)=>{
				let nombre=document.createElement('h2');
				nombre.innerHTML=i+" "+user.first_name+" "+user.last_name;
				div_usuarios.appendChild(nombre);
			});
}

////////////////////////////////////////////////////////////////////////////
function getJanet(){
	return fetch('https://reqres.in/api/users/2');
}

function mostrarJanet(user){
			let nombre=document.createElement('h2');
			let avatar=document.createElement('img');
			nombre.innerHTML=" 1 "+user.first_name+" "+user.last_name;
			avatar.src=user.avatar;
			avatar.width='100';

			div_janet.appendChild(nombre);
			div_janet.appendChild(avatar);
}
/////////////////////////////////////////////////////////////////////////////

function getInfo(){
	var profesor={
		nombre:'Bryan',
		apellido:'Zamora'
	};

	return new Promise((resolve,reject)=>{
		var profesor_string="";

		setTimeout(()=>{//retarda en mostrar la informacion
			profesor_string=JSON.stringify(profesor);
			if(typeof profesor_string != 'string' || profesor_string == ' ') return reject('error1');
			return resolve(profesor_string);
		},3000);
	});

}