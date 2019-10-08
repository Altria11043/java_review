package TestMap;

import java.util.Set;
import java.util.TreeSet;

/**
 * 测试TreeSet
 * 底层基于TreeMap实现
 * 如果要对自定义的类进行排序，与TreeMap一样，需要自定义的类实现Comparable
 * @author Altria
 */
public class test_TreeSet {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();

        set.add(400);
        set.add(300);
        set.add(100);
        set.add(200);

        // 按照元素递增的方式将元素打印出来
        for (Integer i:set)
            System.out.println(i);
    }
}
