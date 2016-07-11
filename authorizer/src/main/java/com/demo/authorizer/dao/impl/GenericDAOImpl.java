package com.demo.authorizer.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.authorizer.dao.GenericDAO;

/**
 * GenericDAOImpl is an abstract class and it is implementation class for
 * GenericDAO and it contains all generic methods for storing and updating and
 * delete the objects in database
 * 
 * 
 */
@Repository
public abstract class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> entityClass;
	private Session session;

	/**
	 * Default Constructor
	 */
	GenericDAOImpl() {

	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	/**
	 * It is a method to get the session object
	 */
	protected Session getSession() {
		if (session == null || !session.isOpen())
			session = sessionFactory.getCurrentSession();
		return session;
	}

	/**
	 * It is a method to get the related entity details find by id from database
	 * and returns the relevant object
	 * 
	 * @param id
	 * @param lock
	 * @return T- It is relevant Object
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public T findById(ID id, boolean lock) {
		T entity;
		if (lock)
			entity = (T) getSession().load(entityClass, id, LockMode.UPGRADE);
		else
			entity = (T) getSession().load(entityClass, id);

		return entity;
	}

	/**
	 * It is a method to get the all related entity details from database and
	 * returns the relevant List object
	 * 
	 * @return List<T>
	 */
	public List<T> findAll() {
		return findByCriteria();
	}

	/**
	 * It is a method used to save or update entity in the database and returns
	 * the relevant entity object
	 * 
	 * @return T
	 */
	public T saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}

	/**
	 * It is a method used to save entity in the database and returns the
	 * relevant entity object
	 * 
	 * @return T
	 */
	public T save(T entity) {
		try {
			getSession().save(entity);
		}
		catch (HibernateException hibernateException) {
			throw hibernateException;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	/**
	 * It is a method used to update the related entity in the database and
	 * returns the relevant entity object
	 * 
	 * @return T
	 */
	public T update(T entity) {
		getSession().update(entity);
		return entity;
	}

	/**
	 * It is a method to delete the entity object.
	 * 
	 */
	public void delete(T entity) {
		getSession().delete(entity);
	}

	/**
	 * It is a method used to flush the session
	 * 
	 */
	public void flush() {
		getSession().flush();
	}

	/**
	 * It is a method to clear the session
	 * 
	 */
	public void clear() {
		getSession().clear();
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 * 
	 * @param criterion
	 * @return List<T>
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion... criterion) {
		Criteria crit = getSession().createCriteria(entityClass);
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return crit.list();
	}

}