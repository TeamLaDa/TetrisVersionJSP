package com.sopra.dao.hibernate;

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
}
