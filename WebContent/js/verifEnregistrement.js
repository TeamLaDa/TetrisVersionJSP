function verifMotDePasse() {
	var mdp1   = document.getElementById("password").value;
	var mdp2   = document.getElementById("passwordVerif").value;
	// var verifMdP = document.getElementById("VerifMdP");
	var verifMdP = document.getElementById("passwordVerif");
	
	console.log(mdp1);
	console.log(mdp2);
	 
	if(mdp1 != mdp2){
	  console.log("Invalide !");
	  $("#passwordVerif").addClass("invalid");
	}
	else {
	  console.log("Valide !");
	  $("#passwordVerif").removeClass("invalid");
	}
}


$("#password").on('keyup', verifMotDePasse);
$("#passwordVerif").on('keyup', verifMotDePasse);
$("#passwordVerif").on('blur', verifMotDePasse);