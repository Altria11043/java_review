package com.zca.Javassist;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 测试javassist的API
 * @author Altria
 * Date: 12/10/2019 上午 1:40
 */
public class JavassistTest02 {
    public static void main(String[] args) {
        test06();
    }

    public static void test06(){
        try {
            ClassPool pool = ClassPool.getDefault();
            CtClass cc = pool.get("com.zca.Javassist.Emp");

            Object[] all = cc.getAnnotations();
            Author author = (Author) all[0];
            String name = author.name();
            int year = author.year();
            System.out.println("name: " + name + "--year: " + year);

        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取构造器
     */
    public static void test05(){
        try {
            ClassPool pool = ClassPool.getDefault();
            CtClass cc = pool.get("com.zca.Javassist.Emp");

            CtConstructor[] ctConstructors = cc.getConstructors();
            for (CtConstructor ct:ctConstructors){
                System.out.println(ct.getLongName()); // 获取构造器全称
                System.out.println(ct.getName());     // 获取构造器简称
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改属性
     */
    public static void test04(){
        try {
            ClassPool pool = ClassPool.getDefault();
            CtClass cc = pool.get("com.zca.Javassist.Emp");

            // 添加方法一
            CtField cf1 = CtField.make("private int salary;", cc);
            // 添加方法二
            CtField cf2 = new CtField(CtClass.intType, "salary", cc);
            cf2.setModifiers(Modifier.PRIVATE);// 添加修饰符
            cc.addField(cf2, "100"); // 在添加的时候顺带给个默认值

            // 给上面的属性添加get方法
            cc.addMethod(CtNewMethod.getter("getSalary", cf1));
            cc.addMethod(CtNewMethod.getter("setSalary", cf1));

            // 通过反射调用这个被修改的方法
            Class clz = cc.toClass();
            Object obj = clz.getConstructor().newInstance();
            Method method = clz.getDeclaredMethod("getSalary");
            Object ret = method.invoke(obj);
            System.out.println(ret);
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取已有的方法, 做出相应的修改
     */
    public static void test03(){
        try {
            ClassPool pool = ClassPool.getDefault();
            CtClass cc = pool.get("com.zca.Javassist.Emp");

            // 获取已有的方法
            CtMethod cm = cc.getDeclaredMethod("sayHello", new CtClass[]{CtClass.intType});
            // 可以通过这种方法对这个方法做出调整
            cm.insertBefore("System.out.println(\"这个方法是在原代码上面插入新的代码\");");
            cm.insertBefore("System.out.println(\"-------start-------\");");
//            cm.insertAt(第几行, "代码主题"); // 这里是在某一行添加代码
            cm.insertAfter("System.out.println(\"这个方法是在原代码下面插入新的代码\");");
            cm.insertAfter("System.out.println(\"-------end-------\");");

            // 通过反射调用这个被修改的方法
            Class clz = cc.toClass();
            Object obj = clz.getConstructor().newInstance();
            Method method = clz.getDeclaredMethod("sayHello", int.class);
            method.invoke(obj, 500);
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试产生新的方法
     */
    public static void test02(){
        try {
            ClassPool pool = ClassPool.getDefault();
            CtClass cc = pool.get("com.zca.Javassist.Emp");

            // 新生成方法: 一
            CtMethod cm1 = CtMethod.make("public int add(int a, int b){return a+b;}", cc);
            // 新生成方法: 二
            CtMethod cm2 = new CtMethod(CtClass.intType, "add",
                    new CtClass[]{CtClass.intType, CtClass.intType}, cc);
            cm2.setModifiers(Modifier.PUBLIC);// 添加修饰符
            cm2.setBody("{System.out.println(\"new Method\"); return $1 + $2;}");
            cc.addMethod(cm2);

            // 通过反射调用新生成的方法
            Class clz = cc.toClass();
            Object obj = clz.getConstructor().newInstance();// 通过无参构造器, 创建新的Emp对象
            Method method = clz.getDeclaredMethod("add", int.class, int.class);// 获得这个方法
            Object reuslt = method.invoke(obj, 200, 300);
            System.out.println(reuslt);
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理类的基本用法
     */
    public static void test01(){
        try {
            ClassPool pool = ClassPool.getDefault();
            CtClass cc = pool.get("com.zca.Javassist.Emp");

            // 这里是获取已有的类的信息
            byte[] bytes = cc.toBytecode();
            System.out.println(Arrays.toString(bytes));

            System.out.println(cc.getName());// 获取类名全称
            System.out.println(cc.getSimpleName());// 获取类名简称
            System.out.println(cc.getSuperclass());// 获取父类
            System.out.println(cc.getInterfaces().length);// 获取接口(这里返回的是一个数组)
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
