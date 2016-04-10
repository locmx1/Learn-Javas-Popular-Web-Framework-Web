package daos;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

/**
 * Created by LocMX on 4/9/2016.
 */
public interface IGenericDAO <T extends Serializable> {

    /**
     * Find the specified entity by its id
     * @param id
     * @return the found entity if any
     */
    T findOne(final long id);

    /**
     * Find all entities
     * @return list of entity
     */
    List<T> findAll();

    /**
     *
     * @param entity
     */
    void create(final T entity);

    /**
     *
     * @param entity
     * @return
     */
    T update(final T entity);

    /**
     *
     * @param entity
     */
    void delete(final T entity);

    /**
     *
     * @param entityId
     */
    void deleteById(long entityId);

    /**
     *
     * @return
     */
    Connection getConnection();
}
