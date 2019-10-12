package com.zca.TestJVM;

/**
 * 类加载机制
 * @author Altria
 * Date: 12/10/2019 上午 11:26
 */

public class Demo01 {
    public static void main(String[] args) {
        System.out.println("width: " + A.width);
        A a = new A();
        System.out.println("width: " + A.width);
    }
}

class A{
    public static int width = 100;
    static {
        System.out.println("静态块初始化1");
        width = 200;
    }

    public A(){
        System.out.println("创建A类的对象");
    }
}
