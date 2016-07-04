package hsenid.webapp.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by hsenid on 5/25/16.
 */
public class Demo {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

        StudentDAO stdDAO = (StudentDAO) context.getBean("studentDAO");
        stdDAO.queryStudent();

    }
}
