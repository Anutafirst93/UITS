/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uits.school.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import uits.school.domain.BaseDao;

/**
 *
 * @author by ANNA ZHURAVLYOVA
 */
@Component
public abstract class AbstractService<T, I extends Serializable> implements BaseService<T, I> {
    
    @Autowired
    private BaseDao dao;
    

    @Transactional
    @Override
    public T byId(I id) {
        return (T) dao.byId(id);
    }
    
    @Transactional
    @Override
    public Serializable save(T object) {
        return dao.save(object);
    }

    @Transactional
    @Override
    public void update(T object) {
        dao.update(object);
    }

    @Transactional
    @Override
    public void delete(T object) {
        dao.remove (object);
    }

    @Override
    public List<T> list() {
        
        return (List<T>) dao.list();
    }
}