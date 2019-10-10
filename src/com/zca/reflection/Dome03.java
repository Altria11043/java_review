package com.zca.reflection;

import com.zca.reflection.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 使用反射动态操作, 构造器, 方法, 属性
 * @author Altria
 * Date: 10/10/2019 上午 11:40
 */
public class Dome03 {
    public static void main(String[] args) {
        String path = "com.zca.reflection.bean.User";

        try {
            Class<User> clazz = (Class<User>)Class.forName(path);

            // 这里通过反射API调用构造方法, 构造对象(与new一个对象类似)
            // 这里没有写入参数类型,所以调用的是无参构造器
            User user01 = clazz.getDeclaredConstructor().newInstance();
            System.out.println(user01);
            // 这里反射有参的构造器的同时还需要给出对应参数
            User user02 = clazz.getDeclaredConstructor(int.class, String.class, int.class).newInstance(1001, "Altria", 24);
            System.out.println(user02);

            // 通过反射API调用普通方法
            User user03 = clazz.getDeclaredConstructor().newInstance();
            Method method = clazz.getDeclaredMethod("setUname", String.class);
            method.invoke(user03, "Zhouchenan");
            System.out.println(user03.getUname());

            // 通过反射API操作属性
            User user04 = clazz.getDeclaredConstructor().newInstance();
            Field field = clazz.getDeclaredField("uname");
            field.setAccessible(true);// 这个属性不需要做安全检查, 可以直接访问
            field.set(user04, "Saber"); // 通过反射写属性值
            System.out.println(user04.getUname());// 通过编译的方法调用, 读取反射的值
            System.out.println(field.get(user04));// 通过反射的方法调用, 读取反射的值
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
