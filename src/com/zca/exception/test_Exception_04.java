package com.zca.exception;

/**
 * 自定义异常
 * 1、要制定异常，就要继承异常类
 * @author Altria
 */
public class test_Exception_04 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(-10);
    }
}

class Person{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0){
            throw new IlleaglAgeException("年龄错误！！");
        }
        this.age = age;
    }
}

class IlleaglAgeException extends RuntimeException{
    public IlleaglAgeException(){

    }

    public IlleaglAgeException(String msg){
        super(msg);
    }
}