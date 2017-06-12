package com.sopra.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.controller.DataAccessController;
import com.sopra.model.Joueur;
import com.sopra.model.Partie;


@RestController
@RequestMapping("/partie")
public class PartieRestController extends DataAccessController {

	
	@RequestMapping(value="", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Partie>> getAll() {
		return new ResponseEntity<List<Partie>>(this.partieDAO.findAll(), HttpStatus.OK);
	}


	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Partie> get(@PathVariable int id) {
		Partie myPartie = this.partieDAO.find(id);
		
		return new ResponseEntity<Partie>(myPartie, HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(value="", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Partie> add(@RequestBody Partie partie) {
		partie = this.partieDAO.save(partie);
		
		return new ResponseEntity<Partie>(partie, HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Partie> join(@PathVariable int id, HttpSession session) {
		String myUtilisateurId = (String)session.getAttribute("utilisateurId");
		Partie myPartie = this.partieDAO.find(id);
		
		
		if (myUtilisateurId != null) {
			Joueur myJoueur = (Joueur)this.utilisateurDao.find(myUtilisateurId);
			
			if ((myPartie.getJoueurB() == null) && (myPartie.getJoueurA().getId() != myJoueur.getId())) {
				myPartie.setJoueurB(myJoueur);
				this.partieDAO.save(myPartie);
				return new ResponseEntity<Partie>(myPartie, HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<Partie>(HttpStatus.FORBIDDEN);
	}
	
	
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable int id) {
		this.partieDAO.delete(this.partieDAO.find(id));
	}
}
