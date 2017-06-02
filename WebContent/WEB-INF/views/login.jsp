<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<br>

<form class="col s12" method="POST" action="">

	<div class="row">
		<div class="input-field col s6">
			<i class="material-icons prefix">account_circle</i> <input
				id="utilisateurLogin" type="text" class="validate"
				name="nom_utilisateur"> <label for="utilisateur"
				data-error="" data-success="">Nom d'Utilisateur</label>
		</div>
	</div>


	<div class="row">
		<div class="input-field col s6">
			<i class="material-icons prefix">vpn_key</i> <input
				id="passwordLogin" type="password" class="validate"
				name="motDePasse"> <label for="password" data-error=""
				data-success="">Mot de passe</label>
		</div>
	</div>


	<c:if test="${ MessageAlertLogin == true }">
		<p class="red-text text-accent-4">Veuillez vérifier votre mot de passe !</p>
	</c:if>

	<button id="submitLogin" disabled="disabled"
		class="btn waves-effect waves-light" type="submit">
		S'identifier<i class="material-icons right">send</i>
	</button>

	<a class="btn waves-effect waves-light" href="subscribe">
	S'enregistrer
	</a>
</form>
