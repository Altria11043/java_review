package TestMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试Map，map的常用方法
 * 注意：键不能重复，否则会覆盖上一个内容
 * @author Altria
 */
public class test_Map_01 {
    public static void main(String[] args) {

        Map<Integer, String> m1 = new HashMap<>();

        m1.put(1, "one");
        System.out.println(m1);
        System.out.println(m1.get(1));
        System.out.println(m1.size());
        System.out.println(m1.isEmpty());
        System.out.println(m1.containsKey(2));
        System.out.println(m1.containsValue("two"));

        Map<Integer, String> m2 = new HashMap<>();
        m2.put(2, "two");
        m2.put(3, "three");
        m1.putAll(m2);
        System.out.println(m1);

    }
}
