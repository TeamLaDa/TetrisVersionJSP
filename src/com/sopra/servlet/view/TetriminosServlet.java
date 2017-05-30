package com.sopra.servlet.view;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.Constantes;
import com.sopra.dao.ITetriminosDao;
import com.sopra.model.Rendu;
import com.sopra.servlet.DataAccessServlet;

/**
 * Servlet implementation class TetriminosServlet
 */
@WebServlet("/tetriminos")
public class TetriminosServlet extends DataAccessServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ITetriminosDao tetriminoDAO;
       
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
		

		this.getServletContext().setAttribute(Constantes.tetriminos, this.tetriminoDAO.findAll());
		
		Rendu.listeTetriminos("Liste des Tetriminos", this.tetriminosDao.findAll(), true, this.getServletContext(), request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		doGet(request, response);
	}

}
