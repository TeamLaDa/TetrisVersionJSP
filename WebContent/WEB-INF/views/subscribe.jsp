<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<div class="row">
	<form class="col s12" method="POST" action="">

		<div class="row">
			<div class="input-field col s6">
				<i class="material-icons prefix">account_circle</i>
				<input id="utilisateur" type="text" class="validate" name="nom_utilisateur">
				<label for="utilisateur" data-error="" data-success="">Nom d'Utilisateur</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s6">
				<i class="material-icons prefix">vpn_key</i>
				<input id="password" type="password" class="validate">
				<label for="password" data-error="" data-success="">Mot de passe</label>
			</div>
		</div>

		<!-- 
		<div class="row" id="VerifMdP">
			<div class="input-field col s6">
				<i class="material-icons prefix">vpn_key</i> <input
					placeholder="Vérification du Mot de Passe" id="passwordVerif"
					type="password" class="validate" name="motDePasseValidation"
					onkeyup="verigMotDePasse();">
			</div>
		</div>
		 -->
		 <div class="row">
			<div class="input-field col s6">
				<i class="material-icons prefix">vpn_key</i>
				<input id="passwordVerif" type="password" class="validate">
				<label for="passwordVerif" data-error="Le mot de passe est différent" data-success="">Taper une nouvelle fois votre mot de passe</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s6">
				<i class="material-icons prefix">perm_identity</i>
				<input id="nom" type="text" class="validate">
				<label for="passwordVerif" data-error="Le mot de passe est différent" data-success="">Nom</label>
					
			</div>
		</div>

 
	     <div class="row">
	      <div class="input-field col s6">
	      	<i class="material-icons prefix">perm_identity</i>
     	    <input id="prenom" type="text" class="validate">
     	    <label for="prenom" data-error="" data-success="">Prénom</label>
	      </div>
	    </div>


		




		<button class="btn waves-effect waves-light" type="submit"
			name="action">
			S'authentifier <i class="material-icons right">send</i>
		</button>
	</form>
</div>