<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Voici la liste des Tetriminos créés :</h2>
<ul>
	<c:forEach items="${ tetriminos }" var="tetrimino">
		<li>Nom du tetrimino : ${ tetrimino.nom }, avec sa couleur
			associée : ${ tetrimino.couleur }
			<form method="POST" action="editTetrimino">
				<input type ="hidden" name="id_editer" value="${ tetrimino.id }" >
				<input type="submit" value="Editer" >
			</form>
			<form method="POST" action="deleteTetrimino">
				<input type ="hidden" name="id_supprimer" value="${ tetrimino.id }" >
				<input type="submit" value="Supprimer" >
			</form>
		</li>
	</c:forEach>
</ul>

<form method="POST" action="editTetrimino">
	<input type="submit" value="Ajouter" />
</form>