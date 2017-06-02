package com.sopra.dao.hibernate;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.IUtilisateurDAO;
import com.sopra.model.Utilisateur;


@Repository
@Transactional
public class UtilisateurHibernateDAO extends DAOHibernate<Utilisateur, String> implements IUtilisateurDAO{
	
	public UtilisateurHibernateDAO() {
		this.maClasse= Utilisateur.class;
		this.maClasseString="Utilisateur";
	}

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
