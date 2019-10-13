package com.zca.TestJVM;

import com.zca.TestJVM.TestSys.FileSystemClassLoader;

/**
 * @author Altria
 * Date: 13/10/2019 上午 11:43
 */
public class Demo03 {
    public static void main(String[] args) throws ClassNotFoundException {
        FileSystemClassLoader loader1 = new FileSystemClassLoader("E:/myjava");
        FileSystemClassLoader loader2 = new FileSystemClassLoader("E:/myjava");

        Class<?> c1 = loader1.loadClass("com.zca.Test.Helloworld");
        Class<?> c2 = loader1.loadClass("com.zca.Test.Helloworld");
        Class<?> c3 = loader2.loadClass("com.zca.Test.Helloworld");
        Class<?> c4 = loader2.loadClass("java.lang.String");
        Class<?> c5 = loader2.loadClass("com.zca.TestJVM.Demo03");

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());// c3因为是不同的加载器加载的所以和上面两个的地址不一样
        System.out.println(c4.hashCode());
        // 这里是被我们自定义的类加载器加载的, 正常打印
        System.out.println(c3.getClassLoader());
        // 这里是被引导类加载器加载的, 所以为null
        System.out.println(c4.getClassLoader());
        // 这里是系统默认的类加载器
        System.out.println(c5.getClassLoader());

    }
}
