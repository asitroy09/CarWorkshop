package com.hyundai.web.dao;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CrudDaoImpl<T>  {

	private Class<T> type;
	private Class<T> getType() {
		if (type == null) {
			Type t = getClass().getGenericSuperclass();
			ParameterizedType pt = (ParameterizedType) t;
			type = (Class) pt.getActualTypeArguments()[0];
		}
		return type;
	} 

	public void delete(T objeto) {
		getSession().delete(objeto);
	}


	public void save(T objeto) {
		getSession().saveOrUpdate(objeto);
	}

	public List<T> findAll() {
		return getSession().createCriteria(getType()).list();
	}


	public T findById(Long id) {
		return (T) getSession().get(getType(), id);
	}

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	protected Criteria createEntityCriteria(){
        return getSession().createCriteria(getType());
    }
}
