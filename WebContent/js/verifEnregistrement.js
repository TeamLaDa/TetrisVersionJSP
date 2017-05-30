// Fonction permettant de vérifier si les 2 mots de passe sont identiques dans le formulaire d'enregistrement
function verifMotDePasse() {
	// Je récupère les éléments de mon fichier HTML
	var mdp1 = document.getElementById("password").value;
	var mdp2 = document.getElementById("passwordVerif").value;

	// Condition permettant de vérifier si les MdP sont identiques ou non
	if (mdp1 != mdp2) {
		// Ajoute la classe invalid à l'id "passwordVerif"
		$("#passwordVerif").addClass("invalid");
	} else {
		// Supprime la classe invalid à l'id "passwordVerif"
		$("#passwordVerif").removeClass("invalid");
	}
}

// Surveillance de plusieurs évènements
$("#password").on('keyup', verifMotDePasse);
$("#passwordVerif").on('keyup', verifMotDePasse);
$("#passwordVerif").on('blur', verifMotDePasse);




// Fonction permettant de vérifier si tous les champs de mon formulaire "Login" sont remplis
function verifLogin() {
	// Je récupère les éléments de mon fichier HTML
	var login = document.getElementById("utilisateurLogin").value;
	var mdp = document.getElementById("passwordLogin").value;
	
	console.log(login);
	console.log(mdp);
	
	// Condition vérifiant si les 2 champs sont pas null ou pas
	if ((login != null) && (mdp != null)) {
		$("#submitLogin").removeAttr('disabled');
	}
}

// Surveillance de plusieurs évènement
$("#utilisateurLogin").on('keyup', verifLogin);
$("#passwordLogin").on('keyup', verifLogin);
