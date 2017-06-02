package com.sopra.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.IDAO;

@Transactional
public abstract class DAOHibernate<T, Key> implements IDAO<T, Key> {
	@PersistenceContext
	protected EntityManager em;

	protected Class<T> maClasse;
	protected String maClasseString;
	
	
	
	/* (non-Javadoc)
	 * @see com.sopra.dao.IDao#findAll()
	 */
	public List<T> findAll() {
		return this.em.createQuery("from "+ this.maClasseString + " " + this.maClasseString.substring(0, 1).toLowerCase(), this.maClasse).getResultList();
	}

	/* (non-Javadoc)
	 * @see com.sopra.dao.IDao#find(java.lang.Object)
	 */
	public T find(Key id) {
		return em.find(this.maClasse, id);
	}

	/* (non-Javadoc)
	 * @see com.sopra.dao.IDao#delete(java.lang.Object)
	 */
	public boolean delete(T object) {
		em.remove(em.merge(object));
		return true;
	}

	/* (non-Javadoc)
	 * @see com.sopra.dao.IDao#save(java.lang.Object)
	 */
	public T save(T object) {
		return em.merge(object);
	}
	
	
}
