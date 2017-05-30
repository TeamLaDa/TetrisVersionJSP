package com.sopra.dao.sql;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sopra.dao.IUtilisateurDao;
import com.sopra.model.Utilisateur;


@Stateless
public class UtilisateurDaoSql implements IUtilisateurDao{

	@PersistenceContext(unitName="NomPersistenceUnit")
	EntityManager em;
	

	@Override
	public List<Utilisateur> findAll() {
		return (List<Utilisateur>) em.createQuery("from Utilisateur u").getResultList();
	}

	@Override
	public boolean delete(Utilisateur utilisateur) {
		em.remove(em.merge(utilisateur));
		return true;
	}

	@Override
	public Utilisateur save(Utilisateur utilisateur) {
		return this.em.merge(utilisateur);
	}

	@Override
	public Utilisateur find(String id) {
		return em.find(Utilisateur.class, id);
	}

	@Override
	public Utilisateur findByUsername(String username) {
		try {
			Query myQuery = em.createQuery("from Utilisateur u where u.username = :username");
			
			myQuery.setParameter("username", username);
			
			return (Utilisateur)myQuery.getSingleResult();

		} catch (Exception e) {
			
			return null;
		}

		
	}

}
