/**
 * Script permettant d'ajouter/supprimer des blocs sur la grille lors de l'edition d'un tetrimino
 */


/******* FONCTIONS ********/

//Fonction de retrait du pivot
function removePivot() {
	$("#pivot").css("opacity", "0.5");
	$("#pivot").removeAttr("id");
	$(".rot").css("cursor","pointer");
	$(".bloc.test").css("background-color", "white");
	$(".bloc.test").removeClass("bloc");
}

function drawBloc(el, x, y){
	
	//Cas particulier pour la rotation sur la grille test

		el.not("bloc")
		  .filter(function(index){
			return ($(this).children("input[name='x']").val() == x && $(this).children("input[name='y']").val() == y)
		  })
		  .css("background-color", $("#couleur_tetrimino").val())
		  .addClass("bloc")
}




/*******    EVENEMENTS  ********/

//Action de clic sur la grille lors de l'étape 4.Forme du tetrimino
$(".case").not($(".rot")).not($(".test")).click(function() {
	if($(this).hasClass("bloc")){
		$(this).removeClass("bloc");
		$(this).css("background-color", "white");

	}
	
	else{
		$(this).addClass("bloc");
		$(this).css("background-color", $("#couleur_tetrimino").val());
	}
});

//Action de clic sur le bouton supprimer lors de l'étape 4.Forme du tetrimino
$("#boutonFormeDelete").click(function(){
	$(".case").not($(".rot")).not($(".test")).removeClass("bloc")
	$(".case").not($(".rot")).not($(".test")).css("background-color", "white")
})


//Action de clic sur le bouton valider lors de l'étape 4.Forme du tetrimino
$("#boutonForme").click(function(){
});

//Action de clic sur la figure lors de l'étape 5.Rotation
$(".rot").click(function() {
	
	//Aucune action s'il existe déjà un pivot
	if(!($("#pivot").length)){
	 
	 //L'élement cliqué devient le pivot
	 $(this).attr('id','pivot');
	 $(this).css('opacity','1');
	 $(".rot").css('cursor','auto');
	 
	 //Si besoin, on dessine les blocs dans la grille test
	 $(".rot").each(function() {
		 var x = parseInt($(this).children("input[name='x']").val(),10)+3;
	     var y = parseInt($(this).children("input[name='y']").val(),10)+3;		 
	     drawBloc($(".case.test"), x, y);
	});

     
 }
});


//Action de clic sur le bouton tourner à droite lors de l'étape 5.Forme du tetrimino
$("#rotateRight").click(function(){
	
	//On récupère les coordonées du pivot
	var x_pivot = parseInt($("#pivot").children("input[name='x']").val(), 10); 
	var y_pivot = parseInt($("#pivot").children("input[name='y']").val(), 10);
	
	x_pivot+=3;
	y_pivot+=3;
	
	//Pour chaque bloc autre que le pivot dans la grille de test, on applique le changement
	$(".bloc.test").not($("#pivot")).each(function(){
		//On ajoute une classe temporaire au bloc
		$(".this").addClass("tmp");
		
		var x = parseInt($(this).children("input[name='x']").val(),10);
		var y = parseInt($(this).children("input[name='y']").val(),10);
		
		//On applique la rotation sur tous les autres points autre que le pivot
		if(!(x==x_pivot && y==y_pivot)){			
			//On calcule les nouvelles positions
			var x_r = -y + y_pivot + x_pivot;
			var y_r = x - x_pivot + y_pivot;
			
			//On parcourt la liste des blocs vides et on cherche ceux qui correspondent à la nouvelle position
			
			
			//Cas particulier où le bloc recherché est un bloc existant
			$(".test.bloc")
			  .filter(function(index){
				return ($(this).children("input[name='x']").val() == x_r && $(this).children("input[name='y']").val() == y_r)
			  })
			  .addClass("new");
			
			drawBloc($(".case.test").not('bloc'), x_r, y_r);
			
			if($(this).hasClass("new")){
				$(this).removeClass("new");
			}
			
			else{
				$(this).removeClass("bloc");
				$(this).css("background-color", "white");
			}
			
		}
	});
});

//Action de clic sur le bouton tourner à gauche lors de l'étape 5.Forme du tetrimino
$("#rotateLeft").click(function(){			
			//On récupère les coordonées du pivot
			var x_pivot = parseInt($("#pivot").children("input[name='x']").val(), 10); 
			var y_pivot = parseInt($("#pivot").children("input[name='y']").val(), 10);
			
			x_pivot+=3;
			y_pivot+=3;
			
			//Pour chaque bloc autre que le pivot dans la grille de test, on applique le changement
			$(".bloc.test").not($("#pivot")).each(function(){
				//On ajoute une classe temporaire au bloc
				$(".this").addClass("tmp");
				
				var x = parseInt($(this).children("input[name='x']").val(),10);
				var y = parseInt($(this).children("input[name='y']").val(),10);
				
				//On applique la rotation sur tous les autres points autre que le pivot
				if(!(x==x_pivot && y==y_pivot)){			
					//On calcule les nouvelles positions
					//On calcule les nouvelles positions
					var x_r = y - y_pivot + x_pivot;
					var y_r = -x + x_pivot + y_pivot;
					
					//On parcourt la liste des blocs vides et on cherche ceux qui correspondent à la nouvelle position
					
					
					//Cas particulier où le bloc recherché est un bloc existant
					$(".test.bloc")
					  .filter(function(index){
						return ($(this).children("input[name='x']").val() == x_r && $(this).children("input[name='y']").val() == y_r)
					  })
					  .addClass("new");
					
					drawBloc($(".case.test").not('bloc'), x_r, y_r);
					
					if($(this).hasClass("new")){
						$(this).removeClass("new");
					}
					
					else{
						$(this).removeClass("bloc");
						$(this).css("background-color", "white");
					}
					
				}
			});
});

//Action de clic sur le bouton supprimer lors de l'étape 5.Forme du tetrimino
$("#boutonRotationDelete").click(function(){
	removePivot();
});


//Action de clic sur le bouton valider lors de l'étape 5.Forme du tetrimino
