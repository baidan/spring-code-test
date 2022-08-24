import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;

@Slf4j
public class dataStructureTest {
    @Test
    public void collectionTest() {
        Collection a = new ArrayList();
    }

    @Test
    public void mathTest() {
        log.info(String.valueOf(new Date().getTime()));
        int sum = 0;
        int count = 1000 * 100;
        for (int i = 1; i <= count; i++) {
            sum += i;
        }
        log.info("sum=" + sum);
        log.info(String.valueOf(new Date().getTime()));

        sum = (count + 1) * count / 2;
        log.info("sum=" + sum);
        log.info(String.valueOf(new Date().getTime()));
    }


    public static void printInt2Binary(int num) {
        if (!((Integer) num instanceof Integer)) {
            new RuntimeException("数据类型错误");
        }
        String a,b;
        for (int i = 31; i >= 0; i--) {
            if (i % 8 == 0 && i<31) {
                a = "0 ";
                b = "1 ";
            }else{
                a = "0";
                b = "1";
            }
            System.out.print((num & (1 << i)) == 0 ? a : b);
        }
    }

    @Test
    public void test_1() {
        int num = 22;
        //num++;
        num = num++;
        System.out.println(num);

        Hashtable<String, String> hashtable = new Hashtable<>();
    }

    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {
        /*int num = 22;
        printInt2Binary(-1);*/

        //chars 改成abcd
        String chars = "abc";
        System.out.println(chars);
        System.out.println(chars.hashCode());
        //在这中间可以添加N行代码，但必须保证chars引用的指向不变，最终将输出变成abcd
        Field value = chars.getClass().getDeclaredField("value");
        value.setAccessible(true);
        value.set(chars, "abcd".toCharArray());
        System.out.println(chars.hashCode());
        System.out.println(chars);


    }
}


