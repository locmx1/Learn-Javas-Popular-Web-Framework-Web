package services;

import daos.IGenericDAO;
import daos.StudentJpaDAO;
import daos.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LocMX on 3/9/2016.
 */
@Service("studentService")
public class StudentService {

    @Autowired
    @Qualifier(value = "studentJpaDAO")
    private IGenericDAO<Student> studentDAO;

    public List<Student> getStudents() {
        return studentDAO.findAll();
    }

    public Map<String, Object> getHealthCheck() {
        Map<String, Object> result = new HashMap<String, Object>();

        // Get version of pom.xml
        result.put("Version", getClass().getPackage().getImplementationVersion());

        // Get database status and all status
        if (canConnectToDatabase()) {
            result.put("CanConnectToDatabase", true);
            result.put("IsOKForAll", true);
        } else {
            result.put("CanConnectToDatabase", false);
            result.put("IsOKForAll", false);
        }

        return result;
    }

    private boolean canConnectToDatabase() {
        return studentDAO.getConnection() != null;
    }
}
