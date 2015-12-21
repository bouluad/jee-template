package com.boudaa.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.boudaa.dao.GenericDao;
import com.boudaa.dao.exceptions.EntityNotFoundException;

/**
 * Classe de base pour tous les DAOs. Elle implémente les méthodes CRUD
 * génériques
 * 
 * @author boudaa
 * 
 * @param <T>
 *            le type d'objet métier manipulé
 * @param <PK>
 *            le type utilisé pour l'indentifiant d'un objet métier
 */

public class GenericDaoImpl<T, PK extends Serializable> extends
		HibernateDaoSupport implements GenericDao<T, PK> {

	/** Utilisé par tous les DAOs pour tracer les erreurs */
	protected final Logger TRACER = Logger.getLogger(getClass());

	/** Représente la classe de l'objet métier manipulé */
	private Class<T> persistentClass;

	/**
	 * Constructeur précisant la classe de l'objet métier manipulé
	 * 
	 * @param pPersistentClass
	 *            la classe de l'objet métier manipulé
	 */

	public GenericDaoImpl(final Class<T> pPersistentClass) {
		TRACER.trace("a DAO has been initialised to handle objects of type  "
				+ persistentClass);
		persistentClass = pPersistentClass;
	}

	/**
	 * {@inheritDoc}
	 */
	public T create(T pObject) {

		getHibernateTemplate().save(pObject);
		return pObject;
	}

	/**
	 * {@inheritDoc}
	 */
	public void update(T pObject) {

		getHibernateTemplate().update(pObject);

	}

	/**
	 * {@inheritDoc}
	 */
	public List<T> getAll() {
		return getHibernateTemplate().loadAll(persistentClass);
	}

	/**
	 * {@inheritDoc}
	 */
	public void delete(PK pId) {

		T lEntity = null;

		try {
			lEntity = findById(pId);
		} catch (EntityNotFoundException e) {

		}

		getHibernateTemplate().delete(lEntity);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean exists(PK id) {
		try {
			findById(id);
		} catch (EntityNotFoundException e) {
			return false;
		}

		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public T findById(PK pId) throws EntityNotFoundException {
		T lEntity = (T) getHibernateTemplate().get(this.persistentClass, pId);

		if (lEntity == null) {

			TRACER.trace("an exception EntityNotFoundException : No entity with ID  = "
					+ pId + " is found");
			throw new EntityNotFoundException("The entity with ID  = " + pId
					+ " is not found");
		}

		return lEntity;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<T> getAll(int maxResults) {
		HibernateTemplate ht = getHibernateTemplate();
		ht.setMaxResults(maxResults);

		return ht.loadAll(persistentClass);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<T> getAllDistinct() {

		Collection<T> result = new LinkedHashSet<T>(getAll());
		return new ArrayList<T>(result);

	}

	/**
	 * {@inheritDoc}
	 */
	public List<T> getAllDistinct(int maxResult) {
		Collection<T> result = new LinkedHashSet<T>(getAll(maxResult));
		return new ArrayList<T>(result);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> getEntityByColumn(String ClassName, String pColumnName,
			String pValue) {

		String HqlQuery = "from " + ClassName + " where " + pColumnName
				+ " = ?";

		List l = getHibernateTemplate().find(HqlQuery, pValue);
		if (l == null || l.size() == 0)
			throw new ObjectRetrievalFailureException(persistentClass, null);

		return l;

	}

}
