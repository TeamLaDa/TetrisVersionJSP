package com.sopra.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.sopra.dao.IBlocDAO;
import com.sopra.dao.IFigureDAO;
import com.sopra.dao.IPartieDAO;
import com.sopra.dao.IScoreDAO;
import com.sopra.dao.ITetriminosDAO;
import com.sopra.dao.IUtilisateurDAO;

public class DataAccessController {
	
	/**
	 * Appel tous les DAO de manière à les avoir dans les classes filles
	 */

	@Autowired
	protected ITetriminosDAO tetriminosDao;
	
	@Autowired
	protected IBlocDAO blocDAO;
	
	@Autowired 
	protected IFigureDAO figureDAO;

	@Autowired
	protected IUtilisateurDAO utilisateurDao;
	
	@Autowired 
	protected IScoreDAO scoreDAO;
	
	@Autowired
	protected IPartieDAO partieDAO;

}
