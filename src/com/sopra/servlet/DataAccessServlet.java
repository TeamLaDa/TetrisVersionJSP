package com.sopra.servlet;

import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;

import com.sopra.Constantes;
import com.sopra.dao.IDao;
import com.sopra.dao.ITetriminosDao;
import com.sopra.model.Tetrimino;
import com.sopra.model.Utilisateur;

public abstract class DataAccessServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	protected ITetriminosDao tetriminoDaoSql;
}
