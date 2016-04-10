package daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

/**
 * Created by LocMX on 4/9/2016.
 */
@Transactional
public abstract class AbstractHibernateDAO<T extends Serializable> {

    private Class<T> clazz;

    @Autowired
    private SessionFactory sessionFactory;

    public AbstractHibernateDAO() {

    }

    public AbstractHibernateDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T findOne(final long id) {
        return (T) getSession().get(clazz, id);
    }

    public List<T> findAll() {
        return getSession().createQuery("from " + clazz.getName()).list();
    }

    public void create(T entity) {
        getSession().persist(entity);
    }

    public T update(final T entity) {
        return (T) getSession().merge(entity);
    }

    public void delete(final T entity) {
        getSession().delete(entity);
    }

    public void deleteById(final long entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }

    public Connection getConnection() {
        return ((SessionImpl)getSession()).connection();
    }

    protected final Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
