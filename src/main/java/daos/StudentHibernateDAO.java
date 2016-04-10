package daos;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LocMX on 4/10/2016.
 */
@Repository("studentHibernateDAO")
public class StudentHibernateDAO extends GenericHibernateDao implements IGenericDAO {

    public StudentHibernateDAO() {
        super(Student.class);
    }
}
