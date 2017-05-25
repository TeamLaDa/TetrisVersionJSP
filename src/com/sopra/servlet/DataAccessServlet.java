package com.sopra.servlet;

import javax.servlet.http.HttpServlet;

import com.sopra.Constantes;
import com.sopra.dao.IDAO;

public abstract class DataAccessServlet extends HttpServlet {
	protected IDAO getTetriminoDAO(){
		return (IDAO) this.getServletContext().getAttribute(Constantes.tetriminoDAO);
	}

}
