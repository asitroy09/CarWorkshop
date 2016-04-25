package com.hyundai.web.dao;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyundai.web.hibernateconfig.HibernateXmlConfig;



public class CrudDaoImpl<T> implements CrudDao<T> {
	@Autowired HibernateXmlConfig hxmlConfig;

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
        return (T) getSession().get(type, id);
    }
    
    
    public  List<T> getAll(final Class<T> type) {
        final Session session = hxmlConfig.getSessionFactory().getCurrentSession();
        final Criteria crit = session.createCriteria(type);
    return crit.list();
      }
    
    protected Session getSession() {
        return hxmlConfig.getSessionFactory().getCurrentSession();
    }

}
