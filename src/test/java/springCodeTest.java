import com.baidan.springCode.module.configCode.config.ConfigClass;
import com.baidan.springCode.module.configCode.entity.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class springCodeTest {
    public static void main(String[] args) {
        //ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println(new Date().getTime());
        ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println(new Date().getTime());
        ApplicationContext app1 = new AnnotationConfigApplicationContext(ConfigClass.class);
        System.out.println(new Date().getTime());
        String[] beanNamesForType = app.getBeanNamesForType(Person.class);
        for (String item : beanNamesForType) {
            System.out.println(item);
        }

        /*Person person = (Person)app.getBean("person");
        System.out.println(person);*/
    }

    @Test
    public void compolintTest() {
        ApplicationContext app = new AnnotationConfigApplicationContext(ConfigClass.class);
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String a : beanDefinitionNames) {
            System.out.println("a==="+a);
        }
    }
}
