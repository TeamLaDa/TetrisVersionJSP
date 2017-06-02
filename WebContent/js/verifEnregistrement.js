/*
 * Page subscribe
 */

// Fonction permettant de vérifier si tous les champs de mon formulaire "Login" sont remplis
function verifSubscribe() {
	// Je récupère les éléments de mon fichier HTML
	var user = document.getElementById("utilisateurSubscribe").value;
	var password = document.getElementById("passwordSubscribe").value;
	var passwordVerif = document.getElementById("passwordSubscribeVerif").value;
	var mot = document.getElementById("nomSubscribe").value;
	var prenom = document.getElementById("prenomSubscribe").value;
	var joueur = document.getElementById("joueurButton").checked;
	var spectateur = document.getElementById("spectateurButton").checked;
	
	
	// Condition permettant de vérifier si les MdP sont identiques ou non
	if (password != passwordVerif) {
		// Ajoute la classe invalid à l'id "passwordVerif"
		$("#passwordSubscribeVerif").addClass("invalid");
	} else {
		// Supprime la classe invalid à l'id "passwordVerif"
		$("#passwordSubscribeVerif").removeClass("invalid");
	}
	
	// Condition vérifiant si tous les champs ne sont pas null
	if ((user != "") && (password != "") && (passwordVerif != "") && (mot != "") && (prenom != "") && (password == passwordVerif) && ((joueur == true) || (spectateur == true)) ) {
		$("#submitSubscribe").removeAttr('disabled');
	} else {
		$("#submitSubscribe").attr('disabled','disabled');
	}
}

// Surveillance de plusieurs évènement
$("#utilisateurSubscribe").on('keyup', verifSubscribe);
$("#passwordSubscribe").on('keyup', verifSubscribe);
$("#passwordSubscribeVerif").on('keyup', verifSubscribe);
$("#nomSubscribe").on('keyup', verifSubscribe);
$("#prenomSubscribe").on('keyup', verifSubscribe);
$("input[name='joueurSpectateurButton']").on('change', verifSubscribe);


/*
$.ajax({
	url:"verifusernamesubscribe",
	method:"GET",
	data:{"nom_user","val"},
	success function(result) {
		
	}
})
}
*/





/*
 * Page Login
 */
// Fonction permettant de vérifier si tous les champs de mon formulaire "Login" sont remplis
function verifLogin() {
	// Je récupère les éléments de mon fichier HTML
	var login = document.getElementById("utilisateurLogin").value;
	var mdp = document.getElementById("passwordLogin").value;
	
	// Condition vérifiant si les 2 champs sont pas null ou pas
	if ((login != "") && (mdp != "")) {
		$("#submitLogin").removeAttr('disabled');
	} else {
		$("#submitLogin").attr('disabled','disabled');
	}
}

// Surveillance de plusieurs évènement
$("#utilisateurLogin").on('keyup', verifLogin);
$("#passwordLogin").on('keyup', verifLogin);
