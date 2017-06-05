package com.sopra.servlet.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.Rendu;
import com.sopra.model.Tetrimino;
import com.sopra.servlet.DataAccessServlet;

/**
 * Servlet implementation class editTetriminosServlet
 */
@WebServlet("/editTetrimino")
public class EditTetriminosServlet extends DataAccessServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTetriminosServlet() {
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
			if(request.getParameter("editFormIsValid") == null){
				
				/*On teste si on est face a un cas de creation ou modification
				 * On fait le test sur l'existence ou pas de l'id du tetrimino a modifier
				 */
				if(request.getParameter("id_editer")==null){
					
					/*Cas ou on a cliqué sur ajouter:
					 * On crée une instance de Tetrimino avec des champs par défaut.
					 * L'objet est temporaire : la persistance se fait une fois le formulaire d'édition validé.
					 */
					
					Tetrimino tetrimino = new Tetrimino("Pas de nom","#000000");
					System.out.println(tetrimino.getId());
					
					
					//On alimente la vue JSP du formulaire d'édition avec l'instance de tetrimino à modifier
					Rendu.editionTetriminos("Nouveau Tetrimino", tetrimino, this.getServletContext(), request, response);
					
				}
				
				else {
					//Cas ou on a cliqué sur editer:
					//On recupere l'id du tetrimino à modifier
					String id = request.getParameter("id_editer");
					
					//On alimente la vue JSP du formulaire d'édition avec l'instance de tetrimino à modifier
					Rendu.editionTetriminos("Edition Tetrimino", this.tetriminosDao.find(id), this.getServletContext(), request, response);
				}

			}
			
			
			//Cas où on a modifié/créé le tetrimino
			if(request.getParameter("editFormIsValid") != null){
				//On recupere l'id, le nom et la couleur du tetrimino a modifier
				String id_new = request.getParameter("tetrimino_new_id");
				String nom_new = request.getParameter("tetrimino_new_nom");			
				String couleur_new = request.getParameter("tetrimino_new_couleur");
				
				Tetrimino tetrimino_new;
				
				//Cas de création : le tetrimino n'existe pas encore dans la BDD, il faut le créer
				if(id_new == null){
					tetrimino_new = new Tetrimino();
				}
				
				//Cas d'édition : le tetrimino existe, on fait appel au DAO pour le trouver dans la BDD
				else{
					tetrimino_new = this.tetriminosDao.find(id_new);
				}
				
				//On applique les changements à l'objet
				tetrimino_new.setNom(nom_new);
				tetrimino_new.setCouleur(couleur_new);
				
				//On sauvegarde le nouvel objet créé
				
				tetrimino_new = this.tetriminosDao.save(tetrimino_new);
				
				//On redirige vers la page tetriminos
				response.sendRedirect("tetriminos");
			}
		}

}
