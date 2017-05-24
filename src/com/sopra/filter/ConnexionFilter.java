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
		
		
		for (String forAcceptedURI : myAcceptedURIs) {
						
			if (myURI.contains(forAcceptedURI)) {
				needSecurityCheck = false;
				break;
			}
		}
			
			
		if (needSecurityCheck) {
			// On regarde l'obet associé à la clé "username" dans la session de l'utilisateur
			if (request.getSession().getAttribute("username") == null) {
									
				// accès non autorisé !
				response.sendRedirect("erreur");
				return;
			}
			
			else {
				myAcceptedURIs.add("/accueil");
				myAcceptedURIs.add("/tetriminos");
			}
		}

		
		chain.doFilter(request, response);
	}


}
