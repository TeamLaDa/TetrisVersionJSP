package com.sopra.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErreurController {

	/*
	 * Page ERREUR
	 */
	@RequestMapping(value = "/erreur", method = RequestMethod.GET)
	public String loginGET(HttpSession session, Model model){
		
		// Permet de rediriger vers la page erreur
		return "erreur";
	}
}
