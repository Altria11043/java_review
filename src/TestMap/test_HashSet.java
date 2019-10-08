package TestMap;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试HashSet
 * HashSet方法是基于Map方法实现的
 * @author Altria
 */
public class test_HashSet {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();

        set1.add("a");
        set1.add("b");
        set1.add("c");
        set1.add("a");
        System.out.println(set1);

        set1.remove("a");
        System.out.println(set1);

        Set<String> set2 = new HashSet<>();
        set2.add("周晨安");
        set1.addAll(set2);
        System.out.println(set1);
    }
}
