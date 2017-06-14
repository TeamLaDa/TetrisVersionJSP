package com.sopra.controller;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sopra.model.Score;

@Controller
@RequestMapping(value="scores")
public class ScoresController extends DataAccessController {

	
	/*
	 * Page High-Score
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String partiesGET(HttpSession session, Model model) {

		// Récupère la liste des scores
		List<Score> listScores = scoreDAO.findAll();
		
		
		model.addAttribute("scores", listScores);
		
	
		// Permet de rediriger vers la page scores
		return "scores";
	}
}
