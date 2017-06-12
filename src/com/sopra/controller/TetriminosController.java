package com.sopra.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sopra.Constantes;
import com.sopra.Rendu;
import com.sopra.model.Bloc;
import com.sopra.model.Figure;
import com.sopra.model.Tetrimino;

@Controller
@RequestMapping("/tetriminos")
public class TetriminosController extends DataAccessController {

	/*
	 * Page LISTE DES TETRIMINOS
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String tetriminoGET(HttpSession session, Model model) {

		// Affecte tous les tetriminos
		session.setAttribute(Constantes.tetriminos, this.tetriminosDao.findAll());
		session.setAttribute("tetri", this.tetriminosDao.findAll());

		// récupère le type de l'utilisateur (joueur, spectateur ou
		// administrateur)
		String typeUtilisateurAdmin = (String) session.getAttribute("typeUtilisateur");

		// Condition pour savoir si l'utilisateur est administrateur ou pas,
		// permettant de savoir s'il peut modifier les tetriminos
		if (typeUtilisateurAdmin.equals("administrateur")) {
			session.setAttribute("montrerActions", true);
		} else {
			session.setAttribute("montrerActions", false);
		}

		// Permet de rediriger vers la page tetriminos
		return "tetriminos";
	}

	/*
	 * Page DELETE UN TETRIMINO
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteTetriminoPOST(@RequestParam(value = "id_supprimer") String id, HttpSession session,
			Model model) {

		try {

			// On envoie l'id a la méthode suppression du DAO
			this.tetriminosDao.delete(this.tetriminosDao.find(id));

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Permet de rediriger vers la page tetriminos
		return "redirect:/tetriminos";
	}

	/*
	 * Page EDITION D UN TETRIMINO
	 */
	@RequestMapping(value = "/editTetrimino", method = RequestMethod.POST)
	public String editTetriminoPOST(@RequestParam(value="id_editer", required=false) String id, @RequestParam(value="editFormIsValid", required=false) String editFormIsValid,
			@RequestParam(value="tetrimino_new_id", required=false) String tetrimino_new_id, @RequestParam(value="tetrimino_new_nom", required=false) String tetrimino_new_nom,
			@RequestParam(value="tetrimino_new_couleur", required=false) String tetrimino_new_couleur, HttpSession session, Model model){
		
		//Cas où on a pas encore créé/modifié le tetrimino
		if(editFormIsValid == null){
			
			// Cas ou on a cliqué sur editer:				
			
			// On récupère le tetrimino dans la BDD
			Tetrimino tetrimino = this.tetriminosDao.find(id);
			System.out.println(id);
			
			// On récupère la liste des figures correspondantes la BDD
			List<Figure> figures = this.figureDAO.findWithTetrimino(id);
			
			// On récupère les blocs de la premiere figure (principale) dans la BDD
			List<Bloc> blocs = this.blocDAO.findWithFigure(figures.get(0).getId());
			
			// On intègre les éléments récupéres à l'instance de tetrimino
			figures.get(0).setBlocs(blocs);
			tetrimino.setFigures(figures);
			
			//
			model.addAttribute("tetrimino_old",tetrimino);
			model.addAttribute("isNew", false);
								
			//On alimente la vue JSP du formulaire d'édition avec l'instance de tetrimino à modifier
			return "editTetrimino";
		}
		
		
		//Cas où on a modifié/créé le tetrimino
		else {
			//On recupere l'id, le nom et la couleur du tetrimino a modifier
			String id_new = tetrimino_new_id;
			String nom_new = tetrimino_new_nom;			
			String couleur_new = tetrimino_new_couleur;
			
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
		
			// Permet de rediriger vers la page tetriminos
			return "redirect:/tetriminos";
		}
	}
	
	
	
	
	/*
	 * Page NOUVEAU TETRIMINO
	 */
	@RequestMapping(value = "/newTetrimino", method = RequestMethod.POST)
	public String editTetriminoPOST(@RequestParam(value="editFormIsValid", required=false) String editFormIsValid,
			@RequestParam(value="tetrimino_new_id", required=false) String tetrimino_new_id, @RequestParam(value="tetrimino_new_nom", required=false) String tetrimino_new_nom,
			@RequestParam(value="tetrimino_new_couleur", required=false) String tetrimino_new_couleur, HttpSession session, Model model){
		
		
		//Cas où on a pas encore créé/modifié le tetrimino
		if(editFormIsValid == null){
							
			model.addAttribute("isNew", true);
			
			//On alimente la vue JSP du formulaire d'édition avec l'instance de tetrimino à modifier
			return "newTetrimino";
		}
		
		
		//Cas où on a modifié/créé le tetrimino
		else {
			//On recupere l'id, le nom et la couleur du tetrimino a modifier
			String id_new = tetrimino_new_id;
			String nom_new = tetrimino_new_nom;			
			String couleur_new = tetrimino_new_couleur;
			
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
		
			// Permet de rediriger vers la page tetriminos
			return "redirect:/tetriminos";
		}
		
	}
	
}
