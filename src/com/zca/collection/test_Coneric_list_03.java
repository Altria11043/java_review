package com.zca.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 跟索引相关的方法
 * @author Altria
 */
public class test_Coneric_list_03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println(list);

        // 插入元素
        list.add(2, "Altria");
        System.out.println(list);

        // 删掉元素
        list.remove(1);
        System.out.println(list);

        // 修改掉某个下标的元素
        list.set(2, "Saber");
        System.out.println(list);

        // 获取某个下标的元素
        System.out.println(list.get(2));

        list.add("D");
        list.add("C");
        list.add("B");
        list.add("A");

        // 查找元素，返回查找到的第一个元素
        System.out.println(list.indexOf("D"));
        // 反过来查找
        System.out.println(list.lastIndexOf("A"));

    }
}
