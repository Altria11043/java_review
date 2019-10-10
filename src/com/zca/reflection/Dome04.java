package com.zca.reflection;

import com.zca.reflection.bean.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 测试使用反射和不使用反射的执行效率
 * @author Altria
 * Date: 10/10/2019 下午 12:36
 */
public class Dome04 {
    public static void test01(){
        User u = new User();
        long startTime = System.currentTimeMillis();
        for (int i=0; i<1000000000L; i++){
            u.getUname();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方法调用, 执行10亿次, 耗时:" + (endTime - startTime));
    }
    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User u = new User();
        Class clazz = u.getClass();
        Method method = clazz.getDeclaredMethod("getUname", null);
        long startTime = System.currentTimeMillis();
        for (int i=0; i<1000000000L; i++){
            method.invoke(u, null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射动态方法调用, 执行10亿次, 耗时:" + (endTime - startTime));
    }
    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User u = new User();
        Class clazz = u.getClass();
        Method method = clazz.getDeclaredMethod("getUname", null);
        method.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for (int i=0; i<1000000000L; i++){
            method.invoke(u, null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射动态方法调用,跳过安全检查, 执行10亿次, 耗时:" + (endTime - startTime));
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test01();
        test02();
        test03();
    }
}
