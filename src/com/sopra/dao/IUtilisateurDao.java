package com.sopra.dao;

import java.util.List;

import com.sopra.model.Utilisateur;

public interface IUtilisateurDao extends IDao<Utilisateur>{

	public List<Utilisateur> findAll();
	public Utilisateur find(String id);
	public boolean delete(Utilisateur utilisateur);
	public Utilisateur save(Utilisateur utilisateur);
	Utilisateur findByUsername(String username);
}
