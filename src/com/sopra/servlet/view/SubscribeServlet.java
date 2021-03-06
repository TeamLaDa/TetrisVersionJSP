package com.sopra.servlet.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.Constantes;
import com.sopra.Rendu;
import com.sopra.model.Administrateur;
import com.sopra.model.Joueur;
import com.sopra.dao.hibernate.UtilisateurHibernateDAO;
import com.sopra.model.Spectateur;
import com.sopra.model.Utilisateur;
import com.sopra.servlet.DataAccessServlet;

/**
 * Servlet implementation class SubscribeServlet
 */
// @WebServlet("/subscribe")
public class SubscribeServlet extends DataAccessServlet {
	private static final long serialVersionUID = 1L;
		
	
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
			String typeUtilisateur = request.getParameter("joueurSpectateurButton");
			
			
			// Condition vérifiant que l'utilisateur n'existe pas
			if (utilisateurDao.findByUsername(myUsername) != null) {
				
				request.getSession().setAttribute("MessageAlertSubscribe", true);
	
				Rendu.pageSubscribe(this.getServletContext(), request, response);
			}
			else if (!myPassword.equals(myPasswordValidation)) {
				
				String message = "Veuillez vérifier le mot de passe !";
				
				request.getAttribute(message);
	
				Rendu.pageSubscribe(this.getServletContext(), request, response);
	
			} else {
	
				// Attribut à la session les paramètres
				request.getSession().setAttribute(Constantes.username,myUsername);
				request.getSession().setAttribute(Constantes.password,myPassword);
				request.getSession().setAttribute(Constantes.monNom,monNom);
				request.getSession().setAttribute(Constantes.monPrenom,monPrenom);
				
				// Crée soit un nouveau joueur ou un nouveau spectateur en fonction de "joueurSpectateurButton"
				Utilisateur new_utilisateur = null;
				if (typeUtilisateur.equals("joueur")) {
					new_utilisateur = new Joueur();
				} else if (typeUtilisateur.equals("spectateur")) {
					new_utilisateur = new Spectateur();
				} else if (typeUtilisateur.equals("administrateur")) {
					new_utilisateur = new Administrateur();
				}
				// Ajoute le paramètre à la session
				request.getSession().setAttribute("typeUtilisateur",typeUtilisateur);
				
				// Attribut les valeurs aux attributs de la classe Utilisateur
				new_utilisateur.setNom(monNom);
				new_utilisateur.setPrenom(monPrenom);
				new_utilisateur.setUsername(myUsername);
				new_utilisateur.setPassword(myPassword);
				// Ajoute le client à la base de données
				new_utilisateur = this.utilisateurDao.save(new_utilisateur);
				
				// redirection vers la page accueil
				response.sendRedirect("home");
			}
		
	}

}
