package com.hyundai.web.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Component
@Transactional(propagation = Propagation.SUPPORTS)
public interface CrudDao<T> {
    public void delete(T objeto);
    public void save(T objeto);
    public List<T> findAll();
    public T findById(Long id);
    public  List<T>  getAll(final Class<T> type);
}
