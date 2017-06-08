<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!-- Déclaration des variable JSTL -->
<c:set var="joueur" value="joueur" />
<c:set var="spectateur" value="spectateur" />
<c:set var="administrateur" value="administrateur" />


<nav>
	<div class="nav-wrapper">
		<div class="container">
			<a class="brand-logo"> <spring:message code="${ titreCode }"></spring:message></a>


			<!-- Dropdown Structure -->
			<ul id="dropdownLang" class="dropdown-content">
				<li><a href="?lang=fr">Français</a></li>
				<li><a href="?lang=en">Anglais</a></li>
			</ul>


			<c:choose>
				<%-- L'utilisateur est un joueur --%>
				<c:when test="${ typeUtilisateur == joueur }">
					<ul id="nav-mobile" class="right hide-on-med-and-down">
					
						<!-- Dropdown Trigger -->
						<li><a class="dropdown-button" href="#!"
							data-activates="dropdownLang"><spring:message
									code="nav.langue" /><i
								class="material-icons right">arrow_drop_down</i></a></li>
								
						<li><a
							href="${ pageContext.request.contextPath }/account/home"><spring:message
									code="nav.home" /></a></li>

						<li><a href="${ pageContext.request.contextPath }/tetriminos"><spring:message
									code="nav.tetriminos" /></a></li>

						<li><a href="${ pageContext.request.contextPath }/parties"><spring:message
									code="nav.parties" /></a></li>

						<li><a href="${ pageContext.request.contextPath }/scores"><spring:message
									code="nav.scores" /></a></li>
					</ul>
				</c:when>

				<%-- L'utilisateur est un spectateur --%>
				<c:when test="${ typeUtilisateur == spectateur }">
					<ul id="nav-mobile" class="right hide-on-med-and-down">
						
						<!-- Dropdown Trigger -->
						<li><a class="dropdown-button" href="#!"
							data-activates="dropdownLang"><spring:message
									code="nav.langue" /><i
								class="material-icons right">arrow_drop_down</i></a></li>

						<li><a
							href="${ pageContext.request.contextPath }/account/home"><spring:message
									code="nav.home" /></a></li>

						<li><a href="${ pageContext.request.contextPath }/tetriminos"><spring:message
									code="nav.tetriminos" /></a></li>

						<li><a href="${ pageContext.request.contextPath }/parties"><spring:message
									code="nav.parties" /></a></li>
					</ul>
				</c:when>

				<%-- L'utilisateur est un administrateur --%>
				<c:when test="${ typeUtilisateur == administrateur }">
					<ul id="nav-mobile" class="right hide-on-med-and-down">

						<!-- Dropdown Trigger -->
						<li><a class="dropdown-button" href="#!"
							data-activates="dropdownLang"><spring:message
									code="nav.langue" /><i
								class="material-icons right">arrow_drop_down</i></a></li>

						<li><a
							href="${ pageContext.request.contextPath }/account/home"><spring:message
									code="nav.home" /></a></li>

						<li><a href="${ pageContext.request.contextPath }/tetriminos"><spring:message
									code="nav.tetriminos" /></a></li>
					</ul>

				</c:when>

				<%-- Pas d'utilisateur authentifié --%>
				<c:when test="${ typeUtilisateur == null }">
					<ul id="nav-mobile" class="right hide-on-med-and-down">

						<!-- Dropdown Trigger -->
						<li><a class="dropdown-button" href="#!"
							data-activates="dropdownLang"><spring:message
									code="nav.langue" /><i
								class="material-icons right">arrow_drop_down</i></a></li>
					</ul>

				</c:when>
			</c:choose>




		</div>
	</div>
</nav>
