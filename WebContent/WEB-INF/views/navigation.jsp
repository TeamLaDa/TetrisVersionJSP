<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- Déclaration des variable JSTL -->
<c:set var="joueur" value="joueur"/>
<c:set var="spectateur" value="spectateur"/>
<c:set var="administrateur" value="administrateur"/>


<nav>
	<div class="nav-wrapper">
		<div class="container">
			<a class="brand-logo"> Tetris - ${ pageTitle }</a>
			
			
			<c:choose>
				<c:when test="${ typeUtilisateur == joueur }">
					<ul id="nav-mobile" class="right hide-on-med-and-down">
						<li><a href="home">Accueil</a></li>
	
						<li><a href="tetriminos">Tetriminos</a></li>
	
						<li><a href="parties">Jouer</a></li>
	
						<li><a href="score">High-Score</a></li>
					</ul>
 				</c:when>
 				
				<c:when test="${ typeUtilisateur == spectateur }">
					<ul id="nav-mobile" class="right hide-on-med-and-down">
						<li><a href="home">Accueil</a></li>
	
						<li><a href="tetriminos">Tetriminos</a></li>
	
						<li><a href="jouer">Regarder une partie</a></li>
					</ul>
				</c:when>
 				
				<c:when test="${ typeUtilisateur == administrateur }">
					<ul id="nav-mobile" class="right hide-on-med-and-down">
						<li><a href="home">Accueil</a></li>
	
						<li><a href="tetriminos">Tetriminos</a></li>
					</ul>
				</c:when>
			</c:choose>



		</div>
	</div>
</nav>
