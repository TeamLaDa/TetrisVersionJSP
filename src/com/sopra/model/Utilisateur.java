package com.sopra.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="utilisateur", uniqueConstraints = { @UniqueConstraint(columnNames = "UTI_USERNAME") })
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_UTILISATEUR")
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
	@NotEmpty
	private String nom;
	
	@Column(name="UTI_PRENOM")
	@NotEmpty
	private String prenom;
	
	@Column(name="UTI_USERNAME")
	@NotEmpty
	private String username;
	
	@Column(name="UTI_PASSWORD")
	@NotEmpty
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
