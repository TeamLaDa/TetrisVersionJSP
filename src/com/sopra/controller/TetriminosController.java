package com.sopra.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sopra.Constantes;
import com.sopra.Rendu;
import com.sopra.datamanager.DataBlocManager;
import com.sopra.datamanager.DataFigureManager;
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
			
			Tetrimino tetrimino = this.tetriminosDao.find(id);
			List<Figure> figures = this.figureDAO.findWithTetrimino(id);
			
			this.deleteFigures(figures);	
			
			try{
			//On efface le tetrimino		
			this.tetriminosDao.delete(tetrimino);

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
	public String editTetriminoPOST(
			@RequestParam(value="id_editer", required=false) String id, 
			@RequestParam(value="editFormIsValid", required=false) String editFormIsValid,
			@RequestParam(value="tetrimino_new_id", required=false) String tetrimino_new_id, 
			@RequestParam(value="tetrimino_new_nom", required=false) String tetrimino_new_nom,
			@RequestParam(value="tetrimino_new_couleur", required=false) String tetrimino_new_couleur, 
			@RequestParam(value="bcoord", required=false) String[] bcoord, 
			@RequestParam(value="rcoord", required=false) String rcoord,
			HttpSession session, Model model){
		
		//Cas où on a pas encore créé/modifié le tetrimino
		if(editFormIsValid == null){
					
			// On récupère le tetrimino dans la BDD
			Tetrimino tetrimino = this.tetriminosDao.find(id);
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
			
			DataBlocManager dataBlocManager = new DataBlocManager();
			DataFigureManager dataFigureManager = new DataFigureManager();
			
			Tetrimino tetrimino_new = this.tetriminosDao.find(id_new);
			List<Figure> figures = this.figureDAO.findWithTetrimino(id_new);
			
			//On supprime les figures du tetrimino ainsi que les blocs associés
			this.deleteFigures(figures);
			
			
			//On crée le nouveau jeu de blocs avec les données récupérées
			List<Bloc> blocs_new = dataBlocManager.extractBlocsFromCoordinates(bcoord, rcoord);
			List<Figure> figures_new = dataFigureManager.extractFigureFromBlocs(blocs_new);
			
			//On applique les changements à l'objet
			tetrimino_new.setNom(nom_new);
			tetrimino_new.setCouleur(couleur_new);
			
			tetrimino_new = this.tetriminosDao.save(tetrimino_new);
			
			
			for (Figure figure : figures_new) {
				List<Bloc> blocs = figure.getBlocs();
				figure.setTetrimino(tetrimino_new);
				figure = this.figureDAO.save(figure);
				
				for (Bloc bloc : blocs) {
					bloc.setFigure(figure);
					bloc = this.blocDAO.save(bloc);
				}
			}
			
					
			// Permet de rediriger vers la page tetriminos
			return "redirect:/tetriminos";
		}
	}
	
	
	
	
	/*
	 * Page NOUVEAU TETRIMINO
	 */
	@RequestMapping(value = "/newTetrimino", method = RequestMethod.POST)
	public String editTetriminoPOST(
			@RequestParam(value="editFormIsValid", required=false) String editFormIsValid,
			@RequestParam(value="tetrimino_new_id", required=false) String tetrimino_new_id, 
			@RequestParam(value="tetrimino_new_nom", required=false) String tetrimino_new_nom,
			@RequestParam(value="tetrimino_new_couleur", required=false) String tetrimino_new_couleur, 
			@RequestParam(value="bcoord", required=false) String[] bcoord, 
			@RequestParam(value="rcoord", required=false) String rcoord,
			HttpSession session, Model model){
		
		
		//Cas où on a pas encore créé/modifié le tetrimino
		if(editFormIsValid == null){
							
			model.addAttribute("isNew", true);
			
			//On alimente la vue JSP du formulaire d'édition avec l'instance de tetrimino à modifier
			return "newTetrimino";
		}
		
		
		//Cas où on a modifié/créé le tetrimino
		else {
			//On recupere l'id, le nom et la couleur du tetrimino a modifier
			String nom_new = tetrimino_new_nom;			
			String couleur_new = tetrimino_new_couleur;
			DataBlocManager dataBlocManager = new DataBlocManager();
			DataFigureManager dataFigureManager = new DataFigureManager();
			
			Tetrimino tetrimino_new = new Tetrimino();
			

					
			//On crée le nouveau jeu de blocs avec les données récupérées
			List<Bloc> blocs_new = dataBlocManager.extractBlocsFromCoordinates(bcoord, rcoord);
			List<Figure> figures_new = dataFigureManager.extractFigureFromBlocs(blocs_new);
			
			
			//On applique les changements à l'objet
			tetrimino_new.setNom(nom_new);
			tetrimino_new.setCouleur(couleur_new);
			
			tetrimino_new = this.tetriminosDao.save(tetrimino_new);
			
			
			for (Figure figure : figures_new) {
				List<Bloc> blocs = figure.getBlocs();
				figure.setTetrimino(tetrimino_new);
				figure = this.figureDAO.save(figure);
				
				for (Bloc bloc : blocs) {
					bloc.setFigure(figure);
					bloc = this.blocDAO.save(bloc);
				}
			}
			return "redirect:/tetriminos";
		
		}
		
	}
	
	private void deleteFigures(List<Figure> figures){
		try {			
			for (Figure figure : figures) {
				System.out.println("coucou");
				List<Bloc> blocs = this.blocDAO.findWithFigure(figure.getId());
				//On efface les blocs de la figure
				for (Bloc bloc : blocs) {
					this.blocDAO.delete(bloc);
				}
				
				//On efface les figures
				this.figureDAO.delete(figure);
			}

		  } catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
