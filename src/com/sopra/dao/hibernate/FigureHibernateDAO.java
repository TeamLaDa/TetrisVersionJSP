package com.sopra.dao.hibernate;


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
}
