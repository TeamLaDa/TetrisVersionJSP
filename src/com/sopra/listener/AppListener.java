package com.sopra.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.sopra.Constantes;
import com.sopra.dao.ITetriminosDao;
import com.sopra.dao.application.TetriminosDaoApplication;
import com.sopra.dao.sql.TetriminosDaoSql;
import com.sopra.model.Tetrimino;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AppListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	// Affiche dans la console la création du contexte
    	System.out.println("CREATION DU CONTEXTE");
    	    	
	}

    
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
		System.out.println("DESTRUCTION DU CONTEXTE");
    }
	
}
