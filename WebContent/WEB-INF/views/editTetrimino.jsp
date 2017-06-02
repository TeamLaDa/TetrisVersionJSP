<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<br>
<div class="row">    
	<form class="col s12" method="POST" action="">
	
	    <div class="row">
	      <div class="input-field col s12">
	        <input value="${tetrimino_old.nom }" id="nom_tetrimino" type="text" name="tetrimino_new_nom">
          	<label for="nom_tetrimino">Nom</label>
	      </div>
	    </div>
			
	    <div class="row">
	      <div class="input-field col s12">
	        <input value="${tetrimino_old.couleur }" id="couleur_tetrimino" type="text" name="tetrimino_new_couleur">
     	    <label for="couleur_tetrimino">Couleur</label>
	        
	      </div>
	    </div>
	    
    	<input type="hidden" value=${ tetrimino_old.id} name="tetrimino_new_id"/>
		
	    <button class="btn waves-effect waves-light" type="submit" name="action" id="submitEdition">Valider
	    	<i class="material-icons right">send</i>
	 	</button>
	</form>
</div>

<script type="text/javascript" src="js/verifEditionTetrimino.js"></script>