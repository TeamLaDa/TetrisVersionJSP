package com.sopra.model;

public class Utilisateur {
	
	/*
	 * Tous les attributs de la classe
	 */
	private int id;
	private String nom;
	private String prenom;
	private String username;
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
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param username
	 * @param password
	 */
	public Utilisateur(int id, String nom, String prenom, String username, String password) {
		this.id = id;
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
	public int getId() {
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
