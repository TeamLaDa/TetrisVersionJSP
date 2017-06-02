<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<br>

<div class="row"> 
<!-- Formulaire d'édition du Tetrimino -->
	<form class="col s12" method="POST" action="">
			<ul class="collapsible" data-collapsible="accordion">
			
			<!-- 1- Choisir le nom -->
			<li>
			<div class="collapsible-header #eeeeee grey lighten-3"><i class="material-icons">text_fields</i> <b>1. Nom du Tetrimino</b></div>
				  <div class="collapsible-body">
				    <div class="row">
				      <div class="input-field col s6">
				 
				        <input value="${tetrimino_old.nom }" id="nom_tetrimino" type="text" name="tetrimino_new_nom">
			          <label for="nom_tetrimino">Nom</label>
			          
				      </div>
            <button class="btn-floating waves-effect waves-light blue" type="button" id="boutonNom"><i class="material-icons">mode_edit</i></button>
				   </div>
				  </div>
		    </li>
			
			<!-- 2- Choisir la couleur -->
	    <li>
		   <div class="collapsible-header #eeeeee grey lighten-3"><i class="material-icons">color_lens</i> <b>2. Couleur du Tetrimino</b></div>	
	 		   <div class="collapsible-body">
	 	      <div class="row">
	          <div class="input-field col s6">
	          
	            <input value="${tetrimino_old.couleur }" id="couleur_tetrimino" type="text" name="tetrimino_new_couleur">
	 	          <label for="couleur_tetrimino">Couleur</label>
	 	          
	   	      </div>
            <a class="btn-floating waves-effect waves-light blue" id="boutonCouleur"><i class="material-icons">mode_edit</i></a>
	   	    </div>
	   	  </div>
	    </li>
	    
	    <!-- 3- Choisir la forme -->
      <li>
       <div class="collapsible-header #eeeeee grey lighten-3 active"><i class="fa fa-cubes"></i> <b>3. Forme du Tetrimino</b></div> 
         <div class="collapsible-body">
          <div class="row">
          
          <!-- Dessin de la grille -->
            <div class="col s2">
            
            <!-- Premiere ligne -->
            <div class= "row" style="margin-bottom: 0px;">
              <div class="square"></div>
              <div class="square"></div>
              <div class="square"></div>
              <div class="square"></div>
           </div>
              
           <div class= "row" style="margin-bottom: 0px;">
              <div class="square"></div>
              <div class="square"></div>
              <div class="square"></div>
              <div class="square"></div>
           </div>
                   
           <div class= "row" style="margin-bottom: 0px;">
              <div class="square"></div>
              <div class="square"></div>
              <div class="square"></div>
              <div class="square"></div>
           </div>
           
           <div class= "row" style="margin-bottom: 0px;">
              <div class="square"></div>
              <div class="square"></div>
              <div class="square"></div>
              <div class="square"></div>
           </div>
        </div>
            <a class="btn-floating waves-effect waves-light blue" id="boutonForme"><i class="material-icons">mode_edit</i></a>
         </div>
         </div>
      </li>
      
      <!-- 4- Choisir le pivot de rotation -->
      <li>
       <div class="collapsible-header #eeeeee grey lighten-3"><i class="fa fa-rotate-right"></i> <b>4. Rotation du Tetrimino</b></div> 
         <div class="collapsible-body">
          <div class="row">
            <div class="col s6">
            
            </div>
            <a class="btn-floating waves-effect waves-light blue" id="boutonRotation"><i class="material-icons">mode_edit</i></a>
          </div>
        </div>
      </li>     
               	
	  </ul>
	  <input type="hidden" value=${ tetrimino_old.id} name="tetrimino_new_id"/>
		  <button class="btn waves-effect waves-light" type="submit" name="action" id="submitEdition">Valider
		    <i class="material-icons right">send</i>
		 	</button>
	</form>
</div>