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
	          
	          	<!-- 
	            <input value="${tetrimino_old.couleur }" id="couleur_tetrimino" type="text" name="tetrimino_new_couleur">
	 	          <label for="couleur_tetrimino">Couleur</label>
	 	        -->
	 	        <input value="${tetrimino_old.couleur }" id="couleur_tetrimino" type="color" value="#000" name="tetrimino_new_couleur">
	 	          
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
          
          <!-- Dessin de la grille 4x4-->

          <div class="col s3">
            <c:forEach var="y" begin = "0" end="2">
              <div class= "row" style="margin-bottom: 0px;">
                <c:forEach var="x" begin = "0" end="2">
                  <c:set var="isEmpty" value="true"/>
                
                <%--Pour chaque case de la grille, on envoie trois paramètres à la servlet editBloc: --%>
                <%-- x et y les coordonnées de la case --%>
                <%-- isEmpty (booléen) : true si la case est vide, false si un bloc est présent --%>
              
                   <%--On parcourt la liste des blocs pour voir s'il en existe un sur l'emplacement x,y sélectionné--%>
                   <%--S'il n'existe pas encore de blocs (cas de création), on ne rentre même pas dans la boucle --%>
                   <c:forEach items="${tetrimino_old.figures[0].blocs}" var="bloc">

                     <c:if test="${bloc.positionX == x && bloc.positionY == y }">
                       <%--Dans le cas ou il existe un bloc, on l'affiche sur la grille, avec la couleur du tetrimino--%>
                       <c:set var="isEmpty" value="false"/>
                       <div class="bloc" style="background-color: ${tetrimino_old.couleur};">
                         <%--Elements à envoyer au script JS --%>                       
                         <input type="hidden" name="x" value="${x}"/>
                         <input type="hidden" name="y" value="${y}"/>
                         <input type="hidden" name="isEmpty" value="${isEmpty}"/>
                         <input type="hidden" name="blocCouleur" value="${tetrimino_old.couleur}"/>
                       </div>        
                     </c:if>
                     
                   </c:forEach>
                   
                   <%--Cas ou après parcours de la liste des blocs il n'y en a aucun à l'emplacement x,y : on affiche une case vide --%>                    
                   <c:if test="${isEmpty eq true}">
                       <div class="bloc">
                         <%--Elements à envoyer au script JS --%>                       
                         <input type="hidden" name="x" value="${x}"/>
                         <input type="hidden" name="y" value="${y}"/>
                         <input type="hidden" name="isEmpty" value="${isEmpty}"/>
                         <input type="hidden" name="blocCouleur" value="${tetrimino_old.couleur}"/>
                       </div>
                   </c:if>
                </c:forEach>
             </div>
            </c:forEach>
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


      <!-- 5- Choisir le poids du tetrimino --> 
      <li> 
       <div class="collapsible-header #eeeeee grey lighten-3"><i class="fa fa-rotate-right"></i> <b>5. Points du Tetrimino</b></div>  
         <div class="collapsible-body"> 
          <div class="row"> 
      <div class="input-field col s6"> 
         <p class="range-field"> 
            <input type="range" id="pointsTetrimino" min="1" max="100" name="pointsTetrimino"/> 
          </p> 
      </div> 
            <a class="btn-floating waves-effect waves-light blue" id="boutonPoints"><i class="material-icons">mode_edit</i></a> 
          </div> 
        </div> 
      </li>   
               	
	  </ul>
	  <input type="hidden" value=${ tetrimino_old.id} name="tetrimino_new_id"/>
	  <input type="hidden" value="true" name="editFormIsValid"/>

		  <button class="btn waves-effect waves-light" type="submit" name="action" id="submitEdition">Valider
		    <i class="material-icons right">send</i>
		 	</button>
	</form>
</div>