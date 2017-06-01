package com.sopra.dao.hibernate;



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
}
