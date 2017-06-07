/**
 * Script permettant d'ajouter/supprimer des blocs sur la grille lors de l'edition d'un tetrimino
 */

$(".bloc").click(function() {
	var isEmpty = $(this).children("input[name='isEmpty']").val();
	var couleur = $(this).children("input[name='blocCouleur']").val();
	
	if(isEmpty=="true"){
		$(this).children("input[name='isEmpty']").val("false");
		$(this).css("background-color",couleur);
	}
	if(isEmpty=="false"){
		$(this).children("input[name='isEmpty']").val("true");
		$(this).css("background-color","white");
	}
});