<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<br>

<form:form class="col s12" method="POST" action="" modelAttribute="user">

	<div class="row">
		<div class="input-field col s6">
			<i class="material-icons prefix">account_circle</i>
			<form:input class="validate" path="username" />
			<form:label path="username"
				data-error="" data-success="">Nom d'Utilisateur</form:label>
		</div>
	</div>


	<div class="row">
		<div class="input-field col s6">
			<i class="material-icons prefix">vpn_key</i>
			<form:input class="validate" type="password" path="password" />
			<form:label path="password" data-error=""
				data-success="">Mot de passe</form:label>
		</div>
	</div>


	<c:if test="${ MessageAlertLogin == true }">
		<p class="red-text text-accent-4">Veuillez vérifier votre mot de passe !</p>
	</c:if>

	<button id="submitLogin" disabled="disabled"
		class="btn waves-effect waves-light" type="submit">
		S'identifier<i class="material-icons right">send</i>
	</button>

	<a class="btn waves-effect waves-light" href="/TetrisVersionJSP/account/subscribe">
	S'enregistrer
	</a>
</form:form>
