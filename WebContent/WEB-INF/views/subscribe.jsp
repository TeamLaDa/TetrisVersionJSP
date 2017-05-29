<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<div class="row">    
	<form class="col s12" method="POST" action="">
	
	    <div class="row">
	      <div class="input-field col s6">
	      	<i class="material-icons prefix">account_circle</i>
	        <input placeholder="Nom d'Utilisateur" id="utilisateur" type="text" class="validate" name="nom_utilisateur">
	      </div>
	    </div>
		
	     <div class="row">
	      <div class="input-field col s6">
	      	<i class="material-icons prefix">vpn_key</i>
     	    <input placeholder="Mot de Passe" id="password" type="password" class="validate" name="motDePasse">
	      </div>
	    </div>
	
	     <div class="row">
	      <div class="input-field col s6">
	      	<i class="material-icons prefix">perm_identity</i>
     	    <input placeholder="Nom" id="nom" type="text" class="validate" name="nom">
	      </div>
	    </div>
		
	     <div class="row">
	      <div class="input-field col s6">
	      	<i class="material-icons prefix">perm_identity</i>
     	    <input placeholder="Prénom" id="prenom" type="text" class="validate" name="prenom">
	      </div>
	    </div>
		
	    <button class="btn waves-effect waves-light" type="submit" name="action">S'identifier
    		<i class="material-icons right">send</i>
  		</button>
	</form>
</div>