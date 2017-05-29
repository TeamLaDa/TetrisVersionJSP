package com.sopra.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.Constantes;
import com.sopra.model.Rendu;

/**
 * Servlet implementation class homeServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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
		
		
		if ((myUserName == "") && (myPassword == "")) {
			Rendu.pageLogin(this.getServletContext(), request, response);

		} else {
			// Attribut à la session les paramètres
			request.getSession().setAttribute(Constantes.username,myUserName);
			request.getSession().setAttribute(Constantes.password,myPassword);
			
			// redirection vers la page accueil
			response.sendRedirect("home");
		}
		

		

	}

}
