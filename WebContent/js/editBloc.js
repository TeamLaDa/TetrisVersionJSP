/**
 * Script permettant :
 *  1. d'ajouter/supprimer des blocs sur la grille lors de l'edition d'un tetrimino
 *  2. de gérer la rotation des tetriminos
 */


/******* FONCTIONS ********/

//Fonction renvoyant les coordonées x,y d'un élément
function getCoord(el){
	return {x : (parseInt(el.children("input[name='x']").val(), 10)), y : (parseInt(el.children("input[name='y']").val(), 10))};
}

//Fonction logique retournant vrai si l'élement pointé est bien à l'emplacement (x,y)
function isLocatedOn(el,x,y){
	return (getCoord(el).x == x && getCoord(el).y == y);
}

//Supprime le ou les blocs pointés par la variable el
function removeBloc(el) {
	el.css("background-color", "white");
	el.removeClass("bloc");
}


//Fonction permettant de donner un id unique à chaque bloc et d'envoyer ses coordonnées à la servlet de persistance
//el représente les blocs de la grille
function saveBlocs(el){

	//On supprime le précédent jeu de blocs sélectionnés à envoyer
	$(".bdata").remove();
	
	var id=0;
	//Pour chaque bloc, on envoie ses coordonnées dans un champ input caché avec un identifiant unique
	el.each(function(){
		$(this).append("<input type=hidden class=data name=bx" + id + " value=" + getCoord($(this)).x + "></input>")
		$(this).append("<input type=hidden class=data name=by" + id + " value=" + getCoord($(this)).y + "></input>")
		
		id++;
	})
}


//Fonction de retrait du pivot
function removePivot() {
	$("#pivot").css("opacity", "0.5");
	$("#pivot").removeAttr("id");
	$(".bloc.rot").css("cursor","pointer");
	removeBloc($(".bloc.test"));
}

//Fonction permettant d'envoyer les coordonnées du pivot à la servlet de persistance
function savePivot(){
	//On efface les données du précedent pivot sélectionné
	$(".rdata").remove();
	
	//On envoie les coordonées dans un champ input caché
	$("#pivot").append("<input type=hidden class=rdata name=rx value=" + getCoord($("#pivot")).x + "></input>")
	$("#pivot").append("<input type=hidden class=rdata name=ry value=" + getCoord($("#pivot")).y + "></input>")
}

//Fonction permettant de dessiner le bloc à l'emplacement x,y sur une grille el
function drawBloc(el, x, y){
		el.filter(function(index){
			return isLocatedOn($(this), x, y);
		  })
		  .css("background-color", $("#couleur_tetrimino").val())
		  .addClass("bloc")
}


//Fonction permettant de dessiner la rotation d'une figure sur la grille test, avec un pivot donné.
//Argument: coordRotation renvoie les coordonées après rotation autour du pivot dans le repère (O, x, y) classique

function drawRotation(coordRotation){
	//On récupère les coordonées du pivot
	var x_pivot = getCoord($("#pivot")).x + 3; 
	var y_pivot = getCoord($("#pivot")).y + 3;
	
	//Pour chaque bloc autre que le pivot dans la grille de test, on applique le changement
	$(".bloc.test").each(function(){
		
		var x = getCoord($(this)).x;
		var y = getCoord($(this)).y;
		
		//On applique la rotation sur tous les autres points autre que le pivot
		if(!(x==x_pivot && y==y_pivot)){			
			//On calcule les nouvelles positions
			var coord = coordRotation(x, y, x_pivot, y_pivot);
			
			//On parcourt la liste des blocs vides et on cherche ceux qui correspondent à la nouvelle position
			
			
			//Cas particulier où le bloc recherché est un bloc existant
			$(".test.bloc")
			  .filter(function(index){
				return isLocatedOn($(this), coord.x_r, coord.y_r);
			  })
			  .addClass("new");
			
			drawBloc($(".case.test").not('bloc'), coord.x_r, coord.y_r);
			
			if($(this).hasClass("new")){
				$(this).removeClass("new");
			}
			
			else{
				removeBloc($(this));
			}
			
		}
	});	
}

//Coordonées d'un point (x,y) après rotation d'un angle de -90° autour d'un point (x_pivot, y_pivot)
function coordRotationDroite(x,y,x_pivot,y_pivot){
	return {x_r: (-y + y_pivot + x_pivot), y_r: x - x_pivot + y_pivot};
}

//Coordonées d'un point (x,y) après rotation d'un angle de -90° autour d'un point (x_pivot, y_pivot)
function coordRotationGauche(x,y,x_pivot, y_pivot){
	return {x_r : y - y_pivot + x_pivot, y_r : -x + x_pivot + y_pivot};
}

/*******    EVENEMENTS  ********/

//4.1 Action de clic sur la grille d'edition
$(".case:not(.test,.rot)").click(function() {
	if($(this).hasClass("bloc")){
		removeBloc($(this));
	}
	
	else{
		$(this).addClass("bloc");
		$(this).attr("name","bloc");
		$(this).css("background-color", $("#couleur_tetrimino").val());
	}
	

	//S'il n'y a plus aucun bloc sur la grille, on ne peut plus valider
	verifEdition();
});

//4.2.1 Action de clic sur le bouton supprimer lors de l'étape 4.Forme du tetrimino
$("#boutonFormeDelete").click(function(){
	removeBloc($(".case.bloc:not(.test,.rot)"))
	verifEdition();
})


//4.2.2 Action de clic sur le bouton valider lors de l'étape 4.Forme du tetrimino
$("#boutonForme").click(function(){
	//Envoi des coordonnées du bloc dans un formulaire
	saveBlocs($(".case.bloc:not(.test,.rot)"))
	
	//On enleve le pivot (cas d'édition)
	removePivot();
	
	//On efface les blocs présents dans l'onglet rotation (cas d'édition)

	removeBloc($(".bloc.test"));
	
	$(".bloc.rot").css("cursor","auto");
	removeBloc($(".bloc.rot"));
	
	//Dessin du bloc dans l'onglet rotation
	$(".bloc").each(function() {
		var x = getCoord($(this)).x;
	    var y = getCoord($(this)).y;
	    
	    //Dessin sur la grille choix du pivot
	    drawBloc($(".case.rot"), x, y);
	    
	    //Dessin sur la grille test
	    drawBloc($(".case.test"), x+3, y+3);
	});
	
	//On change le curseur de la souris sur la grille choix du pivot
    $(".bloc.rot").css("cursor", "pointer");
    
    //On bloque l'envoi du formulaire tant qu'on a pas choisi de pivot
    verifEdition();
	
});

//5.1 Action de clic sur la figure lors de l'étape de rotation
$(document).on('click', '.bloc.rot', function() {
	
	//Aucune action s'il existe déjà un pivot
	if(!($("#pivot").length)){
	 
	 //L'élement cliqué devient le pivot
	 $(this).attr('id','pivot');
	 $(this).css('opacity','1');
	 $(".bloc.rot").css('cursor','auto');
	 
	 //Si besoin, on dessine les blocs dans la grille test
	 $(".bloc.rot").each(function() {
		 var x = getCoord($(this)).x + 3;
	     var y = getCoord($(this)).y + 3;		 
	     drawBloc($(".case.test"), x, y);
	});
	 
	 //On active le bouton valider
     verifEdition();

     
 }
});


//5.2.1 Action de clic sur le bouton tourner à droite lors de l'étape 5.Forme du tetrimino
$("#rotateRight").click(function(){
	drawRotation(coordRotationDroite);
});

//5.2.2 Action de clic sur le bouton tourner à gauche lors de l'étape 5.Forme du tetrimino
$("#rotateLeft").click(function(){			
	drawRotation(coordRotationGauche);
});

//5.3.1 Action de clic sur le bouton supprimer lors de l'étape 5.Forme du tetrimino
$("#boutonRotationDelete").click(function(){
	
	//On supprime le pivot
	removePivot();
	
	//On desactive le bouton valider
	verifEdition();
});


//5.3.2Action de clic sur le bouton valider lors de l'étape 5.Forme du tetrimino
$("#boutonRotation").click(function(){
	//On sauvegarde les données du pivot sélectionné
	savePivot();
});
