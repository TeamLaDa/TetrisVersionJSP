/*
 * Page subscribe
 */

var usernameUnique = false;
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
	// var administrateur = document.getElementById("administrateurButton").checked;
	
	
	// Condition permettant de vérifier si les MdP sont identiques ou non
	if (password != passwordVerif) {
		// Ajoute la classe invalid à l'id "passwordVerif"
		$("#passwordSubscribeVerif").addClass("invalid");
	} else {
		// Supprime la classe invalid à l'id "passwordVerif"
		$("#passwordSubscribeVerif").removeClass("invalid");
	}
	
	// Condition permettant que le nom de l'utilisateur soit uniquement des a-z, A-Z, et 0-9
	var userRegex = /^[a-zA-Z0-9-.\-]+$/;
	var usernameWithRegex = $("#utilisateurSubscribe").val().match(userRegex);

	// si le nom d'utilisateur contient au moins un caractère non autorisé
	if (usernameWithRegex == null) {
		$("#utilisateurSubscribe").addClass("invalid");
		$("#utilisateurSubscribe + label").attr("data-error", $("#utilisateurSubscribe + label").data("error-regex"));
	}
	
	// si le nom d'utilisation contient uniquement des caractères autorisés
	else {
		$("#utilisateurSubscribe").removeClass("invalid");
		
		// Fonction permettant de vérifier si le nom d'utilisateur est déjà pris
		$.ajax({
			url:"verifusernamesubscribe",
			method:"GET",
			data: {"nom_user": $("#utilisateurSubscribe").val()},
			success: function(result) {
				if (result == 1) {
					$("#utilisateurSubscribe").addClass("invalid");
					$("#utilisateurSubscribe + label").attr("data-error", $("#utilisateurSubscribe + label").data("error-memenom"));
					usernameUnique = false;
				} else {
					$("#utilisateurSubscribe").removeClass("invalid");
					usernameUnique = true;
				}
			}
		});
	}
	
	
	// Condition vérifiant si tous les champs ne sont pas null
		// décommenter la première ligne si volonté de créer un administrateur
	// if ((user != "") && (password != "") && (passwordVerif != "") && (mot != "") && (prenom != "") && (password == passwordVerif) && ((joueur == true) || (spectateur == true) || (administrateur == true)) && (usernameWithRegex != null) && (usernameUnique == true) ) {
	if ((user != "") && (password != "") && (passwordVerif != "") && (mot != "") && (prenom != "") && (password == passwordVerif) && ((joueur == true) || (spectateur == true)) && (usernameWithRegex != null) && (usernameUnique == true)) {
		$("#submitSubscribe").removeAttr('disabled');
	} else {
		$("#submitSubscribe").attr('disabled','disabled');
	}
}

// Surveillance de plusieurs évènement
$("#utilisateurSubscribe").on('blur', verifSubscribe);
$("#passwordSubscribe").on('blur', verifSubscribe);
$("#passwordSubscribeVerif").on('keyup', verifSubscribe);
$("#nomSubscribe").on('keyup', verifSubscribe);
$("#prenomSubscribe").on('keyup', verifSubscribe);
$("input[name='joueurSpectateurButton']").on('change', verifSubscribe);











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
$("#boutonNom").on('click0');
