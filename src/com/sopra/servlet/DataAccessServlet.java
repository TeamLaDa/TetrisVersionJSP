package com.sopra.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.sopra.dao.ITetriminosDao;
import com.sopra.dao.IUtilisateurDao;

public abstract class DataAccessServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	protected ITetriminosDao tetriminosDao;

	@Autowired
	protected IUtilisateurDao utilisateurDao;

	
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
