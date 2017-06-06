/**
 * Script permettant d'ajouter/supprimer des blocs sur la grille lors de l'edition d'un tetrimino
 */

$(".bloc").click(function() {
	var x = $(this).children("input[name='x']").val();
	var y = $(this).children("input[name='y']").val();
	var isEmpty = $(this).children("input[name='isEmpty']").val()
	alert("x : " +x);
	alert("y : " +y);
	alert("isEmpty : " +isEmpty);
});