

//Fonction permettant de vérifier si tous les champs de mon formulaire "Edition Tetrimino" ou "Nouveau Tetrimino" sont remplis
function verifEdition() {
	// Je récupère les éléments de mon fichier HTML

	//Condition vérifiant si les champs sont remplis ou pas
	if (($("#nom_tetrimino").val() !== "") && ($("#couleur_tetrimino").val() !== "") && $(".case.bloc:not(.test,.rot)").length && ($("#pivot").length)) {
		$("#submitEdition").removeAttr('disabled');
	} else {
		$("#submitEdition").attr('disabled','disabled');
	}

	//1.Condition vérifiant si le champ nom est vide
	if($("#nom_tetrimino").val()!==""){
		$("#boutonNom").removeAttr('disabled');
	} else {
		$("#boutonNom").attr('disabled','disabled');
	}

	//2. Condition vérifiant si le champ couleur est vide
	if($("#couleur_tetrimino").val()!==""){
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

//Fonction permettant de verrouiller un ou plusieurs onglet el
function lock(el) {
	el.on('click.locked', function() {
		return false;
	})
}

//Fonction permettant de deverrouiller un ou plusieurs onglet el
function unlock(el) {
	el.off('click.locked');
}

// Surveillance de plusieurs évènement


//Initialisation du formulaire
$(document).ready(function(){
	
	//Si le formulaire concerne un cas de création, il faut verrouiller les onglets et rendre le 1er (choix du nom) actif
	if($("form").children("input[name='isNew']").val() == "true"){
	    lock($("#choixForme"));
	    lock($("#choixRotation"));
	    lock($("#choixCouleur"));
	    
	    $("#boutonForme").attr('disabled','disabled');
	    $("#boutonNom").attr('disabled','disabled');
	    $("#boutonRotation").attr('disabled','disabled');
	    $("#submitEdition").attr('disabled','disabled');
	    
		$('.collapsible').collapsible('open', 0);	    
	}
  });

$("#nom_tetrimino").on('keyup', verifEdition);
$("#couleur_tetrimino").on('change', verifEdition);

$("#boutonNom").on('click', function() {
	$('.collapsible').collapsible('open', 1);
	
	//(cas de création) on déverouille l'onglet suivant
	unlock($("#choixCouleur"));
});

$("#boutonCouleur").on('click', function() {
	//On actualise la couleur des blocs
	$(".bloc").css("background-color", $("#couleur_tetrimino").val());

	$('.collapsible').collapsible('open', 2);
	//(cas de création) on déverouille l'onglet suivant
	unlock($("#choixForme"));
});

$("#boutonForme").on('click', function() {
	$('.collapsible').collapsible('open', 3);
	unlock($("#choixRotation"));
});
        
