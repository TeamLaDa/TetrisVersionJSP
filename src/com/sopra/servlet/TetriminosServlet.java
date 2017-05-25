package com.sopra.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.Constantes;
import com.sopra.dao.IDAO;
import com.sopra.dao.application.TetriminoApplicationDAO;
import com.sopra.model.Rendu;
import com.sopra.model.Tetrimino;

/**
 * Servlet implementation class TetriminosServlet
 */
@WebServlet("/tetriminos")
public class TetriminosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TetriminosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//On récupère le dao
		IDAO tetriminoDAO= (IDAO) this.getServletContext().getAttribute(Constantes.tetriminoDAO);
		
		this.getServletContext().setAttribute(Constantes.tetriminos, tetriminoDAO.findAll());
		
		Rendu.listeTetriminos("Liste des Tetriminos", tetriminoDAO.findAll(), true, this.getServletContext(), request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		doGet(request, response);
	}

}
