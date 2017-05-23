package com.sopra.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

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
		
		
		List<Tetrimino> listeDesTetriminos= new ArrayList<Tetrimino>();
		
		Tetrimino tetrimino1 = new Tetrimino("A", "#FE0000");
		Tetrimino tetrimino2 = new Tetrimino("B", "#0800FE");
		Tetrimino tetrimino3 = new Tetrimino("C", "#08F900");
		
		listeDesTetriminos.add(tetrimino1);
		listeDesTetriminos.add(tetrimino2);
		listeDesTetriminos.add(tetrimino3);
		
		
		arg0.getServletContext().setAttribute("Tetriminos", listeDesTetriminos);
	}

    
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
		System.out.println("DESTRUCTION DU CONTEXTE");
    }
	
}
