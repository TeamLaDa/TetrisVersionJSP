package com.sopra.dao.sql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.ITetriminosDao;
import com.sopra.model.Tetrimino;

@Repository
@Transactional
public class TetriminosDaoSql implements ITetriminosDao{

	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public List<Tetrimino> findAll() {
		return (List<Tetrimino>) em.createQuery("from Tetrimino t", Tetrimino.class).getResultList();
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
