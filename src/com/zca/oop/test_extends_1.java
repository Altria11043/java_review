package com.zca.oop;
/**
 * 继承
 * 1、父类被称为超类、基类、派生类
 * 2、java中只有单继承，没有像C++那样的多继承，多继承会引起混乱，使得继承链过于复杂
 * @author Altria
 */
public class test_extends_1 {
    public static void main(String[] args){
        Student s = new Student();
        s.name = "Altria";
        s.height = 154;
        s.major = "java";
        s.rest();

        // instanceof：判断对象是否是某个类
        System.out.println(s instanceof Student);
        System.out.println(s instanceof Person);

    }
}

class Person{
    String name;
    int height;

    public void rest(){
        System.out.println("休息");
    }
}


class Student extends Person{
    String major;

    public void study(){
        System.out.println("学习");
    }

    public Student(){

    }

    public Student(String name, int height, String major){
        this.name = name;
        this.height = height;
        this.major = major;
    }
}