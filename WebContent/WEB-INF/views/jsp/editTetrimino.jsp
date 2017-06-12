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
      <div class="collapsible-header #eeeeee grey lighten-3 locked active" id="choixNom"><i class="material-icons">text_fields</i> <b>1. Nom du Tetrimino</b></div>
          <div class="collapsible-body">
            <div class="row">
              <div class="input-field col s6">

                <input value="${tetrimino_old.nom }" id="nom_tetrimino" type="text" name="tetrimino_new_nom">
                <label for="nom_tetrimino">Nom</label>

              </div>
            <button class="btn-floating waves-effect waves-light blue" type="button" id="boutonNom" disabled="disabled"><i class="material-icons">mode_edit</i></button>
           </div>
          </div>
        </li>

      <!-- 2- Choisir la couleur -->
      <li>
       <div class="collapsible-header #eeeeee grey lighten-3 locked" id="choixCouleur" disabled="disabled"><i class="material-icons">color_lens</i> <b>2. Couleur du Tetrimino</b></div>
         <div class="collapsible-body">
          <div class="row">
            <div class="input-field col s6">

            <input value="${tetrimino_old.couleur }" id="couleur_tetrimino" type="color" value="#000" name="tetrimino_new_couleur">

            </div>
            <a class="btn-floating waves-effect waves-light blue" id="boutonCouleur" disabled="disabled"><i class="material-icons">mode_edit</i></a>
          </div>
        </div>
      </li>

      <!-- 3- Choisir la forme -->
      <li>
       <div class="collapsible-header #eeeeee grey lighten-3 locked" id="choixForme"><i class="fa fa-cubes"></i> <b>3. Forme du Tetrimino</b></div>
         <div class="collapsible-body">
          <div class="row">

          <!-- Dessin de la grille 3x3-->

          <div class="col s3">
            <c:set var="num_bloc" value="0" scope="page"/>
            <c:forEach var="y" begin = "0" end="2">
              <div class= "row" style="margin-bottom: 0px;">
                <c:forEach var="x" begin = "0" end="2">
                  <c:set var="isEmpty" value="true"/>
                <%--Pour chaque case de la grille, on definit les paramètres suivants --%>
                <%-- x et y les coordonnées de la case --%>
                <%-- isEmpty (booléen) : true si la case est vide, false si un bloc est présent --%>
                <%-- idBloc : permet de différencier chaque bloc que l'on va envoyer en requete, afin
                de les persister par la suite. C'est un id temporaire (ne correspond pas à la PK), que l'on incrémente 
                à chaque bloc que l'on crée sur la grille--%>

                   <%--On parcourt la liste des blocs pour voir s'il en existe un sur l'emplacement x,y sélectionné--%>
                   <%--S'il n'existe pas encore de blocs (cas de création), on ne rentre même pas dans la boucle --%>
                   <c:forEach items="${tetrimino_old.figures[0].blocs}" var="bloc">

                     <c:if test="${bloc.positionX == x && bloc.positionY == y }">
                       <%--Dans le cas ou il existe un bloc, on l'affiche sur la grille, avec la couleur du tetrimino--%>
                       <c:set var="isEmpty" value="false" scope="page"/>
                       <div class="case bloc" style="background-color:${tetrimino_old.couleur};">
                         <%--Elements à envoyer au script JS --%>
                         <input type="hidden" name="x" value="${x}"/>
                         <input type="hidden" name="y" value="${y}"/>
                         
                         <%--Elements à envoyer au controleur --%>

                         <input type="hidden" class="data" name="bx${num_bloc}" value="${x}"/>
                         <input type="hidden" class="data" name="by${num_bloc}" value="${y}"/>

                         <c:set var="num_bloc" value="${num_bloc + 1}"/>
                         
                       </div>
                     </c:if>

                   </c:forEach>

                   <%--Cas ou après parcours de la liste des blocs il n'y en a aucun à l'emplacement x,y : on affiche une case vide --%>
                   <c:if test="${isEmpty eq true}">
                       <div class="case">
                         <%--Elements à envoyer au script JS --%>
                         <input type="hidden" name="x" value="${x}"/>
                         <input type="hidden" name="y" value="${y}"/>
                       </div>
                   </c:if>
                </c:forEach>
             </div>
            </c:forEach>
          </div>

            <a class="btn-floating waves-effect waves-light green" id="boutonForme" disabled="disabled"><i class="material-icons">done</i></a>
            <a class="btn-floating waves-effect waves-light red" id="boutonFormeDelete"><i class="material-icons">delete</i></a>

         </div>
         </div>
      </li>

      <!-- 4- Choix du pivot de rotation -->
      <!-- Dessin de la grille 3x3 (selection du pivot)-->
      <li>
       <div class="collapsible-header #eeeeee grey lighten-3 locked" id="choixRotation"><i class="fa fa-rotate-right"></i> <b>4. Rotation du Tetrimino</b></div>
         <div class="collapsible-body">
         <div class="row">

          <div class="col s3">
            <c:forEach var="y" begin = "0" end="2">
              <div class= "row" style="margin-bottom: 0px;">
                <c:forEach var="x" begin = "0" end="2">
                  <c:set var="isEmpty" value="true"/>
                  <c:forEach items="${tetrimino_old.figures[0].blocs}" var="bloc">
                    <c:if test="${bloc.positionX == x && bloc.positionY == y }">


                      <c:set var="isEmpty" value="false"/>


                      <c:if test="${bloc.pivot eq true }">
                        <div class="case bloc rot" id="pivot" style="background-color:${tetrimino_old.couleur};">
                         <%--Elements à envoyer au script JS --%>
                           <input type="hidden" name="x" value="${x}"/>
                           <input type="hidden" name="y" value="${y}"/>
                           
                        </div>
                      </c:if>

                      <c:if test="${bloc.pivot eq false }">
                        <div class="case bloc rot" style="background-color:${tetrimino_old.couleur};">
                        <%--Elements à envoyer au script JS --%>
                           <input type="hidden" name="x" value="${x}"/>
                           <input type="hidden" name="y" value="${y}"/>
                        </div>
                      </c:if>

                    </c:if>
                  </c:forEach>
                  <c:if test="${isEmpty eq true}">
                     <div class="case rot">
                       <%--Elements à envoyer au script JS --%>
                       <input type="hidden" name="x" value="${x}"/>
                       <input type="hidden" name="y" value="${y}"/>
                     </div>
                  </c:if>
                </c:forEach>
               </div>
              </c:forEach>

          </div>

          <!-- Dessin de la grille de test -->

            <div class="col s4 center.align">
              <div class="row z-depth-2">
                <c:forEach var="y" begin="0" end="8">
                  <div class="row" style="margin-bottom: 0px;">
                    <c:forEach var="x" begin="0" end="8">
                      <c:set var="isEmpty" value="true" />
                      <c:forEach items="${tetrimino_old.figures[0].blocs}"
                        var="bloc">
                        <c:if
                          test="${bloc.positionX+3 == x && bloc.positionY+3 == y }">


                          <c:set var="isEmpty" value="false" />
                            <div class="case test bloc"
                              style="background-color:${tetrimino_old.couleur};">
                              <%--Elements à envoyer au script JS --%>
                              <input type="hidden" name="x" value="${x}"/>
                              <input type="hidden" name="y" value="${y}"/>
                            </div>
                        </c:if>
                      </c:forEach>
                      <c:if test="${isEmpty eq true}">
                        <div class="case test ">
                          <%--Elements à envoyer au script JS --%>
                          <input type="hidden" name="x" value="${x}"/>
                          <input type="hidden" name="y" value="${y}"/>
                        </div>
                      </c:if>
                    </c:forEach>
                  </div>
                </c:forEach>
              </div>

              <!-- Boutons de rotation -->
              <div class="center-align">
              <a class="btn waves-effect waves-light blue" id="rotateLeft">
                 <i class="fa fa-caret-left"></i>
              </a>
              <a class="btn waves-effect waves-light blue" id="rotateRight">
                 <i class="fa fa-caret-right"></i>
              </a>
              </div>
            </div>

            <a class="btn-floating waves-effect waves-light green" id="boutonRotation" disabled="disabled"><i class="material-icons">done</i></a>
            <a class="btn-floating waves-effect waves-light red" id="boutonRotationDelete"><i class="material-icons">delete</i></a>
          </div>
        </div>
      </li>

      <!-- Hors perimiètre -->
<%--       <!-- 5- Choisir le poids du tetrimino -->
      <li>
       <div class="collapsible-header #eeeeee grey lighten-3" id="choixPoids"><i class="fa fa-rotate-right"></i> <b>5. Points du Tetrimino</b></div>
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

      --%>
    </ul>

    <input type="hidden" value=${ tetrimino_old.id} name="tetrimino_new_id"/>
    <input type="hidden" value="true" name="editFormIsValid"/>

      <button class="btn waves-effect waves-light" type="button" name="action" id="submitEdition" disabled="disabled">Valider
        <i class="material-icons right">send</i>
      </button>
  </form>
  </div>
