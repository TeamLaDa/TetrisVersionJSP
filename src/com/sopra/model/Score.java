package com.sopra.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="score")
public class Score {
	
	/**
	 * Tous les attributs de la classe Partie
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SCO_ID")
	private int id;
	
	@Column(name="SCO_DATE")
	private Date date;
	
	@Column(name="SCO_POINTS")
	private int points;
	
	@Column(name="SCO_LIGNES")
	private int lignes;
	
	@Column(name="SCO_NIVEAU")
	private int niveau;
	
	@ManyToOne
	@JoinColumn(name="SCO_JOUEUR")
	private Joueur joueur;
	
	@ManyToOne
	@JoinColumn(name="SCO_PARTIE")
	Partie partie;

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * @return the lignes
	 */
	public int getLignes() {
		return lignes;
	}

	/**
	 * @param lignes the lignes to set
	 */
	public void setLignes(int lignes) {
		this.lignes = lignes;
	}

	/**
	 * @return the niveau
	 */
	public int getNiveau() {
		return niveau;
	}

	/**
	 * @param niveau the niveau to set
	 */
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	/**
	 * @return the joueur
	 */
	public Joueur getJoueur() {
		return joueur;
	}

	/**
	 * @param joueur the joueur to set
	 */
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	/**
	 * @return the partie
	 */
	public Partie getPartie() {
		return partie;
	}

	/**
	 * @param partie the partie to set
	 */
	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
}
