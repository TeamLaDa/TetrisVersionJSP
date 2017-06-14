package com.sopra;

//Interface contenant les constantes correspondant au noms des attributs de session et d'application
public interface Constantes {
	
	/*
	 * 1- Attributs de session
	 */
	
	// Le nom d'utilisateur
	public static final String username = "username";
	
	// Le mot de passe
	public static final String password = "password";
	
	// Le nom d'utilisateur
	public static final String monNom = "monNom";
	
	// Le mot de passe
	public static final String monPrenom = "monPrenom";
	

	/*
	 * 2- Attributs d'application
	 */

	// Le DAO tetrimino de scope "application"
	public static final String tetriminoDAO = "tetriminoDAO";
	
	// Le DAO utilisateur de scope "application"
	public static final String utilisateurDAO = "utilisateurDAO";
	
	// La liste des tetriminos
	public static final String tetriminos = "Tetriminos";
	
	//La taille de la grille de definition des tetriminos
	public static final int tailleMaxTetrimino = 3;
}
