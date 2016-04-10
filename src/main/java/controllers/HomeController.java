package controllers;

import daos.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import services.StudentService;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LocMX on 2/25/2016.
 */

@Controller
@EnableWebMvc
@RequestMapping("/student")
public class HomeController {

    @Autowired
    @Qualifier("studentService")
    StudentService studentService;

    @RequestMapping(value = "/health", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String, Object> healthCheck() {
        return studentService.getHealthCheck();
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Student> getStudents() {
        List<Student> result = studentService.getStudents();
        /*model.addAttribute("student", result);*/
        return result;
    }

    @RequestMapping(value = "student/create", method = RequestMethod.GET)
    public String getForm() {
        return "form_student";
    }

    @RequestMapping(value = "student/create", method = RequestMethod.POST)
    public String postForm(Student student) {
        return "form_student";
    }

}
