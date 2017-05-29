package com.sopra.servlet.view;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.Constantes;
import com.sopra.dao.IDao;
import com.sopra.model.Rendu;
import com.sopra.model.Utilisateur;

/**
 * Servlet implementation class SubscribeServlet
 */
@WebServlet("/subscribe")
public class SubscribeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
	@EJB
	private IDao<Utilisateur> utilisateurDao;
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubscribeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Rendu.pageSubscribe(this.getServletContext(), request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Récupère les paramètres du formulaire de connexion
		String myUsername = request.getParameter("nom_utilisateur");
		String myPassword = request.getParameter("motDePasse");
		String myPasswordValidation = request.getParameter("motDePasseValidation");
		String monNom = request.getParameter("nom");
		String monPrenom = request.getParameter("prenom");
		
		
		if (myPassword.equals(myPasswordValidation)) {
			
			Rendu.pageSubscribe(this.getServletContext(), request, response);

		} else {
			// Attribut à la session les paramètres
			request.getSession().setAttribute(Constantes.username,myUsername);
			request.getSession().setAttribute(Constantes.password,myPassword);
			request.getSession().setAttribute(Constantes.monNom,monNom);
			request.getSession().setAttribute(Constantes.monPrenom,monPrenom);
			
			Utilisateur myUtilisateur = new Utilisateur();
			myUtilisateur.setNom(monNom);
			myUtilisateur.setPrenom(monPrenom);
			myUtilisateur.setUsername(myUsername);
			myUtilisateur.setPassword(myPassword);
			// Ajoute le client à la base de données
			myUtilisateur = this.utilisateurDao.save(myUtilisateur);
			
			// redirection vers la page accueil
			response.sendRedirect("home");
		}
		
		
	}

}
