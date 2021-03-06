package com.sopra.servlet.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.servlet.DataAccessServlet;

/**
 * Servlet implementation class deleteTetriminosServlet
 */
//@WebServlet("/deleteTetrimino")
public class DeleteTetriminosServlet extends DataAccessServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTetriminosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/views/tetriminos.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			//On recupere l'id du tetrimino a supprimer
			String id = request.getParameter("id_supprimer");
			
			//On envoie l'id a la méthode suppression du DAO
			this.tetriminosDao.delete(this.tetriminosDao.find(id));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
		//redirection vers la page teriminos
		response.sendRedirect("tetriminos");
	}

}
