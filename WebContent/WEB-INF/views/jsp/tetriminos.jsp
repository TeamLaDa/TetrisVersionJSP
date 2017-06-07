<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- Définition d'un constante -->
<c:set var="administrateur" value="administrateur"/>


<!-- On affiche les tetriminos en ligne -->
<div class = "row">

	<!-- On parcourt la liste des tetriminos -->
	
	
	<c:forEach items="${ tetri }" var="tetrimino">	
	
    <!--------------------- Affichage du Tetrimino ----------------------->

	<!-- Taille en largeur du Tetrimino -->
	  <div class="col s12 m6 l3">
	  	<div class = "card">
	  	
	  	<!-- Affichage du cadre coloré -->
	  	<div class = "card-image" id="image-tetrimino" style="background-color:${ tetrimino.couleur }">
	  	
	  	<!-- Nom du tetrimino sur le cadre -->
    	  <h5 id="texte-image">${ tetrimino.nom }</h5>
	    </div>
	    
   	      <!-- Bandeau d'information supplementaires -->
		  <div class="card-reveal">
	        <span class="card-title grey-text text-darken-4">${ tetrimino.nom }<i class="material-icons right">close</i></span>
		  </div>
	    
	    <!-- Affichage des boutons retirer et editer -->

	    <c:if test="${ montrerActions }">
	  		<div class="card-action">		  
			    <!-- On passe les id des tetriminos pour les actions d'edition et suppression. Les id des formulaires servent a lier les boutons sur l'affichage-->
			    <div class="button-container">
			      <form method="POST" action="tetriminos/delete" id="formSupprimer">
				    <input type ="hidden" name="id_supprimer" value="${ tetrimino.id }" >
   		            <button  type="submit">RETIRER</button>
				  </form>
			    
			      <form method="POST" action="editTetrimino" id="formEditer">
				    <input type ="hidden" name="id_editer" value="${ tetrimino.id }" >
  				    <button type="submit">EDITER</button>
				  </form>
				</div>
		      </div>
	      </c:if>
	     </div>
	    </div>
	</c:forEach>
	
	
	
	<!-- Bouton Ajouter uniquement s'il s'agit de l'administrateur -->
	<c:if test="${ typeUtilisateur == administrateur }">
		<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
			<form method="POST" action="editTetrimino">
		    	<button class="btn-floating btn-large waves-effect waves-light red" type="submit"><i class="material-icons">add</i></button>
			</form>
		</div>
	</c:if>
</div>

