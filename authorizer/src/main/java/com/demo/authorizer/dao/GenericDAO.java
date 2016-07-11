package com.demo.authorizer.dao;

import java.io.Serializable;
import java.util.List;

/**
 * GenericDAO is an interface and it is extends Serializable interface.
 * It is a generic interface for dao  for performing the CURD operations. 
 * 
 * @author LnT Infotech
 * @version 0.1
 * @see GenericDAO
 * 
 */
public interface GenericDAO<T, ID extends Serializable> {

	T findById(ID id, boolean lock);

	List<T> findAll();

	T save(T entity);

	T saveOrUpdate(T entity);

	T update(T entity);

	void delete(T entity);
}
