package com.sopra.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sopra.Constantes;

@Controller
@RequestMapping("/tetriminos")
public class TetriminosController extends DataAccessController {
	
	
	/*
	 * Page Liste des TETRIMINOS
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String homeGET(HttpSession session, Model model){
		
		// Affecte tous les tetriminos
		session.setAttribute(Constantes.tetriminos, this.tetriminosDao.findAll());
		session.setAttribute("tetri", this.tetriminosDao.findAll());
		
		// récupère le type de l'utilisateur (joueur, spectateur ou administrateur)
		String typeUtilisateurAdmin = (String) session.getAttribute("typeUtilisateur");
		
		// Condition pour savoir si l'utilisateur est administrateur ou pas, permettant de savoir s'il peut modifier les tetriminos
		if (typeUtilisateurAdmin.equals("administrateur")) {
			session.setAttribute("montrerActions", true);
		} else {
			session.setAttribute("montrerActions", false);
		}
		
		
		// Permet de rediriger vers la page tetriminos
		return "tetriminos";
	}
	
	
	
	
}
