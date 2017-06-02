package com.sopra.servlet.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.Constantes;
import com.sopra.model.Joueur;
import com.sopra.model.Partie;
import com.sopra.servlet.DataAccessServlet;

/**
 * Servlet implementation class NewJoueur
 */
@WebServlet("/newJoueur")
public class NewJoueurServlet extends DataAccessServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// On récupère la partie
		Integer partieId = Integer.parseInt(request.getParameter("partie_id_new_joueur"));
		Partie partie = partieDAO.find(partieId);
		// Récupère le username 
		String username = (String) request.getSession().getAttribute(Constantes.username);
		Joueur user = (Joueur) utilisateurDao.findByUsername(username);
		
		// Ajoute le joueur B à la partie en cours
		partie.setJoueurB(user);
		
		// Enregistre la partie dans la BDD
		partieDAO.save(partie);
		
		//On redirige vers la page affichant toutes les parties
		response.sendRedirect("parties");
	}

}
