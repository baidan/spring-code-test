import com.baidan.springCode.module.spring.demo1.config.Demo1Config;
import com.baidan.springCode.module.spring.demo1.config.Demo1Config2Prototype;
import com.baidan.springCode.module.spring.demo1.config.Demo1Config3Lazy;
import com.baidan.springCode.module.spring.demo1.entity.Person;
import com.baidan.springCode.module.spring.demo2.config.Demo2Config;
import com.baidan.springCode.module.spring.demo2.config.Demo2ConfigType1;
import com.baidan.springCode.module.spring.demo2.config.Demo2ConfigType2;
import com.baidan.springCode.module.spring.demo3.config.Demo3Config;
import com.baidan.springCode.module.spring.demo4.config.Demo4Config;
import com.baidan.springCode.module.spring.demo4.config.Demo4Config2;
import com.baidan.springCode.module.spring.demo4.config.Demo4Config3;
import com.baidan.springCode.module.spring.demo5.config.Demo5Config;
import com.baidan.springCode.module.spring.demo5.config.Demo5ConfigBeanDefinition;
import com.baidan.springCode.module.spring.demo5.entity.Animal;
import com.baidan.springCode.module.spring.demo5.entity.Cat;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Date;

@Slf4j
public class springCodeTest {
    public static void main(String[] args) {
        //ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        long timeFlag1 = new Date().getTime();
        log.info(String.valueOf(timeFlag1));
        ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
        long timeFlag2 = new Date().getTime();
        log.info(String.valueOf(timeFlag2));
        log.info(String.valueOf(timeFlag2-timeFlag1));
        ApplicationContext app1 = new AnnotationConfigApplicationContext(Demo1Config.class);
        long timeFlag3 = new Date().getTime();
        log.info(String.valueOf(timeFlag3));
        log.info(String.valueOf(timeFlag3-timeFlag2));
        String[] beanNamesForType = app.getBeanNamesForType(Person.class);
        for (String item : beanNamesForType) {
            log.info(item);
        }

        Person person = (Person) app.getBean("person");
        log.info(String.valueOf(person));

    }

    @Test
    public void test_Component_Configuration(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Demo1Config.class);
        System.out.println("??????springContext?????????"+context.getBean("person123", Person.class));

        Demo1Config demo1Config = context.getBean("demo1Config", Demo1Config.class);
        System.out.println("??????demo1Config??????????????????"+demo1Config.person());


        System.out.println("??????springContext?????????"+context.getBean("person123", Person.class));
        System.out.println("??????demo1Config??????????????????"+demo1Config.person());

    }


    @Test
    public void xmlTest() {
        BeanDefinitionRegistry beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        ClassPathResource resource = new ClassPathResource("beans.xml");
        //?????????????????????????????????
        reader.loadBeanDefinitions(resource);

        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String a : beanDefinitionNames) {
            System.out.println("a===" + a);
        }

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("person");
        beanDefinition.setDescription("????????????");

        System.out.println("------????????????spring????????????????????????------");
        System.out.println("?????????" + beanDefinition.getParentName());
        System.out.println("?????????" + beanDefinition.getDescription());
        System.out.println("spring????????????" + beanDefinition.getBeanClassName());
        System.out.println("???????????????" + beanDefinition.getScope());
        System.out.println("?????????????????????" + beanDefinition.isLazyInit());
        System.out.println("?????????????????????" + beanDefinition.isAbstract());
        System.out.println("????????????" + beanDefinition.getSource());
    }

    @Test
    public void annotationDemo1Test() {
        ApplicationContext app = new AnnotationConfigApplicationContext(Demo1Config.class);
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        String[] beanNamesForAnnotation = app.getBeanNamesForAnnotation(Controller.class);
        for (String a : beanDefinitionNames) {
            System.out.println("a===" + a);
        }

        // @autowired??? @Resourc?????????  IXservice iXservice = (IXservice) app.getBean("IXservice");

    }

    @Test
    public void annotationDemo1Config2Test() {
        ApplicationContext app = new AnnotationConfigApplicationContext(Demo1Config2Prototype.class);
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String a : beanDefinitionNames) {
            System.out.println("a===" + a);
        }
        //?????????????????????????????????
        Object person1 = app.getBean("personPrototype");
        Object person2 = app.getBean("personPrototype");
        System.out.println(person1 == person2);

        int beanDefinitionCount = app.getBeanDefinitionCount();
        System.out.println("beanDefinitionCount===" + beanDefinitionCount);

    }

    @Test
    public void annotationDemo1Config3Test() {
        ApplicationContext app = new AnnotationConfigApplicationContext(Demo1Config3Lazy.class);
        System.out.println("IOC??????????????????......");

        //???????????????????????????bean????????????
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


    @Test
    public void annotationDemo2ConfigType1Test() {
        ApplicationContext app = new AnnotationConfigApplicationContext(Demo2ConfigType1.class);
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String a : beanDefinitionNames) {
            System.out.println("a===" + a);
        }
    }

    @Test
    public void annotationDemo2ConfigType2Test() {
        ApplicationContext app = new AnnotationConfigApplicationContext(Demo2ConfigType2.class);
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String a : beanDefinitionNames) {
            System.out.println("a===" + a);
        }
    }

    @Test
    public void annotationDemo3ConditionTest() {
        ApplicationContext app = new AnnotationConfigApplicationContext(Demo3Config.class);
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String a : beanDefinitionNames) {
            System.out.println("a===" + a);
        }
    }


    @Test
    public void annotationDemo4ImportSelectTest() {
        ApplicationContext app = new AnnotationConfigApplicationContext(Demo4Config.class);
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String a : beanDefinitionNames) {
            System.out.println("a===" + a);
        }
    }


    @Test
    public void annotationDemo4ImportBeanDefinitionRegistrarTest() {
        ApplicationContext app = new AnnotationConfigApplicationContext(Demo4Config2.class);
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String a : beanDefinitionNames) {
            System.out.println("a===" + a);
        }
    }

    @Test
    public void annotationDemo4FactoryBeanTest() {
        ApplicationContext app = new AnnotationConfigApplicationContext(Demo4Config3.class);
        Object bean1 = app.getBean("demo4FactoryBean");
        Object bean2 = app.getBean("demo4FactoryBean");

        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String a : beanDefinitionNames) {
            System.out.println("a===" + a);
        }
    }

    /**
     * ???????????????????????????xml???????????????xmlTest()???????????????????????????????????????????????? ???????????????
     */
    @Test
    public void annotationDemo5BeanDefinition() {
        //???????????????????????????spring?????????
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext();
        //???????????????
        app.register(Demo5ConfigBeanDefinition.class);
        //???????????????????????????????????????
        app.refresh();

        /*String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String a : beanDefinitionNames) {
            System.out.println("a===" + a);
        }
        //?????????????????????????????????
        Object person1 = app.getBean("demo5ConfigBeanDefinition");
        Object person2 = app.getBean("demo5ConfigBeanDefinition");
        System.out.println(person1 == person2);

        int beanDefinitionCount = app.getBeanDefinitionCount();
        System.out.println("beanDefinitionCount===" + beanDefinitionCount);*/

        //??????InterService?????????BeanDefinition ??????????????????interService????????????????????????????????????
        //BeanDefinition beanDefinition = app.getBeanDefinition("demo5ConfigBeanDefinition");
        BeanDefinition beanDefinition = app.getBeanDefinition("Demo5ConfigBeanDefinition");

        System.out.println("------????????????spring????????????????????????------");
        System.out.println("?????????" + beanDefinition.getParentName());
        System.out.println("?????????" + beanDefinition.getDescription());
        System.out.println("spring????????????" + beanDefinition.getBeanClassName());
        System.out.println("???????????????" + beanDefinition.getScope());
        System.out.println("?????????????????????" + beanDefinition.isLazyInit());
        System.out.println("?????????????????????" + beanDefinition.isAbstract());
        System.out.println("????????????" + beanDefinition.getSource());
    }

    @Test
    public void annotationDemo5BeanDefinition2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //???????????????
        context.register(Demo5Config.class);
        //Generic Bean Definition ??????Bean??????spring2.5??????????????????
        GenericBeanDefinition beanDefinitionApp = new GenericBeanDefinition();
        new RootBeanDefinition();
        beanDefinitionApp.setBeanClassName("com.baidan.springCode.module.spring.demo5.config.Demo5Config");
        beanDefinitionApp.setScope("singleton");
        beanDefinitionApp.setDescription("????????????");
        beanDefinitionApp.setAbstract(false);
        //???beanDefinition?????????spring?????????
        context.registerBeanDefinition("demo5Config", beanDefinitionApp);
        //???????????????????????????????????????
        context.refresh();

        BeanDefinition beanDefinition = context.getBeanDefinition("demo5Config");
        System.out.println("------????????????spring????????????????????????------");
        System.out.println("?????????" + beanDefinition.getParentName());
        System.out.println("?????????" + beanDefinition.getDescription());
        System.out.println("spring????????????" + beanDefinition.getBeanClassName());
        System.out.println("???????????????" + beanDefinition.getScope());
        System.out.println("?????????????????????" + beanDefinition.isLazyInit());
        System.out.println("?????????????????????" + beanDefinition.isAbstract());
        System.out.println("????????????" + beanDefinition.getSource());

    }

    @Test
    public void rootBeanDefAndChildBeanDefTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //???????????????
        context.register(Demo5Config.class);

        //??????BeanDefinition
        RootBeanDefinition root = new RootBeanDefinition();
        //??????????????????
        root.setAbstract(true);
        root.setDescription("I'M CAT,I'M TEMPLE");
        root.setBeanClass(Cat.class);
        root.getPropertyValues().add("name", "I'M CAT");
        root.getPropertyValues().add("age", 15);
        root.getPropertyValues().add("sex", 1);
        //???????????????IOC?????????
        context.registerBeanDefinition("cat", root);

        //child??????root
        ChildBeanDefinition child = new ChildBeanDefinition("cat");
        //???????????????IOC?????????,????????????????????????
        context.registerBeanDefinition("childBean", child);
        context.refresh();
        System.out.println("----------------");
        System.out.println(((Cat) context.getBean("childBean")).getName());
        System.out.println(((Cat) context.getBean("childBean")).getAge());
    }

    @Test
    public void rootBeanDefAndChildBeanDefTest2() throws ClassNotFoundException, NoSuchMethodException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //???????????????
        context.register(Demo5Config.class);
        //??????BeanDefinition
        GenericBeanDefinition root = new GenericBeanDefinition();
        //??????????????????
        root.setAbstract(true);
        root.setDescription("I'M Animal");
        root.setBeanClass(Animal.class);
        root.getPropertyValues().add("name", "?????????");
        root.getPropertyValues().add("age", 15);
        //root.getPropertyValues().add("type", "cat_y");
        root.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        //???????????????IOC?????????
        context.registerBeanDefinition("animal", root);
        //???????????????
        /**
         * Generic bean: class [com.baidan.springCode.module.spring.demo5.entity.Animal];
         * scope=prototype; abstract=true; lazyInit=null; autowireMode=0; dependencyCheck=0;
         * autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null;
         * initMethodName=null; destroyMethodName=null
         * */

        //child??????root
        GenericBeanDefinition childCat = new GenericBeanDefinition();
        childCat.setParentName("animal");
        childCat.setAbstract(false);
        childCat.setBeanClass(Cat.class);
        //???????????????IOC?????????
        context.registerBeanDefinition("cat", childCat);
        context.refresh();

        /**
         * Generic bean with parent 'animal':class [com.baidan.springCode.module.spring.demo5.entity.Cat];
         * scope=; abstract=false; lazyInit=null; autowireMode=0;
         * dependencyCheck=0; autowireCandidate=true; primary=false;
         * factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null
         **/

        //Object beanInstance = doCreateBean(beanName, mbdToUse, args); //???????????????

        Cat cat = (Cat) context.getBean("cat");
        System.out.println("---1:" + cat.getName());
        System.out.println("---2:" + cat.getAge());
        System.out.println("---3:" + context.getBeanDefinition("cat").getScope());


    }


    private static int x=0, y=0;
    private static int a=0, b=0;
    //?????????????????????
    @Test
    public  void  testDisOrder() throws InterruptedException {
        for (int i = 0;;){
             i++;
             x=0;   y=0;
             a=0;   b=0;
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                }
            });

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    y = a;
                }
            });

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();
            String result = "???"+i+"??????"+x+","+y+")";
            if(x == 0 && y==0){
                System.out.println(result);
                break;
            }
            System.out.println(result);

        }
    }

    //??????????????????????????????MESI
    private static /*volatile*/ boolean  running = true;
    @Test
    public void m() throws InterruptedException, IOException {
        //final boolean running = true;
        //boolean finalRunning = running;
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("m start");
                while (running){
                    //System.out.println("running:"+running);
                    //log.info("running:"+running);
                }
                System.out.println("m end");
            }
        });
        thread1.start();
        thread1.sleep(1000);
        running = false;

        //?????????????????????,????????????????????????
        System.in.read();
    }
}
