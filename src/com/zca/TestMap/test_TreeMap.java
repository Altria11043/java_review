package com.zca.TestMap;

import java.util.Map;
import java.util.TreeMap;

/**
 * 测试TreeMap
 * 自定义排序
 * @author Altria
 */
public class test_TreeMap {
    public static void main(String[] args) {
        Map<Integer, String> map1 = new TreeMap<>();
        map1.put(6, "a");
        map1.put(1, "b");
        map1.put(4, "c");
        map1.put(7, "d");
        for (Integer key:map1.keySet()){
            System.out.println(key + "---" + map1.get(key));
        }

        Map<Emp, String> map2 = new TreeMap<>();
        map2.put(new Emp(1001, "周晨安", 5000.0), "努力工作");
        map2.put(new Emp(1003, "Altria", 50000.0), "老大");
        map2.put(new Emp(1002, "Saber", 50000.0), "分身");

        for (Emp key:map2.keySet()){
            System.out.println(key + "---" + map2.get(key));
        }

    }
}

class Emp implements Comparable<Emp>{
    int id;
    String name;
    double salary;

    public Emp(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }


    @Override
    public int compareTo(Emp o) {
        // 负数：小于    0：等于    正数：大于
        if (this.salary > o.salary){
            return 1;
        }else if (this.salary < o.salary){
            return -1;
        }else{
            if (this.id > o.id){
                return 1;
            }else if (this.id < o.id){
                return -1;
            }else{
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return "id:" + id + ",name:" + name + ",salary:" + salary;
    }
}