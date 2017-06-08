package com.sopra.dao.hibernate;


import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.IFigureDAO;
import com.sopra.model.Figure;

@Repository
@Transactional
public class FigureHibernateDAO extends DAOHibernate<Figure, Integer> implements IFigureDAO {

	public FigureHibernateDAO() {
		this.maClasse = Figure.class;
		this.maClasseString = "Figure";
	}

	@Override
	public List<Figure> findWithTetrimino(String id_tetrimino) {
		Query myQuery = em.createQuery("from Figure f left join fetch f.tetrimino t where t.id = :id_tetrimino", this.maClasse);
		myQuery.setParameter("id_tetrimino", id_tetrimino);		
		return myQuery.getResultList();
	}
}
