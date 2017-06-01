package com.sopra.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="partie")
public class Partie {
	
	/**
	 * Tous les attributs de la classe Partie
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PAR_ID")
	private int id;
	
	@Column(name="PAR_DATE")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="PAR_JOUEUR_A")
	private Joueur joueurA;
	
	@ManyToOne
	@JoinColumn(name="PAR_JOUEUR_B")
	private Joueur joueurB;
	
	@ManyToOne
	@JoinColumn(name="PAR_JOUEUR_GAGNANT")
	private Joueur joueurGagant;
	
	@ManyToMany
	@JoinTable(
		name="partiesObservees",
		joinColumns=@JoinColumn(name="PARO_PAR_ID", referencedColumnName="PAR_ID"),
		inverseJoinColumns=@JoinColumn(name="PARO_UTI_ID", referencedColumnName="UTI_ID"))
	private List<Spectateur> spectateurs;

	
	
	
	/**
	 * Constructeur par defaut et constructeur complet
	 */
	
	/**
	 * 
	 */
	public Partie() {
		super();
	}

	/**
	 * @param id
	 * @param date
	 * @param joueurA
	 * @param joueurB
	 * @param joueurGagant
	 * @param spectateurs
	 */
	public Partie(Date date, Joueur joueurA, Joueur joueurB, Joueur joueurGagant,
			List<Spectateur> spectateurs) {
		this.date = date;
		this.joueurA = joueurA;
		this.joueurB = joueurB;
		this.joueurGagant = joueurGagant;
		this.spectateurs = spectateurs;
	}

	
	
	
	
	/**
	 * Getters et Setters de la classe
	 */
	
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
	 * @return the joueurA
	 */
	public Joueur getJoueurA() {
		return joueurA;
	}

	/**
	 * @param joueurA the joueurA to set
	 */
	public void setJoueurA(Joueur joueurA) {
		this.joueurA = joueurA;
	}

	/**
	 * @return the joueurB
	 */
	public Joueur getJoueurB() {
		return joueurB;
	}

	/**
	 * @param joueurB the joueurB to set
	 */
	public void setJoueurB(Joueur joueurB) {
		this.joueurB = joueurB;
	}

	/**
	 * @return the joueurGagant
	 */
	public Joueur getJoueurGagant() {
		return joueurGagant;
	}

	/**
	 * @param joueurGagant the joueurGagant to set
	 */
	public void setJoueurGagant(Joueur joueurGagant) {
		this.joueurGagant = joueurGagant;
	}

	/**
	 * @return the spectateurs
	 */
	public List<Spectateur> getSpectateurs() {
		return spectateurs;
	}

	/**
	 * @param spectateurs the spectateurs to set
	 */
	public void setSpectateurs(List<Spectateur> spectateurs) {
		this.spectateurs = spectateurs;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	
	
	
	

}
