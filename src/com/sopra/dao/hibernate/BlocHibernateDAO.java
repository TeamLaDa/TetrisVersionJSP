package com.sopra.dao.hibernate;



import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.IBlocDAO;
import com.sopra.model.Bloc;

@Repository
@Transactional
public class BlocHibernateDAO extends DAOHibernate<Bloc, Integer> implements IBlocDAO {
	public BlocHibernateDAO() {
		this.maClasse = Bloc.class;
		this.maClasseString = "Bloc";
	}

	@Override
	public List<Bloc> findWithFigure(int id_figure) {
		Query myQuery = em.createQuery("from Bloc b left join fetch b.figure f where f.id = :id_figure", this.maClasse);
		myQuery.setParameter("id_figure", id_figure);		
		return myQuery.getResultList();
	}
}
