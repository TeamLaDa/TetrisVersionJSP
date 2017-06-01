package com.sopra.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.sopra.dao.IBlocDAO;
import com.sopra.dao.IDAO;
import com.sopra.dao.IFigureDAO;
import com.sopra.dao.IPartieDAO;
import com.sopra.dao.IScoreDAO;
import com.sopra.dao.ITetriminosDAO;
import com.sopra.dao.IUtilisateurDAO;
import com.sopra.model.Tetrimino;

public abstract class DataAccessServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	protected ITetriminosDAO tetriminosDao;
	
	@Autowired
	protected IBlocDAO blocDAO;
	
	@Autowired 
	IFigureDAO figureDAO;

	@Autowired
	protected IUtilisateurDAO utilisateurDao;
	
	@Autowired 
	IScoreDAO scoreDAO;
	
	@Autowired
	IPartieDAO partieDAO;
	

	
	// surcharge de la méthode init, permettant de faire un pont entre Spring et
	// le conteneur de Servlet
	public void init(ServletConfig config) {

		try {
			super.init(config);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

}
