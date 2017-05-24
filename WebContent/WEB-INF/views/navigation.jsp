<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	
<div>
	${ pageTitle }
	
	<c:if test="${ username != null}">
		<form method="POST" action="home">
			<input type="submit" value="Accueil" />
		</form>
	
		<form method="POST" action="tetriminos">
			<input type="submit" value="Tetriminos" />
		</form>
	</c:if>

</div>