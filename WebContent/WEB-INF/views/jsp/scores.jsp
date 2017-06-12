<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- Page écrite en dure. Elle sera ensuite réalisée avec les DAO pour récupérer les 10 meilleures parties -->


<h2>Vos meilleurs scores</h2>

<table class="striped centered">
	<thead>
		<tr>
			<th>Nom du joueur</th>
			<th>Points obtenus</th>
			<th>Nombre de lignes</th>
			<th>Niveau atteint</th>
		</tr>
	</thead>
	
	<tbody>
		<tr>
			<td>joueur1</td>
			<td>500</td>
			<td>25</td>
			<td>2</td>
		</tr>
	</tbody>
</table>

<br>

<h2>Meilleurs scores du jeu</h2>

<table class="striped centered">
	<thead>
		<tr>
			<th>Nom du joueur</th>
			<th>Points obtenus</th>
			<th>Nombre de lignes</th>
			<th>Niveau atteint</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${ scores }" var="score">
			<tr>
				<td>${score.joueur.username}</td>
				<td>${score.points}</td>
				<td>${score.lignes}</td>
				<td>${score.niveau}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>