package com.zca.annotation;

/**
 * @author Altria
 * Date: 9/10/2019 下午 5:10
 */
public class Dome02 {


    @MyAnnotation01(studentName = "这里定义值")
    public void test1(){

    }

    @MyAnnotation02("0")
    public void test2(){

    }
}
