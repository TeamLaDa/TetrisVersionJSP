package com.sopra.dao.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.IUtilisateurDAO;
import com.sopra.model.Utilisateur;

import com.sopra.exception.WrongUsernameOrPasswordException;


@Repository
@Transactional
public class UtilisateurHibernateDAO extends DAOHibernate<Utilisateur, String> implements IUtilisateurDAO{
	
	@PersistenceContext
	private EntityManager entityManager;
	
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
	
	
	
	@Override
	public Utilisateur auth(String username, String password) throws WrongUsernameOrPasswordException {
		try {
			return this.entityManager.createQuery("from Utilisateur u where u.username = :username AND u.password = :password", Utilisateur.class)
					.setParameter("username", username)
					.setParameter("password", password)
					.getSingleResult();
		}
		
		catch (Exception e) {
			throw new WrongUsernameOrPasswordException();
		}
	}
}
