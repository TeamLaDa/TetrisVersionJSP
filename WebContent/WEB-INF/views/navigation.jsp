<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	
<nav>
	<div class="nav-wrapper">
		<div class="container">
			<a class="brand-logo"> Tetris -  ${ pageTitle }</a>
			<c:if test="${ username != null}">
				<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li><a href="home">Accueil</a>
				</li>
			
				<li>
				<a href="tetriminos">Tetriminos</a>
				</li>
				</ul>
			</c:if>
		</div>
	</div>
</nav>
