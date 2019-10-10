package com.zca.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 应用方式的API, 获取类的信息(类的名字, 属性, 方法, 构造器等)
 * @author Altria
 * Date: 10/10/2019 上午 9:44
 */
public class Dome02 {
    public static void main(String[] args) {
        String path = "com.zca.reflection.bean.User";

        try {
            Class clazz = Class.forName(path);

            // 获取类的名字
            System.out.println(clazz.getName());// 获得包名+类名
            System.out.println(clazz.getSimpleName()); // 获取类名

            // 获取属性信息
            Field[] fields = clazz.getFields(); // 获得public的属性
            System.out.println(fields.length);
            Field[] fields1 = clazz.getDeclaredFields();
            System.out.println(fields1.length); // 获得所有的属性
//            Field field = clazz.getField("id");// 这个方法只能获取到public属性
//            System.out.println(field);
            Field field1 = clazz.getDeclaredField("id");
            System.out.println(field1);
            for(Field f:fields1){
                System.out.println("属性-->" + f);
            }
            // 获取方法信息, 获取方法的方法和上面的例子类似
            Method[] methods = clazz.getMethods();
            System.out.println("获取public方法的个数: " + methods.length);
//            for (Method m:methods){
//                System.out.println("方法名-->" + m.getName());
//            }
            // 下面是遍历方法的个数以及名字
//            Method[] methods1 = clazz.getDeclaredMethods();
//            System.out.println("获取所有的方法: " + methods1.length);
//            for (Method m: methods1){
//                System.out.println("方法名-->" + m.getName());
//            }
            //
            Method method01 = clazz.getDeclaredMethod("getAge", null);
            System.out.println(method01.getName());
            // 下面的parameterTypes如果没有给出参数类型,则可能会调用错误
            Method methods02 = clazz.getDeclaredMethod("setAge", int.class);
            // 获取构造器信息
            Constructor[] constructors = clazz.getDeclaredConstructors();
            System.out.println("构造器个数: " + constructors.length);
            // 如果这里不传入参数类型, 则会获取到无参构造器(参数的顺序必须与构造器相同)
            Constructor constructor01 = clazz.getDeclaredConstructor(int.class, String.class, int.class);
            System.out.println(constructor01.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
