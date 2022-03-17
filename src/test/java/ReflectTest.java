import org.junit.Ignore;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("AnnotationsTest");
            Annotation[] declaredAnnotations = aClass.getDeclaredAnnotations();
            for (Annotation a: declaredAnnotations) {
                System.out.println(a);
            }

            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method method:declaredMethods) {
                if(method.getName().equals("abc")){
                    Annotation[] declaredAnnotations1 = method.getDeclaredAnnotations();
                    for (Annotation a: declaredAnnotations1) {
                        System.out.println(a);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

@Deprecated
@Ignore
class AnnotationsTest{

    @Test
    @Deprecated
    public String abc(){
        return "a";
    }
}




