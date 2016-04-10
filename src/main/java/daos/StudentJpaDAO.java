package daos;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

/**
 * Created by LocMX on 4/10/2016.
 */
@Repository("studentJpaDAO")
public class StudentJpaDAO extends GenericJpaDao implements IGenericDAO {

    public StudentJpaDAO() {
        super(Student.class);
    }

    public boolean canConnectToDatabase() {
        Connection connection = getEntityManager().unwrap(Connection.class);
        if(connection != null) {
            return true;
        }

        return false;
    }
}
