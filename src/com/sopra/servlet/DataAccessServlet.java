package com.sopra.servlet;

import javax.servlet.http.HttpServlet;

import com.sopra.Constantes;
import com.sopra.dao.IDao;
import com.sopra.model.Tetrimino;
import com.sopra.model.Utilisateur;

public abstract class DataAccessServlet extends HttpServlet {
	
	protected IDao<Tetrimino> getTetriminoDAO(){
		return (IDao<Tetrimino>) this.getServletContext().getAttribute(Constantes.tetriminoDAO);
	}
	
	protected IDao<Utilisateur> getUtilisateurDAO(){
		return (IDao<Utilisateur>) this.getServletContext().getAttribute(Constantes.tetriminoDAO);
	}

}
