/**
 * Script permettant d'ajouter/supprimer des blocs sur la grille lors de l'edition d'un tetrimino
 */

$(".case").click(function() {
	if($(this).hasClass("bloc")){
		$(this).removeClass("bloc");
		$(this).css("background-color", "white");

	}
	
	else{
		$(this).addClass("bloc");
		$(this).css("background-color", $("#couleur_tetrimino").val());
	}
});

$("#boutonFormeDelete").click(function(){
	$(".case").removeClass("bloc")
	$(".case").css("background-color", "white")
})



$("#boutonForme").click(function(){
})