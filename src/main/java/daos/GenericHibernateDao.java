package daos;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by LocMX on 4/10/2016.
 */
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericHibernateDao<T extends Serializable>
        extends AbstractHibernateDAO<T> implements IGenericDAO<T> {

    public GenericHibernateDao() {

    }

    public GenericHibernateDao(Class<T> clazz) {
        super(clazz);
    }
}
