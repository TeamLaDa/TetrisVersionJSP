<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div class="row">
	<form class="col s12" method="POST" action="">

		<c:if test="${ MessageAlertSubscribe == true }">
			<p class="red-text text-accent-4">Ce nom d'utilisateur existe déjà, veuillez choisir un autre nom d'utilisateur !</p>
		</c:if>

		<div class="row">
			<div class="input-field col s6">
				<i class="material-icons prefix">account_circle</i>
				<input id="utilisateurSubscribe" type="text" class="validate" name="nom_utilisateur">
				<label for="utilisateurSubscribe" data-error="" data-success="">Nom d'Utilisateur</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s6">
				<i class="material-icons prefix">vpn_key</i>
				<input id="passwordSubscribe" type="password" class="validate" name="motDePasse">
				<label for="passwordSubscribe" data-error="" data-success="">Mot de passe</label>
			</div>
		</div>

		 <div class="row">
			<div class="input-field col s6">
				<i class="material-icons prefix">vpn_key</i>
				<input id="passwordSubscribeVerif" type="password" class="validate" name="motDePasseValidation">
				<label for="passwordSubscribeVerif" data-error="Le mot de passe est différent" data-success="">Taper une nouvelle fois votre mot de passe</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s6">
				<i class="material-icons prefix">perm_identity</i>
				<input id="nomSubscribe" type="text" class="validate" name="nom">
				<label for="nomSubscribe" data-error="Le mot de passe est différent" data-success="">Nom</label>
					
			</div>
		</div>

 
	     <div class="row">
	      <div class="input-field col s6">
	      	<i class="material-icons prefix">perm_identity</i>
     	    <input id="prenomSubscribe" type="text" class="validate" name="prenom">
     	    <label for="prenomSubscribe" data-error="" data-success="">Prénom</label>
	      </div>
	    </div>



		<button id=submitSubscribe disabled="disabled" class="btn waves-effect waves-light" type="submit"
			name="action">
			S'authentifier <i class="material-icons right">send</i>
		</button>
	</form>
</div>