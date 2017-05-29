package com.sopra.dao.sql;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sopra.dao.ITetriminosDao;
import com.sopra.model.Tetrimino;

@Stateless
public class TetriminosDaoSql implements ITetriminosDao{

	@PersistenceContext(unitName="NomPersistenceUnit")
	EntityManager em;
	
	
	@Override
	public List<Tetrimino> findAll() {
		return (List<Tetrimino>) em.createQuery("from Tetrimino t").getResultList();
	}

	@Override
	public boolean delete(Tetrimino tetrimino) {
		em.remove(em.merge(tetrimino));
		return true;
	}

	@Override
	public Tetrimino find(String id) {
		return em.find(Tetrimino.class, id);
	}

	@Override
	public Tetrimino save(Tetrimino tetrimino) {
		return this.em.merge(tetrimino);
	}

}
