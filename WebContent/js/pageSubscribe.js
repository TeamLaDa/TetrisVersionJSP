/*
 * Page subscribe
 */

var usernameUnique = false;
// Fonction permettant de vérifier si tous les champs de mon formulaire "Subscribe" sont remplis
function verifSubscribe() {
	// Je récupère les éléments de mon fichier HTML
	console.log("toto")
	var user = $("#username").val();
	var password = $("#password").val();
	var passwordVerif = $("#passwordVerif").val();
	var nom = $("#nom").val();
	var prenom = $("#prenom").val();
	var joueur = $("#joueurButton").is(":checked");
	var spectateur = $("#spectateurButton").is(":checked");
	// var administrateur = $("#administrateurButton").is(":checked");
	
	
	
	// Condition permettant de vérifier si les MdP sont identiques ou non
	if (password != passwordVerif) {
		// Ajoute la classe invalid à l'id "passwordVerif"
		$("#passwordVerif").addClass("invalid");
	} else {
		// Supprime la classe invalid à l'id "passwordVerif"
		$("#passwordVerif").removeClass("invalid");
	}
	
	// Condition permettant que le nom de l'utilisateur soit uniquement des a-z, A-Z, et 0-9
	var userRegex = /^[a-zA-Z0-9-.\-]+$/;
	var usernameWithRegex = $("#username").val().match(userRegex);

	// si le nom d'utilisateur contient au moins un caractère non autorisé
	if (usernameWithRegex == null) {
		$("#username").addClass("invalid");
		$("#username + label").attr("data-error", $("#username + label").data("error-regex"));
	}
/*	
	// si le nom d'utilisation contient uniquement des caractères autorisés
	else {
		$("#username").removeClass("invalid");
		
		// Fonction permettant de vérifier si le nom d'utilisateur est déjà pris
		$.ajax({
			url:"verifusernamesubscribe",
			method:"GET",
			data: {"nom_user": $("#username").val()},
			success: function(result) {
				if (result == 1) {
					$("#username").addClass("invalid");
					$("#username + label").attr("data-error", $("#username + label").data("error-memenom"));
					usernameUnique = false;
				} else {
					$("#username").removeClass("invalid");
					usernameUnique = true;
				}
			}
		});
	}
*/	
	
	// Condition vérifiant si tous les champs ne sont pas null
		// décommenter la première ligne si volonté de créer un administrateur
	// if ((user != "") && (password != "") && (passwordVerif != "") && (mot != "") && (prenom != "") && (password == passwordVerif) && ((joueur == true) || (spectateur == true) || (administrateur == true)) && (usernameWithRegex != null) && (usernameUnique == true) ) {
	if ((user != "") && (password != "") && (passwordVerif != "") && (nom != "") && (prenom != "") && (password == passwordVerif) && ((joueur == true) || (spectateur == true)) && (usernameWithRegex != null) ) {
		$("#submitSubscribe").removeAttr('disabled');
	} else {
		$("#submitSubscribe").attr('disabled','disabled');
	}
}

// Surveillance de plusieurs évènement
$("#username").on('blur', verifSubscribe);
$("#password").on('blur', verifSubscribe);
$("#passwordVerif").on('keyup', verifSubscribe);
$("#nom").on('keyup', verifSubscribe);
$("#prenom").on('keyup', verifSubscribe);
$("input[name='joueurSpectateurButton']").on('change', verifSubscribe);