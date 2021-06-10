import com.baidan.springCode.module.demo1.config.Demo1Config;
import com.baidan.springCode.module.demo1.config.Demo1Config2Prototype;
import com.baidan.springCode.module.demo1.config.Demo1Config3Lazy;
import com.baidan.springCode.module.demo1.entity.Person;
import com.baidan.springCode.module.demo2.config.Demo2Config;
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
        ApplicationContext app1 = new AnnotationConfigApplicationContext(Demo1Config.class);
        System.out.println(new Date().getTime());
        String[] beanNamesForType = app.getBeanNamesForType(Person.class);
        for (String item : beanNamesForType) {
            System.out.println(item);
        }

        /*Person person = (Person)app.getBean("person");
        System.out.println(person);*/
    }

    @Test
    public void annotationDemo1Test() {
        ApplicationContext app = new AnnotationConfigApplicationContext(Demo1Config.class);
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String a : beanDefinitionNames) {
            System.out.println("a===" + a);
        }
    }

    @Test
    public void annotationDemo1Config2Test() {
        ApplicationContext app = new AnnotationConfigApplicationContext(Demo1Config2Prototype.class);
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String a : beanDefinitionNames) {
            System.out.println("a===" + a);
        }
        //单例模式，多例模式测试
        Object person1 = app.getBean("personPrototype");
        Object person2 = app.getBean("personPrototype");
        System.out.println(person1 == person2);
    }

    @Test
    public void annotationDemo1Config3Test() {
        ApplicationContext app = new AnnotationConfigApplicationContext(Demo1Config3Lazy.class);
        System.out.println("IOC容器创建完成......");

        //按照需要加载，此时bean才会添加
        Object person1 = app.getBean("personLazy");
    }

    @Test
    public void annotationDemo2Test() {
        ApplicationContext app = new AnnotationConfigApplicationContext(Demo2Config.class);
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String a : beanDefinitionNames) {
            System.out.println("a===" + a);
        }
    }
}
