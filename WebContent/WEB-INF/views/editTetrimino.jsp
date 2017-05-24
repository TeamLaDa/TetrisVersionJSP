<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<form method="POST" action="">

	<p>Nom du tetrimino : 			
		<input type="text" 
		name="tetrimino_new_nom"
		value="${tetrimino_old.nom }"
		placeholder="Entrez un nom"/>
	</p>
	<p>Couleur du tetrimino : 
		<input type="text" 
		name="tetrimino_new_couleur"
		value="${tetrimino_old.couleur }"
		placeholder="Entrez une couleur"/><p>
		<input type="submit" value="Modifier">
	</p>
	
	<input type="hidden"
	value=${ tetrimino_old.id}
	name="tetrimino_new_id"/>
</form>
