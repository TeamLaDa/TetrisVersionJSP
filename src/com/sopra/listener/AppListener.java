package com.sopra.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.sopra.Constantes;
import com.sopra.dao.IDAO;
import com.sopra.dao.application.TetriminoApplicationDAO;
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
    	
    	IDAO tetriminoDAO = new TetriminoApplicationDAO();
    	
		Tetrimino tetrimino1 = new Tetrimino("A", "#FE0000");
		Tetrimino tetrimino2 = new Tetrimino("B", "#0800FE");
		Tetrimino tetrimino3 = new Tetrimino("C", "#08F900");
		
		tetriminoDAO.save(tetrimino1);
		tetriminoDAO.save(tetrimino2);
		tetriminoDAO.save(tetrimino3);
		
		arg0.getServletContext().setAttribute(Constantes.tetriminoDAO, tetriminoDAO);
	}

    
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
		System.out.println("DESTRUCTION DU CONTEXTE");
    }
	
}
