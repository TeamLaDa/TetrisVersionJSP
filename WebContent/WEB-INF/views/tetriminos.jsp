<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tetriminos</title>
</head>
<body>

	<h2>Voici la liste des Tetriminos créés :</h2>
	<ul>
		<c:forEach items="${ Tetriminos }" var="tetrimino">
			<li>Nom du tetrimino : ${ tetrimino.nom }, avec sa couleur
				associée : ${ tetrimino.couleur }
				<form method="POST" action="editTetrimino">
					<input type="submit" value="Editer" />
				</form>
				<form method="POST" action="deleteTetrimino">
					<input type="submit" value="Supprimer" />
				</form>
			</li>
		</c:forEach>
	</ul>
	
	<form method="POST" action="editTetrimino">
		<input type="submit" value="Ajouter" />
	</form>

</body>
</html>