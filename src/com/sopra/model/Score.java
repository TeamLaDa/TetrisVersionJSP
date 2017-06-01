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
	int id;
	
	@Column(name="SCO_DATE")
	Date date;
	
	@Column(name="SCO_POINTS")
	int points;
	
	@Column(name="SCO_LIGNES")
	int lignes;
	
	@Column(name="SCO_NIVEAU")
	int niveau;
	
	@ManyToOne
	@JoinColumn(name="SCO_JOUEUR")
	Joueur joueur;
	
	@ManyToOne
	@JoinColumn(name="SCO_PARTIE")
	Partie partie;

}
