package com.zca.TestMap;

import java.util.*;

/**
 * 测试表格数据的存储
 * @author Altria
 */
public class test_StoreData02 {
    public static void main(String[] args) {
        User user1 = new User(1001, "周晨安", 10000.0, "2019-09-09");
        User user2 = new User(1002, "Altria", 20000.0, "2018-09-09");
        User user3 = new User(1003, "Saber", 30000.0, "2017-09-09");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        for (User u:list)
            System.out.println(u);

        System.out.println("========================================");

        Map<Integer, User> map = new HashMap<>();
        map.put(1, user1);
        map.put(2, user2);
        map.put(3, user3);
        Set<Integer> set = map.keySet();
        for (Integer i:set)
            System.out.println(map.get(i));
    }
}

class User{
    private int id;
    private String name;
    private double salary;
    private String hiredate;

    // 一个完整的javabean，要有一个无参构造器和get、set方法
    public User() {}

    public User(int id, String name, double salary, String hiredate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.hiredate = hiredate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "id:" + id + "\tname:" + name + "\tsalary:" + salary + "\thiredate:" + hiredate;
    }
}
