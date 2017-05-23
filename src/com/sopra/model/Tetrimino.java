package com.sopra.model;

import java.util.UUID;

import com.sopra.dao.TetriminoApplicationDAO;

public class Tetrimino {
	
	private String id;
	private String nom;
	private String couleur;
	/**
	 * 
	 */

	/**
	 * @param nom
	 * @param couleur
	 */
	public Tetrimino(String nom, String couleur) {
		this.nom = nom;
		this.couleur = couleur;
		this.id = UUID.randomUUID().toString();
		
		//On ajoute le tetromino a la liste des tetrominos
		TetriminoApplicationDAO.tetriminos.put(this.nom, this);
	}
	
	/**
	 * @return Un tetrimino nommé default de couleur noire
	 */
	public Tetrimino() {
		
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the couleur
	 */
	public String getCouleur() {
		return couleur;
	}

	/**
	 * @param couleur the couleur to set
	 */
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	
}
