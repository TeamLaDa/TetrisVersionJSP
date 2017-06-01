package com.sopra.dao.hibernate;


import com.sopra.dao.IFigureDAO;
import com.sopra.model.Figure;

public class FigureHibernateDAO extends DAOHibernate<Figure, Integer> implements IFigureDAO {

	public FigureHibernateDAO() {
		this.maClasse = Figure.class;
		this.maClasseString = "Figure";
	}
}
