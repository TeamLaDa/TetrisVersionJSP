package com.sopra.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.sopra.dao.TetriminoApplicationDAO;
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
    	
		Tetrimino tetrimino1 = new Tetrimino("A", "#FE0000");
		Tetrimino tetrimino2 = new Tetrimino("B", "#0800FE");
		Tetrimino tetrimino3 = new Tetrimino("C", "#08F900");
		
		TetriminoApplicationDAO.tetriminos.put(tetrimino1.getId(), tetrimino1);
		TetriminoApplicationDAO.tetriminos.put(tetrimino2.getId(), tetrimino2);
		TetriminoApplicationDAO.tetriminos.put(tetrimino3.getId(), tetrimino3);
	}

    
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
		System.out.println("DESTRUCTION DU CONTEXTE");
    }
	
}
