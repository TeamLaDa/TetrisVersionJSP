package com.sopra.servlet.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.model.Partie;
import com.sopra.model.Rendu;
import com.sopra.servlet.DataAccessServlet;

/**
 * Servlet implementation class PartiesServlet
 */
@WebServlet("/parties")
public class PartiesServlet extends DataAccessServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Partie> listeParties = partieDAO.findAll();
		
		request.setAttribute("listeParties", listeParties);
		
		Rendu.pageParties(this.getServletContext(), request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
