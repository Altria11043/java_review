package com.zca.TestJVM;

/**
 * @author Altria
 * Date: 13/10/2019 上午 10:09
 */
public class Demo02 {
    public static void main(String[] args) {
        // 当前系统目前使用的类加载器, 应用程序类加载器(application class loader)
        // jdk.internal.loader.ClassLoaders$AppClassLoader@3fee733d
        System.out.println(ClassLoader.getSystemClassLoader());
        // 其父类加载器叫: 扩张类加载器
        // jdk.internal.loader.ClassLoaders$PlatformClassLoader@2f4d3709
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        // 扩张类加载器的父类是引导类加载器, 因为引导类加载器是由C++实现的, 所以这里返回的是null
        // null
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

        // 当前系统加载器的加载和处理所在路径
        System.out.println(System.getProperty("java.class.path"));
    }
}
