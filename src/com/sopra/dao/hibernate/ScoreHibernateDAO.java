package com.sopra.dao.hibernate;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.IScoreDAO;
import com.sopra.model.Score;

@Repository
@Transactional
public class ScoreHibernateDAO extends DAOHibernate<Score, Integer> implements IScoreDAO {
	public ScoreHibernateDAO() {
		this.maClasse=Score.class;
		this.maClasseString="Score";
	}
	
	/*
	public Score findByUsername(String username) {
		
		try {
			Query myQuery = em.createQuery("from Utilisateur u where u.username = :username");
			
			myQuery.setParameter("username", username);
			
			return (Utilisateur)myQuery.getSingleResult();

		} catch (Exception e) {
			
			return null;
		}

		
	}
	*/
	
	
}
