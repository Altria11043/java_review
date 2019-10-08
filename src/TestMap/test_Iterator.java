package TestMap;

import java.util.*;

/**
 * 测试迭代器
 * @author Altria
 */
public class test_Iterator {
    public static void main(String[] args) {
        testIteratorList();
        testIteratorSet();
        testIteratorMap();
    }

    // list遍历
    public static void testIteratorList(){
        List<String> l = new ArrayList<>();
        System.out.println("遍历List");
        l.add("A");
        l.add("a");
        l.add("c");
        l.add("Z");

        /**
         * Collection继承了Iterator，所以List，Map。Set类中都有iterator方法
         * hashNext()：判断是否有下一个元素，返回boolean值
         * next()：返回元素
         */
        for (Iterator<String> i = l.iterator(); i.hasNext();){
            String temp = i.next();
            System.out.println(temp);
        }
    }
    // Set遍历
    public static void testIteratorSet(){
        Set<String> s = new HashSet<>();
        System.out.println("遍历Set");
        s.add("A");
        s.add("a");
        s.add("c");
        s.add("Z");

        /**
         * Collection继承了Iterator，所以List，Map。Set类中都有iterator方法
         * hashNext()：判断是否有下一个元素，返回boolean值
         * next()：返回元素
         */
        for (Iterator<String> i = s.iterator(); i.hasNext();){
            String temp = i.next();
            System.out.println(temp);
        }
    }
    // Map遍历
    public static void testIteratorMap(){
        Map<Integer,String> map = new HashMap<>();
        map.put(4, "dd");
        map.put(1, "aa");
        map.put(3, "cc");
        map.put(2, "bb");

        System.out.println("遍历Map1");
        // 遍历Map1
        Set<Map.Entry<Integer, String>> s = map.entrySet();
        for (Iterator<Map.Entry<Integer, String>> i = s.iterator();i.hasNext();) {
            Map.Entry<Integer, String> e = i.next();
            System.out.println(e);
        }

        System.out.println("遍历Map2");
        Set<Integer> keySet = map.keySet();
        for (Iterator<Integer> i = keySet.iterator();i.hasNext();){
            Integer temp = i.next();
            System.out.println(temp + "=" + map.get(temp));
        }
    }
}
