package daos;

import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

/**
 * Created by LocMX on 4/9/2016.
 */
@Transactional
public class AbstractJpaDAO<T extends Serializable> {

    private Class<T> clazz;

    @PersistenceContext
    private EntityManager entityManager;

    public AbstractJpaDAO() {

    }

    public AbstractJpaDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T findOne(long id) {
        return entityManager.find(clazz, id);
    }

    public List<T> findAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    public void create(T entity) {
        entityManager.persist(entity);
    }

    public T update(T entity) {
        return entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public void deleteById(long entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }

    public Connection getConnection() {
        return ((SessionImpl)getEntityManager().unwrap(Session.class)).connection();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
