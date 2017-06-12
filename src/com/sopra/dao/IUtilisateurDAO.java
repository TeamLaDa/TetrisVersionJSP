package com.sopra.dao;

import com.sopra.model.Utilisateur;

import com.sopra.exception.WrongUsernameOrPasswordException;

public interface IUtilisateurDAO extends IDAO<Utilisateur, String>{
	public Utilisateur findByUsername(String username);
	
	public Utilisateur auth(String username, String password) throws WrongUsernameOrPasswordException;

}
