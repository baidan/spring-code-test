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
        System.out.println("调用springContext获取："+context.getBean("person123", Person.class));

        Demo1Config demo1Config = context.getBean("demo1Config", Demo1Config.class);
        System.out.println("调用demo1Config的方法获取："+demo1Config.person());


        System.out.println("调用springContext获取："+context.getBean("person123", Person.class));
        System.out.println("调用demo1Config的方法获取："+demo1Config.person());

    }


    @Test
    public void xmlTest() {
        BeanDefinitionRegistry beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        ClassPathResource resource = new ClassPathResource("beans.xml");
        //整个资源加载的切入点。
        reader.loadBeanDefinitions(resource);

        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String a : beanDefinitionNames) {
            System.out.println("a===" + a);
        }

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("person");
        beanDefinition.setDescription("手动注入");

        System.out.println("------该对象在spring中的附加属性如下------");
        System.out.println("父类：" + beanDefinition.getParentName());
        System.out.println("描述：" + beanDefinition.getDescription());
        System.out.println("spring的名称：" + beanDefinition.getBeanClassName());
        System.out.println("实例范围：" + beanDefinition.getScope());
        System.out.println("是否是懒加载：" + beanDefinition.isLazyInit());
        System.out.println("是否是抽象类：" + beanDefinition.isAbstract());
        System.out.println("类路径：" + beanDefinition.getSource());
    }

    @Test
    public void annotationDemo1Test() {
        ApplicationContext app = new AnnotationConfigApplicationContext(Demo1Config.class);
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        String[] beanNamesForAnnotation = app.getBeanNamesForAnnotation(Controller.class);
        for (String a : beanDefinitionNames) {
            System.out.println("a===" + a);
        }

        // @autowired和 @Resourc相当于  IXservice iXservice = (IXservice) app.getBean("IXservice");

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

        int beanDefinitionCount = app.getBeanDefinitionCount();
        System.out.println("beanDefinitionCount===" + beanDefinitionCount);

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
     * 产生的问题：如果是xml读取，见：xmlTest()，自定义的后置处理器未触发？？？ 原因待查找
     */
    @Test
    public void annotationDemo5BeanDefinition() {
        //以下三行代码完成了spring的启动
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext();
        //注册配置类
        app.register(Demo5ConfigBeanDefinition.class);
        //加载或者刷新当前的配置信息
        app.refresh();

        /*String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String a : beanDefinitionNames) {
            System.out.println("a===" + a);
        }
        //单例模式，多例模式测试
        Object person1 = app.getBean("demo5ConfigBeanDefinition");
        Object person2 = app.getBean("demo5ConfigBeanDefinition");
        System.out.println(person1 == person2);

        int beanDefinitionCount = app.getBeanDefinitionCount();
        System.out.println("beanDefinitionCount===" + beanDefinitionCount);*/

        //获取InterService对应的BeanDefinition ，默认名称为interService，关于名字的更改以后讲。
        //BeanDefinition beanDefinition = app.getBeanDefinition("demo5ConfigBeanDefinition");
        BeanDefinition beanDefinition = app.getBeanDefinition("Demo5ConfigBeanDefinition");

        System.out.println("------该对象在spring中的附加属性如下------");
        System.out.println("父类：" + beanDefinition.getParentName());
        System.out.println("描述：" + beanDefinition.getDescription());
        System.out.println("spring的名称：" + beanDefinition.getBeanClassName());
        System.out.println("实例范围：" + beanDefinition.getScope());
        System.out.println("是否是懒加载：" + beanDefinition.isLazyInit());
        System.out.println("是否是抽象类：" + beanDefinition.isAbstract());
        System.out.println("类路径：" + beanDefinition.getSource());
    }

    @Test
    public void annotationDemo5BeanDefinition2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册配置类
        context.register(Demo5Config.class);
        //Generic Bean Definition 通用Bean定义spring2.5之后版本才有
        GenericBeanDefinition beanDefinitionApp = new GenericBeanDefinition();
        new RootBeanDefinition();
        beanDefinitionApp.setBeanClassName("com.baidan.springCode.module.spring.demo5.config.Demo5Config");
        beanDefinitionApp.setScope("singleton");
        beanDefinitionApp.setDescription("手动注入");
        beanDefinitionApp.setAbstract(false);
        //将beanDefinition注册到spring容器中
        context.registerBeanDefinition("demo5Config", beanDefinitionApp);
        //加载或者刷新当前的配置信息
        context.refresh();

        BeanDefinition beanDefinition = context.getBeanDefinition("demo5Config");
        System.out.println("------该对象在spring中的附加属性如下------");
        System.out.println("父类：" + beanDefinition.getParentName());
        System.out.println("描述：" + beanDefinition.getDescription());
        System.out.println("spring的名称：" + beanDefinition.getBeanClassName());
        System.out.println("实例范围：" + beanDefinition.getScope());
        System.out.println("是否是懒加载：" + beanDefinition.isLazyInit());
        System.out.println("是否是抽象类：" + beanDefinition.isAbstract());
        System.out.println("类路径：" + beanDefinition.getSource());

    }

    @Test
    public void rootBeanDefAndChildBeanDefTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册配置类
        context.register(Demo5Config.class);

        //模板BeanDefinition
        RootBeanDefinition root = new RootBeanDefinition();
        //设置为抽象类
        root.setAbstract(true);
        root.setDescription("I'M CAT,I'M TEMPLE");
        root.setBeanClass(Cat.class);
        root.getPropertyValues().add("name", "I'M CAT");
        root.getPropertyValues().add("age", 15);
        root.getPropertyValues().add("sex", 1);
        //注册，放到IOC容器中
        context.registerBeanDefinition("cat", root);

        //child继承root
        ChildBeanDefinition child = new ChildBeanDefinition("cat");
        //注册，放到IOC容器中,等于取了一个别名
        context.registerBeanDefinition("childBean", child);
        context.refresh();
        System.out.println("----------------");
        System.out.println(((Cat) context.getBean("childBean")).getName());
        System.out.println(((Cat) context.getBean("childBean")).getAge());
    }

    @Test
    public void rootBeanDefAndChildBeanDefTest2() throws ClassNotFoundException, NoSuchMethodException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册配置类
        context.register(Demo5Config.class);
        //模板BeanDefinition
        GenericBeanDefinition root = new GenericBeanDefinition();
        //设置为抽象类
        root.setAbstract(true);
        root.setDescription("I'M Animal");
        root.setBeanClass(Animal.class);
        root.getPropertyValues().add("name", "小小猫");
        root.getPropertyValues().add("age", 15);
        //root.getPropertyValues().add("type", "cat_y");
        root.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        //注册，放到IOC容器中
        context.registerBeanDefinition("animal", root);
        //执行到此处
        /**
         * Generic bean: class [com.baidan.springCode.module.spring.demo5.entity.Animal];
         * scope=prototype; abstract=true; lazyInit=null; autowireMode=0; dependencyCheck=0;
         * autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null;
         * initMethodName=null; destroyMethodName=null
         * */

        //child继承root
        GenericBeanDefinition childCat = new GenericBeanDefinition();
        childCat.setParentName("animal");
        childCat.setAbstract(false);
        childCat.setBeanClass(Cat.class);
        //注册，放到IOC容器中
        context.registerBeanDefinition("cat", childCat);
        context.refresh();

        /**
         * Generic bean with parent 'animal':class [com.baidan.springCode.module.spring.demo5.entity.Cat];
         * scope=; abstract=false; lazyInit=null; autowireMode=0;
         * dependencyCheck=0; autowireCandidate=true; primary=false;
         * factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null
         **/

        //Object beanInstance = doCreateBean(beanName, mbdToUse, args); //实际实例化

        Cat cat = (Cat) context.getBean("cat");
        System.out.println("---1:" + cat.getName());
        System.out.println("---2:" + cat.getAge());
        System.out.println("---3:" + context.getBeanDefinition("cat").getScope());


    }


    private static int x=0, y=0;
    private static int a=0, b=0;
    //指令重排序测试
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
            String result = "第"+i+"次（"+x+","+y+")";
            if(x == 0 && y==0){
                System.out.println(result);
                break;
            }
            System.out.println(result);

        }
    }

    //触发缓存一致性机制，MESI
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

        //让主线程不停止,子线程会继续循环
        System.in.read();
    }
}
