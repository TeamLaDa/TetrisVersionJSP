/**
 * Page Edit Tetrimino
 */

// Fonction permettant de vérifier si tous les champs de mon formulaire "Edition Tetrimino" sont remplis

function verifEdition() {
	// Je récupère les éléments de mon fichier HTML
	var nom = document.getElementById("nom_tetrimino").value;
	var couleur = document.getElementById("couleur_tetrimino").value;
	
	//Condition vérifiant si les champs sont remplis ou pas
	if ((nom != "") && (couleur != "") && $(".case.bloc:not(.test,.rot)").length && ($("#pivot").length)) {
		$("#submitEdition").removeAttr('disabled');
	} else {
		$("#submitEdition").attr('disabled','disabled');
	}
	
	//1.Condition vérifiant si le champ nom est vide
	if((nom !== "")){
		$("#boutonNom").removeAttr('disabled');
	} else {
		$("#boutonNom").attr('disabled','disabled');
	}
	
	//2. Condition vérifiant si le champ couleur est vide
	if((couleur !== "")){
		$("#boutonCouleur").removeAttr('disabled');
	} else {
		$("#boutonCouleur").attr('disabled','disabled');
	}
	
	//3. Condition vérifiant si au moins un bloc existe
	if($(".case.bloc:not(.test,.rot)").length){
		$("#boutonForme").removeAttr('disabled');
	} else {
		$("#boutonForme").attr('disabled','disabled');
	}
	
	
	//4. Condition vérifiant si le pivot est bien choisi
	
	if(($("#pivot").length)){
		$("#boutonRotation").removeAttr('disabled');
		$("#rotateLeft").removeAttr('disabled');
		$("#rotateRight").removeAttr('disabled');
	} else {
		$("#boutonRotation").attr('disabled','disabled');
		$("#rotateLeft").attr('disabled','disabled');
		$("#rotateRight").attr('disabled','disabled');
	}

}

// Surveillance de plusieurs évènement
$("#nom_tetrimino").on('keyup', verifEdition);
$("#couleur_tetrimino").on('keyup', verifEdition);


$("#boutonNom").on('click', function() {
	$('.collapsible').collapsible('open', 1);;
});

$("#boutonCouleur").on('click', function() {
	//On actualise la couleur des blocs
	$(".bloc").css("background-color", $("#couleur_tetrimino").val());
	
	$('.collapsible').collapsible('open', 2);;
});

$("#boutonForme").on('click', function() {
	$('.collapsible').collapsible('open', 3);;
});
