<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>


<!-- Déclaration des variable JSTL -->
<c:set var="joueur" value="joueur"/>
<c:set var="spectateur" value="spectateur"/>
<c:set var="administrateur" value="administrateur"/>


<nav>
	<div class="nav-wrapper">
		<div class="container">
			<a class="brand-logo"> <tiles:insertAttribute name="title" /></a>
			
			
			<c:choose>
				<%-- L'utilisateur est un joueur --%>
				<c:when test="${ typeUtilisateur == joueur }">
					<ul id="nav-mobile" class="right hide-on-med-and-down">
						<li><a href="${ pageContext.request.contextPath }/account/home">Accueil</a></li>
	
						<li><a href="${ pageContext.request.contextPath }/tetriminos">Tetriminos</a></li>
	
						<li><a href="${ pageContext.request.contextPath }/parties">Jouer</a></li>
	
						<li><a href="${ pageContext.request.contextPath }/scores">High-Score</a></li>
					</ul>
 				</c:when>
 				
 				<%-- L'utilisateur est un spectateur --%>
				<c:when test="${ typeUtilisateur == spectateur }">
					<ul id="nav-mobile" class="right hide-on-med-and-down">
						<li><a href="${ pageContext.request.contextPath }/account/home">Accueil</a></li>
	
						<li><a href="${ pageContext.request.contextPath }/tetriminos">Tetriminos</a></li>
	
						<li><a href="${ pageContext.request.contextPath }/parties">Regarder une partie</a></li>
					</ul>
				</c:when>
 				
 				 <%-- L'utilisateur est un administrateur --%>
				<c:when test="${ typeUtilisateur == administrateur }">
					<ul id="nav-mobile" class="right hide-on-med-and-down">
						<li><a href="${ pageContext.request.contextPath }/account/home">Accueil</a></li>
	
						<li><a href="${ pageContext.request.contextPath }/tetriminos">Tetriminos</a></li>
					</ul>
				</c:when>
			</c:choose>



		</div>
	</div>
</nav>
