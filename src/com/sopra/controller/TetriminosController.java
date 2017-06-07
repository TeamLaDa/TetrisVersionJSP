package com.sopra.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sopra.Constantes;

@Controller
@RequestMapping("/tetriminos")
public class TetriminosController extends DataAccessController {
	
	
	/*
	 * Page LISTE DES TETRIMINOS
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String tetriminoGET(HttpSession session, Model model){
		
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
	
	
	
	
	/*
	 * Page DELETE UN TETRIMINO
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteTetriminoPOST(@RequestParam(value="id_supprimer") String id, HttpSession session, Model model){
		
		try {
			
			//On envoie l'id a la méthode suppression du DAO
			this.tetriminosDao.delete(this.tetriminosDao.find(id));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// Permet de rediriger vers la page tetriminos
		return "redirect:/tetriminos";
	}
	
	
	
	
	/*
	 * Page EDITION D UN TETRIMINO
	 */
	@RequestMapping(value = "/editTetrimino", method = RequestMethod.POST)
	public String editTetriminoPOST(@RequestParam(value="id_supprimer") String id, HttpSession session, Model model){
		
		// A FAIRE
		
		// Permet de rediriger vers la page tetriminos
		return "redirect:/tetriminos";
	}
	
	
	
	
}
