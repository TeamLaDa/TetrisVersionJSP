package com.sopra.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.Constantes;
import com.sopra.dao.IDao;
import com.sopra.dao.application.TetriminosDaoApplication;
import com.sopra.model.Rendu;
import com.sopra.model.Tetrimino;

/**
 * Servlet implementation class editTetriminosServlet
 */
@WebServlet("/editTetrimino")
public class editTetriminosServlet extends DataAccessServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editTetriminosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//Cas où on a pas encore créé/modifié le tetrimino
			if(request.getParameter("tetrimino_new_id") == null){
				
				//On instancie l'id de l'objet à créer/modifier
				String id = new String();
				
				/*On teste si on est face a un cas de creation ou modification
				 * On fait le test sur l'existence ou pas de l'id du tetrimino a modifier
				 */
				if(request.getParameter("id_editer")==null){
					
					/*Cas ou on a cliqué sur ajouter:
					 * On crée un nouveau Tetrimino avec des champs vide (que l'on va devoir completer sur la page editTetrimino
					 * On le rajoute ensuite a la liste des tetriminos dejà existants
					 */
					
					Tetrimino tetrimino = new Tetrimino("Pas de nom","000");
					this.getTetriminoDAO().save(tetrimino);
					
					//On recupere l'id du tetrimino
					id = tetrimino.getId();
				}
				
				else {
					//Cas ou on a cliqué sur editer:
					//On recupere l'id du tetrimino à modifier
					id = request.getParameter("id_editer");
				}

				//On alimente la vue JSP du formulaire d'édition avec l'instance de tetrimino à modifier
				Rendu.editionTetriminos("Edition Tetrimino", this.getTetriminoDAO().find(id), true, this.getServletContext(), request, response);
			}
			
			
			//Cas où on a modifié/créé le tetrimino
			if(request.getParameter("tetrimino_new_id") != null){
				//On recupere l'id, le nom et la couleur du tetrimino a modifier
				String id_new = request.getParameter("tetrimino_new_id");
				String nom_new = request.getParameter("tetrimino_new_nom");			
				String couleur_new = request.getParameter("tetrimino_new_couleur");
				
				//On applique les changements à l'objet
				this.getTetriminoDAO().find(id_new).setNom(nom_new);
				this.getTetriminoDAO().find(id_new).setCouleur(couleur_new);
				
				//On redirige vers la page tetriminos
				response.sendRedirect("tetriminos");
			}
		}

}
