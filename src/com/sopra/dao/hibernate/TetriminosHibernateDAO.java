package com.sopra.dao.hibernate;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.ITetriminosDAO;
import com.sopra.model.Tetrimino;

@Repository
@Transactional
public class TetriminosHibernateDAO extends DAOHibernate<Tetrimino, String> implements ITetriminosDAO{
	public TetriminosHibernateDAO() {
		this.maClasse = Tetrimino.class;
		this.maClasseString = "Tetrimino";
	}
}
