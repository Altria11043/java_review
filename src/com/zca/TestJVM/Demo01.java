package com.zca.TestJVM;

/**
 * 类加载机制
 * @author Altria
 * Date: 12/10/2019 上午 11:26
 */

public class Demo01 {
    static{
        System.out.println("静态初始化块Demo01---->start");
    }
    // 此处是方法调用, 必须要先加载完类之后才会调用main方法
    public static void main(String[] args) throws ClassNotFoundException {
//        System.out.println(A.height);// 被动调用, A没有被初始化
        // 主动调用A中的static属性, A被初始化, 但是没有调用A的构造器
//        System.out.println("width: " + A.width);
//        new A();// 第二次被主动调用, 没有再次初始化, 而是直接调用了构造器

        // 反射调用
//        Class.forName("com.zca.TestJVM.A");// 反射调用也会初始化A类

        // 通过数组定义类引用, 不会触发此类的初始化
//        A[] as = new A[2];

        // 这里调用了B的父类的static属性, B没有被初始化, 而是初始化了实际被调用的A
        System.out.println(B.width);
    }
    static{
        System.out.println("静态初始化块Demo01---->end");
    }
}

class B extends A{
    static {
        System.out.println("B类的静态块初始化");
    }
}

class A extends A_Father{
    public static int width = 100;
    public static final int height = 500;
    static {
        System.out.println("A类的静态块初始化");
        width = 200;
    }

    public A(){
        System.out.println("创建A类的对象");
    }
}

class A_Father{
    static{
        System.out.println("静态初始化A的父类");
    }
}