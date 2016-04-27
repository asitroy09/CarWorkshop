package com.hyundai.web.dao;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;





public abstract class CrudDaoImpl<T>  {


	private Class<T> type;
	public CrudDaoImpl() {
        // TODO Auto-generated constructor stub
 
    }
 
    public CrudDaoImpl(Class<T> type) {
        // TODO Auto-generated constructor stub
 
        this.type = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

	
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
		return getSession().createCriteria(type).list();
	}


	public T findById(Long id) {
		return (T) getSession().get(type, id);
	}


	public  List<T> getAll(final Class<T> type) {
		final Session session = getSession();
		final Criteria crit = session.createCriteria(type);
		return crit.list();
	}

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	protected Criteria createEntityCriteria(){
        return getSession().createCriteria(type);
    }
}
