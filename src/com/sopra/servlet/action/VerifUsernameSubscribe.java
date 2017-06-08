package com.sopra.servlet.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.model.Utilisateur;
import com.sopra.servlet.DataAccessServlet;

/**
 * Servlet implementation class VerifUsernameSubscribe
 */
//@WebServlet("/verifusernamesubscribe")
public class VerifUsernameSubscribe extends DataAccessServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Je récupère le nom d'utilisateur renseigné
		String myUsername = request.getParameter("nom_user").toLowerCase();

		List<Utilisateur> listUtilisateurs = utilisateurDao.findAll();

		for (Utilisateur utilisateur : listUtilisateurs) {
			String username = utilisateur.getUsername().toLowerCase();
			
			if (username.equals(myUsername)) {
				
				response.getWriter().print(1);
				return;
				
			}
		}
		
		response.getWriter().print(0);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
