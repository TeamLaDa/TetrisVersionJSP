package com.sopra.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tetrimino")
public class Tetrimino {
	
	
	/**
	 * Tous les attributs de la classe Tetrimino
	 */
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@Column(name="TET_ID")
	private String id;
	
	@Column(name="TET_NOM")
	@NotNull
	private String nom;
	
	@Column(name="TET_COULEUR")
	@NotNull
	private String couleur;


	
	



	/**
	 * Constructeur par défaut et complet
	 */
	
	/**
	 * 
	 */
	public Tetrimino() {
	}
	
	/**
	 * @param id
	 * @param nom
	 * @param couleur
	 */
	public Tetrimino(String nom, String couleur) {
		this.nom = nom;
		this.couleur = couleur;
	}







	/**
	 * Getters and Setters
	 */

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
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
