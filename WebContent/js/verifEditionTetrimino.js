/**
 * Page Edit Tetrimino
 */

// Fonction permettant de vérifier si tous les champs de mon formulaire "Edition Tetrimino" sont remplis

function verifEdition() {
	// Je récupère les éléments de mon fichier HTML
	var nom = document.getElementById("nom_tetrimino").value;
	var couleur = document.getElementById("couleur_tetrimino").value;
	
	// Condition vérifiant si les 2 champs sont pas null ou pas
	if ((nom != "") && (couleur != "") && ($("#pivot").length)) {
		$("#submitEdition").removeAttr('disabled');
	} else {
		$("#submitEdition").attr('disabled','disabled');
	}
	
	//Condition vérifiant si le champ nom est vide
	if((nom !== "")){
		$("#boutonNom").removeAttr('disabled');
	} else {
		$("#boutonNom").attr('disabled','disabled');
	}
	
	//Condition vérifiant si le champ couleur est vide
	if((couleur !== "")){
		$("#boutonCouleur").removeAttr('disabled');
	} else {
		$("#boutonCouleur").attr('disabled','disabled');
	}
	
	//Condition vérifiant si le pivot est bien choisi
	
	if(($("#pivot").length)){
		$("#boutonRotation").removeAttr('disabled');
	} else {
		$("#boutonRotation").attr('disabled','disabled');
	}

}

// Surveillance de plusieurs évènement
$("#nom_tetrimino").on('keyup', verifEdition);
$("#couleur_tetrimino").on('keyup', verifEdition);
$("#boutonRotationDelete").on('click', verifEdition);


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