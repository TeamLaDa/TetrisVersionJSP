/**
 * 
 */
package com.sopra.model;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ajc
 *
 */
public class Rendu {

	// Affiche la page principale
	public static void pagePrincipale(String title, String contentJsp, ServletContext context, HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {

		if (title == null) {
			title = "Défaut";
		}

		req.setAttribute("pageTitle", title);
		req.setAttribute("contentJsp", contentJsp);
		RequestDispatcher dispatcher = context.getRequestDispatcher("/WEB-INF/views/structure.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	// Affichage de la page Login
	public static void pageLogin(ServletContext context, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		pagePrincipale("Authentification", "/WEB-INF/views/login.jsp", context, req, resp);
	}
	
	
	// Affichage de la page home
	public static void pageHome(ServletContext context, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		pagePrincipale("Bienvenue", "/WEB-INF/views/home.jsp", context, req, resp);
	}
	
	// Affichage de la page erreur
	
	public static void pageErreur(ServletContext context, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		pagePrincipale("Non connecté", "/WEB-INF/views/erreur.jsp", context, req, resp);
	}
	
	// Affichage de la page subscribe
	public static void pageSubscribe(ServletContext context, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		pagePrincipale("Création d'un nouvel utilisateur", "/WEB-INF/views/subscribe.jsp", context, req, resp);
	}

	
	// Affiche la page des Tetriminos
	public static void listeTetriminos(String titrePage, List<Tetrimino> tetriminos, boolean montrerActions,
			ServletContext context, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setAttribute("tetriminos", tetriminos);
		req.setAttribute("montrerActions", montrerActions);

		// Appel la fonction pagePrincipale
		pagePrincipale(titrePage, "/WEB-INF/views/tetriminos.jsp", context, req, resp);
	}
	
	
	// Affiche la page Edition des Tetriminos
	public static void editionTetriminos(String titrePage, Tetrimino tetrimino_modif, boolean montrerActions,
			ServletContext context, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setAttribute("tetrimino_old", tetrimino_modif);
		req.setAttribute("montrerActions", montrerActions);	

		// Appel la fonction pagePrincipale
		pagePrincipale(titrePage, "/WEB-INF/views/editTetrimino.jsp", context, req, resp);
	}

	


}
