package com.sopra.servlet.view;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.Constantes;
import com.sopra.dao.IUtilisateurDao;
import com.sopra.model.Rendu;
import com.sopra.model.Utilisateur;
import com.sopra.servlet.DataAccessServlet;

/**
 * Servlet implementation class homeServlet
 */
@WebServlet("/login")
public class LoginServlet extends DataAccessServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Rendu.pageLogin(this.getServletContext(), request, response);
		//this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Récupère les paramètres du formulaire de connexion
		String myUserName = request.getParameter("nom_utilisateur");
		String myPassword = request.getParameter("motDePasse");
		
		
		
		// récupérer tous les utilisateurs de la base de données
		Utilisateur utilisateurAVerifier = utilisateurDao.findByUsername(myUserName);
		
		// Condition permettant de savoir si l'utilisateur est déjà enregistré
		if (utilisateurAVerifier == null) {
			response.sendRedirect("subscribe");

		} else {
			if ((myUserName.equals(utilisateurAVerifier.getUsername())) && (myPassword.equals(utilisateurAVerifier.getPassword()))) {
				request.getSession().setAttribute(Constantes.username,myUserName);
				request.getSession().setAttribute(Constantes.password,myPassword);
				
				response.sendRedirect("home");

			} else {
				response.sendRedirect("login");
			}
		}
		

		
		/*
		if ((myUserName == "") || (myPassword == "")) {
			Rendu.pageLogin(this.getServletContext(), request, response);

		} else {
			// Attribut à la session les paramètres
			request.getSession().setAttribute(Constantes.username,myUserName);
			request.getSession().setAttribute(Constantes.password,myPassword);
			
			// redirection vers la page accueil
			response.sendRedirect("home");
		}
		*/

		

	}

}
