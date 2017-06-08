/*
 * Page Login
 */

// Fonction permettant de vérifier si tous les champs de mon formulaire "Login" sont remplis
function verifLogin() {
	// Je récupère les éléments de mon fichier HTML
	var login = document.getElementById("username").value;
	var mdp = document.getElementById("password").value;
	
	// Condition vérifiant si les 2 champs sont pas null ou pas
	if ((login != "") && (mdp != "")) {
		$("#submitLogin").removeAttr('disabled');
	} else {
		$("#submitLogin").attr('disabled','disabled');
	}
}


// Surveillance de plusieurs évènement
$("#username").on('keyup', verifLogin);
$("#password").on('keyup', verifLogin);
$("#boutonNom").on('click0');
