package com.sopra.servlet.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.Constantes;
import com.sopra.model.Administrateur;
import com.sopra.model.Joueur;
import com.sopra.model.Rendu;
import com.sopra.model.Spectateur;
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
		
		String typeUtilisateur = "";
		// Récupère le type de l'utilisateur
		if (utilisateurAVerifier instanceof Joueur) {
			typeUtilisateur = "joueur";
			System.out.println("Toto1");

		} else if (utilisateurAVerifier instanceof Spectateur) {
			typeUtilisateur = "spectateur";
			System.out.println("Toto2");

		} else {
			typeUtilisateur = "administrateur";
			System.out.println("Toto3");
		}
		
		
		// Condition vérifiant que l'utilisateur n'existe pas dans la BDD
		if ((utilisateurAVerifier == null)) {
			response.sendRedirect("login");
		} else {
			// Condition permettant de savoir si l'utilisateur est déjà enregistré
			if ((myUserName.equals(utilisateurAVerifier.getUsername())) && (myPassword.equals(utilisateurAVerifier.getPassword()))) {
					request.getSession().setAttribute(Constantes.username,myUserName);
					request.getSession().setAttribute(Constantes.password,myPassword);
					request.getSession().setAttribute("typeUtilisateur",typeUtilisateur);
					
					response.sendRedirect("home");
	
				} else if ((myUserName.equals(utilisateurAVerifier.getUsername())) && (!myPassword.equals(utilisateurAVerifier.getPassword()))){
					request.getSession().setAttribute("MessageAlertLogin", true);
					
					response.sendRedirect("login");
				}
			}
		
		}

}
