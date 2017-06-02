/**
 * Page Edit Tetrimino
 */

// Fonction permettant de vérifier si tous les champs de mon formulaire "Edition Tetrimino" sont remplis

function verifEdition() {
	// Je récupère les éléments de mon fichier HTML
	var nom = document.getElementById("nom_tetrimino").value;
	var couleur = document.getElementById("couleur_tetrimino").value;
	
	// Condition vérifiant si les 2 champs sont pas null ou pas
	if ((nom != "") && (couleur != "")) {
		$("#submitEdition").removeAttr('disabled');
	} else {
		$("#submitEdition").attr('disabled','disabled');
	}
}

// Surveillance de plusieurs évènement
$("#nom_tetrimino").on('keyup', verifEdition);
$("#couleur_tetrimino").on('keyup', verifEdition);
