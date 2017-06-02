<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div class="row">
	<form class="col s12" method="POST" action="">

		<c:if test="${ MessageAlertSubscribe == true }">
			<p class="red-text text-accent-4">Ce nom d'utilisateur existe
				déjà, veuillez en choisir un autre !</p>
		</c:if>

		<!-- Nom d'utilisateur -->
		<div class="row">
			<div class="input-field col s6">
				<i class="material-icons prefix">account_circle</i> <input
					id="utilisateurSubscribe" type="text" class="validate"
					name="nom_utilisateur"> <label for="utilisateurSubscribe"
					data-error="" data-success="">Nom d'Utilisateur</label>
			</div>
		</div>

		<!-- Mot de Passe -->
		<div class="row">
			<div class="input-field col s6">
				<i class="material-icons prefix">vpn_key</i> <input
					id="passwordSubscribe" type="password" class="validate"
					name="motDePasse"> <label for="passwordSubscribe"
					data-error="" data-success="">Mot de passe</label>
			</div>
		</div>

		<!-- Confirmation du mot de passe -->
		<div class="row">
			<div class="input-field col s6">
				<i class="material-icons prefix">vpn_key</i> <input
					id="passwordSubscribeVerif" type="password" class="validate"
					name="motDePasseValidation"> <label
					for="passwordSubscribeVerif"
					data-error="Le mot de passe est différent" data-success="">Taper
					une nouvelle fois votre mot de passe</label>
			</div>
		</div>

		<!-- Nom de l'utilisateur -->
		<div class="row">
			<div class="input-field col s6">
				<i class="material-icons prefix">perm_identity</i> <input
					id="nomSubscribe" type="text" class="validate" name="nom">
				<label for="nomSubscribe" data-error="Le mot de passe est différent"
					data-success="">Nom</label>

			</div>
		</div>

		<!-- Prénom de l'utilisateur -->
		<div class="row">
			<div class="input-field col s6">
				<i class="material-icons prefix">perm_identity</i> <input
					id="prenomSubscribe" type="text" class="validate" name="prenom">
				<label for="prenomSubscribe" data-error="" data-success="">Prénom</label>
			</div>
		</div>


		<!-- Switch entre le choix d'être Joueur ou Spectateur -->
		<div>Voulez-vous être Joueur ou Spectateur ?</div>
		<p>
			<input name="joueurSpectateurButton" type="radio" id="joueurButton"
				value="joueur" /> <label for="joueurButton">Joueur</label>
		</p>
		<p>
			<input name="joueurSpectateurButton" type="radio"
				id="spectateurButton" value="spectateur" /> <label
				for="spectateurButton">Spectateur</label>
		</p>
		
		<!-- Bouton à décommenter si volonté de créer un administrateur -->
		<!-- 
		<p>
			<input name="joueurSpectateurButton" type="radio"
				id="administrateurButton" value="administrateur" /> <label
				for="administrateurButton">Administrateur</label>
		</p>
 		-->

		<!-- Bouton permettant l'envoie du formulaire -->
		<button id=submitSubscribe disabled="disabled"
			class="btn waves-effect waves-light" type="submit" name="action">
			S'enregistrer<i class="material-icons right">send</i>
		</button>

		<a class="btn waves-effect waves-light" href="login">
		S'identifier<i class="material-icons right">replay</i>
		</a>
	</form>
</div>