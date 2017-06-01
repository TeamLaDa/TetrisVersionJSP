package com.sopra.dao.hibernate;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.IPartieDAO;
import com.sopra.model.Partie;

@Repository
@Transactional
public class PartieHibernateDAO extends DAOHibernate<Partie, Integer> implements IPartieDAO {

	public PartieHibernateDAO() {
		this.maClasse = Partie.class;
		this.maClasseString = "Partie";
	}
}
