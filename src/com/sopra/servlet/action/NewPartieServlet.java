package com.sopra.servlet.action;

import java.io.IOException;
import java.util.Date;

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
 * Servlet implementation class NewPartie
 */
@WebServlet("/newPartie")
public class NewPartieServlet extends DataAccessServlet {
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
		
		String username = (String) request.getSession().getAttribute(Constantes.username);
		Joueur user = (Joueur) utilisateurDao.findByUsername(username);

		Partie newPartie = new Partie();
		newPartie.setDate(new Date());
		newPartie.setJoueurA(user);
		
		partieDAO.save(newPartie);
		
		//On redirige vers la page affichant toutes les parties
		response.sendRedirect("parties");
	}

}
