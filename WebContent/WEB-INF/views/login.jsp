<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
  
   <br>
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
		
	    <button class="btn waves-effect waves-light" type="submit">S'identifier
    		<i class="material-icons right">send</i>
  		</button>	

		<button class="btn waves-effect waves-light" formaction="subscribe" formmethod="POST">S'enregistrer
    		<i class="material-icons right">send</i>
  		</button>
	</form>
