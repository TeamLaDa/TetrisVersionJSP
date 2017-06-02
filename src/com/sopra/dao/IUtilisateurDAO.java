package com.sopra.dao;

import com.sopra.model.Utilisateur;

public interface IUtilisateurDAO extends IDAO<Utilisateur, String>{
	public Utilisateur findByUsername(String username);
}
