package com.sopra.restcontroller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.controller.DataAccessController;
import com.sopra.model.Utilisateur;

@RestController
@RequestMapping("/account")
public class AccountRestcontroller extends DataAccessController{
	
	@RequestMapping(value = "/userVerif", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Boolean> userVerifGET(@RequestParam(value="nom_user", required=true) String myUsernameUppercase, Model model) {

		// Je récupère le nom d'utilisateur renseigné
		String myUsername = myUsernameUppercase.toLowerCase();
		
		System.out.println("Username : " + myUsername);

		List<Utilisateur> listUtilisateurs = utilisateurDao.findAll();

		// Boucle permettant de vérifier si myUsername appartient à un des noms d'utilisateur
		for (Utilisateur utilisateur : listUtilisateurs) {
			String username = utilisateur.getUsername().toLowerCase();
			
			// Condition permettant de vérifier si les usernames sont identiques
			if (username.equals(myUsername)) {
				
				return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<Boolean>(false, HttpStatus.OK);
	}

}
