package com.sopra.dao.hibernate;



import com.sopra.dao.IBlocDAO;
import com.sopra.model.Bloc;

public class BlocHibernateDAO extends DAOHibernate<Bloc, Integer> implements IBlocDAO {
	public BlocHibernateDAO() {
		this.maClasse = Bloc.class;
		this.maClasseString = "Bloc";
	}
}
