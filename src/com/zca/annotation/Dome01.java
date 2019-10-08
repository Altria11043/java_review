package com.zca.annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Altria
 * Date: 8/10/2019 下午 12:56
 */
public class Dome01 {
    // 这个注解表示这个方法是重写了父类的方法
    @Override
    public String toString(){
        return null;
    }

    // 这个注解表示这个方法不推荐使用
    @Deprecated
    public static void test01(){
        System.out.println("test01");
    }

    // 用来抑制编译时的警告信息
    @SuppressWarnings("all")
    public static void test02(){
        List list = new ArrayList();
        List list2 = new ArrayList();
    }

    public static void main(String[] args) {
        test01();
    }
}
