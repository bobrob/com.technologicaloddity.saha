/**
 * (c) 2010 Technological Oddity
 *     http://technologicaloddity.com
 *
 * I, Bob Robinson, the author of this work hereby release it
 * under the Creative Commons-By Attribution 3.0 license for
 * both commercial and non-commercial purposes.
 * See the license at:
 * http://creativecommons.org/licenses/by/3.0/
 */
package com.technologicaloddity.saha.dao;

import java.util.List;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.technologicaloddity.saha.model.MappedModel;

/**
 * @author Bob Robinson, http://technologicaloddity.com
 *
 */
@Repository
@Transactional
public abstract class MappedModelDao<T extends MappedModel> {

    @Autowired
    protected SessionFactory sessionFactory;

    public abstract Class<T> getActualClass();

    @SuppressWarnings("unchecked")
    public T findById(String id) {
        Session session = getCurrentSession();
        return (T)session.get(getActualClass(), id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        Session session = getCurrentSession();
        Criteria criteria = session.createCriteria(getActualClass());
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }
    
    protected Session getCurrentSession() {
    	return sessionFactory.getCurrentSession();
    }

    public void saveOrUpdate(T entity) {
        Session session = getCurrentSession();
        session.saveOrUpdate(entity);
    }

    public void delete(T entity) {
        Session session = getCurrentSession();
        session.delete(entity);
    }
}
