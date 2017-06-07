package com.sopra.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sopra.Constantes;
import com.sopra.model.Administrateur;
import com.sopra.model.Joueur;
import com.sopra.model.Spectateur;
import com.sopra.model.Utilisateur;

@Controller
@RequestMapping("/account")
public class AccountController extends DataAccessController {

	/*
	 * Page HOME
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homeGET(HttpSession session, Model model) {

		// Permet de rediriger vers la page login
		return "home";
	}

	/*
	 * Page LOGIN
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGET(HttpSession session, Model model) {

		model.addAttribute("user", new Utilisateur());

		// Permet de rediriger vers la page login
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPOST(@ModelAttribute("user") Utilisateur utilisateur, BindingResult result, Model model,
			HttpSession session) {

		// On récupère les paramètres dans le scope HttpSession
		String username = utilisateur.getUsername();
		String password = utilisateur.getPassword();

		// récupérer tous les utilisateurs de la base de données
		Utilisateur utilisateurAVerifier = utilisateurDao.findByUsername(username);

		String typeUtilisateur = "";
		// Récupère le type de l'utilisateur
		if (utilisateurAVerifier instanceof Joueur) {
			typeUtilisateur = "joueur";
		} else if (utilisateurAVerifier instanceof Spectateur) {
			typeUtilisateur = "spectateur";
		} else {
			typeUtilisateur = "administrateur";
		}

		// Condition vérifiant que l'utilisateur n'existe pas dans la BDD
		if ((utilisateurAVerifier == null)) {

			// Permet de rediriger vers la page login
			return "login";
		}

		else {
			// Condition permettant de savoir si l'utilisateur est déjà
			// enregistré
			if ((username.equals(utilisateurAVerifier.getUsername()))
					&& (password.equals(utilisateurAVerifier.getPassword()))) {
				session.setAttribute(Constantes.username, username);
				session.setAttribute(Constantes.password, username);
				session.setAttribute("typeUtilisateur", typeUtilisateur);

				// Permet de rediriger vers la page home
				return "redirect:home";

			} else if ((username.equals(utilisateurAVerifier.getUsername()))
					&& (!password.equals(utilisateurAVerifier.getPassword()))) {

				session.setAttribute("MessageAlertLogin", true);

				// Permet de rediriger vers la page login
				return "login";
			}
		}

		return null;

	}

	/*
	 * Page SUBSCRIBE
	 */
	@RequestMapping(value = "/subscribe", method = RequestMethod.GET)
	public String subscribeGET(Model model) {

		model.addAttribute("user", new Utilisateur());

		// Permet de rediriger vers la page subscribe
		return "subscribe";
	}

	@RequestMapping(value = "/subscribe", method = RequestMethod.POST)
	public String subscribePOST(@ModelAttribute("user") Utilisateur utilisateur, @RequestParam(value="joueurSpectateurButton", required=true) String typeUtilisateur, 
			BindingResult result, Model model, HttpSession session){
	

		// Récupère les paramètres du formulaire de connexion
		String username = utilisateur.getUsername();
		String password = utilisateur.getPassword();
		String nom = utilisateur.getNom();
		String prenom = utilisateur.getPrenom();
		

		// Attribut à la session les paramètres
		session.setAttribute(Constantes.username,username);
		session.setAttribute(Constantes.password,password);
		session.setAttribute(Constantes.monNom,nom);
		session.setAttribute(Constantes.monPrenom,prenom);
		
		// Crée soit un nouveau joueur ou un nouveau spectateur en fonction de "joueurSpectateurButton"
		Utilisateur new_utilisateur = null;
		if (typeUtilisateur.equals("joueur")) {
			new_utilisateur = new Joueur();
		} else if (typeUtilisateur.equals("spectateur")) {
			new_utilisateur = new Spectateur();
		} else if (typeUtilisateur.equals("administrateur")) {
			new_utilisateur = new Administrateur();
		}
		
		// Ajoute le paramètre à la session
		session.setAttribute("typeUtilisateur",typeUtilisateur);
		
		// Attribut les valeurs aux attributs de la classe Utilisateur
		new_utilisateur.setNom(nom);
		new_utilisateur.setPrenom(prenom);
		new_utilisateur.setUsername(username);
		new_utilisateur.setPassword(password);
		// Ajoute le client à la base de données
		new_utilisateur = this.utilisateurDao.save(new_utilisateur);
		
		// redirection vers la page accueil
		return "redirect:home";
	}

	
	
	
	/*
	 * Page LOGOUT
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutGET(Model model, HttpSession session) {

		// Permet de supprimer la session
		session.invalidate();

		// Permet de rediriger vers la page login
		return "redirect:login";
	}

}
