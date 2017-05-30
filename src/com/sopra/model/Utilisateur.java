package com.sopra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="utilisateur")
public class Utilisateur {
	
	/*
	 * Tous les attributs de la classe
	 */
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@Column(name="UTI_ID")
	private String id;
	
	@Column(name="UTI_NOM")
	@NotNull
	private String nom;
	
	@Column(name="UTI_PRENOM")
	@NotNull
	private String prenom;
	
	@Column(name="UTI_USERNAME")
	@NotNull
	private String username;
	
	@Column(name="UTI_PASSWORD")
	@NotNull
	private String password;

	
	
	
	
	
	/*
	 * Constructeur par défaut et complet
	 */
	
	/**
	 * 
	 */
	public Utilisateur() {
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param username
	 * @param password
	 */
	public Utilisateur(String nom, String prenom, String username, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
	}

	
	
	
	
	/*
	 * Getters and setters
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
