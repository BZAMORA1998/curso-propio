'use stric'

//JSON

var pelicula={
	titulo:'Batman vs Superman',
	year:2017,
	pais:'Estados Unidos'
};

var peliculas=[
	{titulo:'Batman vs Superman',year:2017,pais:'Estados Unidos'},
	{titulo:'Spiderman',year:2020,pais:'Estados Unidos'},
	pelicula
];

pelicula.year=2020;
console.log(peliculas);

var caja_peliculas=document.querySelector("#peliculas");
var index;
for(index in peliculas){
	var p=document.createElement("p");
	p.append(peliculas[index].titulo);
	caja_peliculas.append(p);		
}