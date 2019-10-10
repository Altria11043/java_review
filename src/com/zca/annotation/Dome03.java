package com.zca.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射获得注解信息
 * @author Altria
 * Date: 10/10/2019 上午 8:13
 */
public class Dome03 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.zca.annotation.Student");
            // 获得这个类的所有注解
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation a:annotations){
                System.out.println(a);
            }

            //获得类的指定的注解
            Table st = (Table) clazz.getAnnotation(Table.class);
            System.out.println(st.value());

            // 获得类的属性的注解
            Field f = clazz.getDeclaredField("sname");
            MyField myField = f.getAnnotation(MyField.class);
            System.out.println(myField.columnName() + "--" + myField.type() + "--" + myField.length());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
