package com.sopra.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.Constantes;
import com.sopra.Rendu;

/**
 * Servlet Filter implementation class connexionFilter
 */
@WebFilter("/*")
public class ConnexionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ConnexionFilter() {

    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("INITIALISATION DU FILTRE");
	}
	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("DESTRUCTION DU FILTRE");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

		System.out.println("FILTRE EN COURS");
		
		// Réalise un cast pour être pris en charge
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		

		// récupère le chemin d'accès
		String myURI = request.getRequestURI();
		
		Set<String> myAcceptedURIs = new HashSet<>();
		boolean needSecurityCheck = true;
		
		myAcceptedURIs.add("/login");
		myAcceptedURIs.add("/erreur");
		myAcceptedURIs.add("/subscribe");
		myAcceptedURIs.add("/Materialize/css");
		myAcceptedURIs.add("/Materialize/js");
		myAcceptedURIs.add("/js");
		myAcceptedURIs.add("/Materialize/fonts/roboto");
		myAcceptedURIs.add("/verifusernamesubscribe");

		
		for (String forAcceptedURI : myAcceptedURIs) {
						
			if (myURI.contains(forAcceptedURI)) {
				needSecurityCheck = false;
				break;
			}
		}
			
			
		if (needSecurityCheck) {
			// On regarde l'obet associé à la clé "username" dans la session de l'utilisateur
			if (request.getSession().getAttribute(Constantes.username) == null) {
									
				// accès non autorisé !
				Rendu.pageErreur(request.getServletContext(), request, response);
				return;
			}
			
			else {
				myAcceptedURIs.add("/home");
				myAcceptedURIs.add("/tetriminos");
				myAcceptedURIs.add("/score");
				myAcceptedURIs.add("/jouer");
			}
		}
		
		//Si on est déjà connecté, lorsqu'on tente d'accéder à la page login on redirige vers la page d'accueil
		
		if(request.getSession().getAttribute(Constantes.username) != null){
			//Test si on essaie d'accéder à login
			if(request.getRequestURI().equals("/TetrisVersionJSP/login")){
				
				//Redirection vers la page d'accueil
				response.sendRedirect("/TetrisVersionJSP/home");
				return;
			}
		}

		
		chain.doFilter(request, response);
	}


}
