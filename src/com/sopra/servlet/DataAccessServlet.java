package com.sopra.servlet;

import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;

import com.sopra.dao.ITetriminosDao;
import com.sopra.dao.IUtilisateurDao;

public abstract class DataAccessServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	protected ITetriminosDao tetriminosDao;
	
	@EJB
	protected IUtilisateurDao utilisateurDao;
}
