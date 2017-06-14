package com.sopra.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.controller.DataAccessController;
import com.sopra.model.Utilisateur;

@RestController
@CrossOrigin
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
	
	
	
	@RequestMapping(value="/auth", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Utilisateur> auth(@RequestBody Utilisateur utilisateur, HttpSession session) {
		try {
			utilisateur = this.utilisateurDao.auth(utilisateur.getUsername(), utilisateur.getPassword());
			
			if (utilisateur != null) {
				session.setAttribute("utilisateur", utilisateur);
				return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);
			}
		}
		catch (Exception ex) { }
		
		return new ResponseEntity<Utilisateur>(HttpStatus.FORBIDDEN);
	}
	
	
	
	
	@RequestMapping(value="/current", method = RequestMethod.GET)
	public ResponseEntity<Utilisateur> getCurrent(HttpSession session) {
		try {
			Utilisateur myUtilisateur = (Utilisateur)session.getAttribute("utilisateur");
			
			if (myUtilisateur != null) {
				return new ResponseEntity<Utilisateur>(myUtilisateur, HttpStatus.OK);
			}
		}
		
		catch (Exception ex) { }
		
		return new ResponseEntity<Utilisateur>(HttpStatus.FORBIDDEN);
	}

}
