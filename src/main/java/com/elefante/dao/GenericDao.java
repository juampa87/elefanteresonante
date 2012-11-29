package com.elefante.dao;

import java.io.Serializable;
import java.util.List;

import com.elefante.search.SearchParams;

public interface GenericDao<E, PK extends Serializable> {
	PK save(E newInstance);

	void update(E transientObject);

	void saveOrUpdate(E transientObject);

	void delete(E persistentObject);

	E findById(PK id);

	List<E> findAll();

	List<E> findAllByProperty(String propertyName, Object value);

	List<E> findWithParams(SearchParams searchParams);
}