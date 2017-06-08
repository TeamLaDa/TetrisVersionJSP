<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>



<div class="row">
	<form:form class="col s12" method="POST" action="" modelAttribute="user" >

		<c:if test="${ MessageAlertSubscribe == true }">
			<p class="red-text text-accent-4">Ce nom d'utilisateur existe
				déjà, veuillez en choisir un autre !</p>
		</c:if>

		<!-- Nom d'utilisateur -->
		<div class="row">
			<div class="input-field col s6">
				<i class="material-icons prefix">account_circle</i>
				<form:input class="validate" path="username" />
				<form:label path="username"
					data-error-memenom="Nom d'utilisateur déjà existant, veuillez en choisir un nouveau !"
					data-error-regex="Le nom d'utilisateur saisi contient un caractère incorrect."
					data-success=""><spring:message code="subscribe.username" /></form:label>
			</div>
		</div>

		<!-- Mot de Passe -->
		<div class="row">
			<div class="input-field col s6">
				<i class="material-icons prefix">vpn_key</i>
				<form:input class="validate" type="password" path="password" />
				<form:label path="password"
					data-error="" data-success=""><spring:message code="subscribe.password" /></form:label>
			</div>
		</div>

		<!-- Confirmation du mot de passe -->
		<div class="row">
			<div class="input-field col s6">
				<i class="material-icons prefix">vpn_key</i>
				<input class="validate" type="password" name="passwordVerif" id="passwordVerif" />
				<label for="passwordVerif"
					data-error="Le mot de passe est différent" data-success=""><spring:message code="subscribe.password.verif" /></label>
			</div>
		</div>

		<!-- Nom de l'utilisateur -->
		<div class="row">
			<div class="input-field col s6">
				<i class="material-icons prefix">perm_identity</i>
				<form:input class="validate" path="nom" />
				<form:label path="nom" data-error="Le mot de passe est différent"
					data-success=""><spring:message code="subscribe.nom" /></form:label>

			</div>
		</div>

		<!-- Prénom de l'utilisateur -->
		<div class="row">
			<div class="input-field col s6">
				<i class="material-icons prefix">perm_identity</i>
				<form:input class="validate" path="prenom" />
				<form:label path="prenom" data-error="" data-success=""><spring:message code="subscribe.prenom" /></form:label>
			</div>
		</div>


		<!-- Switch entre le choix d'être Joueur ou Spectateur -->
		<div><spring:message code="subscribe.player.spectator" /></div>
		<p>
			<input name="joueurSpectateurButton" type="radio" id="joueurButton"
				value="joueur" />
			<label for="joueurButton"><spring:message code="subscribe.joueur" /></label>
		</p>
		<p>
			<input name="joueurSpectateurButton" type="radio"
				id="spectateurButton" value="spectateur" />
			<label for="spectateurButton"><spring:message code="subscribe.spectateur" /></label>
		</p>

		<!-- Bouton à décommenter si volonté de créer un administrateur -->
		<!-- 
		<p>
			<input name="joueurSpectateurButton" type="radio"
				id="administrateurButton" value="administrateur" /> <label
				for="administrateurButton"><spring:message code="subscribe.administrateur" /></label>
		</p>
 		-->

		<!-- Bouton permettant l'envoie du formulaire -->
		<button id=submitSubscribe disabled="disabled"
			class="btn waves-effect waves-light" type="submit" name="action">
			<spring:message code="subscribe.subscribe" /><i class="material-icons right">send</i>
		</button>

		<a class="btn waves-effect waves-light" href="login"><spring:message code="subscribe.login" /><i
			class="material-icons right">replay</i>
		</a>
	</form:form>
</div>