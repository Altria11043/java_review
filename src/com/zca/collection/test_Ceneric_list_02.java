package com.zca.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 两个容器的操作方法
 * @author Altria
 */
public class test_Ceneric_list_02 {
    public static void main(String[] args) {
        List<String> list01 = new ArrayList<>();
        list01.add("aa");
        list01.add("bb");
        list01.add("cc");
        System.out.println("list01:" + list01);

        List<String> list02 = new ArrayList<>();
        list02.add("cc");
        list02.add("dd");
        list02.add("ee");
        System.out.println("list02:" + list02);

        // 将list02的所有元素添加到lsit01中
//        list01.addAll(list02);
        // list01中把与list02重合的元素删除
//        list01.removeAll(list02);
        // list01中把不与list02重合的元素是删除
        list01.retainAll(list02);
        System.out.println("list01:" + list01);
        System.out.println("list02:" + list02);

        // list01是否全部包含list02
        System.out.println(list01.containsAll(list02));
    }
}
