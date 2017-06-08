package com.sopra.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sopra.Constantes;
import com.sopra.model.Joueur;
import com.sopra.model.Partie;

@Controller
@RequestMapping("/parties")
public class PartiesController extends DataAccessController {
	
	
	/*
	 * Page LISTE DES PARTIES
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String partiesGET(HttpSession session, Model model) {

		List<Partie> listeParties = partieDAO.findAll();
		
		// Récupère le username de la session en cours
		String username = (String) session.getAttribute(Constantes.username);
		Joueur user = (Joueur) utilisateurDao.findByUsername(username);
		
		session.setAttribute("listeParties", listeParties);
		session.setAttribute("userConnecte", user);
		
		// Permet de rediriger vers la page login
		return "parties";
	}
	
	
	/*
	 * Page AJOUTER UNE PARTIE
	 */
	@RequestMapping(value = "/newPartie", method = RequestMethod.POST)
	public String newPartiePOST(HttpSession session, Model model) {

		String username = (String) session.getAttribute(Constantes.username);
		Joueur user = (Joueur) utilisateurDao.findByUsername(username);

		Partie newPartie = new Partie();
		newPartie.setDate(new Date());
		newPartie.setJoueurA(user);
		
		partieDAO.save(newPartie);
		
		// Permet de rediriger vers la page login
		return "redirect:/parties";
	}
	
	


}
