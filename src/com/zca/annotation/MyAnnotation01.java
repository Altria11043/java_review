package com.zca.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * Target: 用于描述注解的使用范围(即注解可以用在什么地方)
 * Retention: 表示需要在什么级别保存该注释信息, 用于描述注解的生命周期
 * @author Altria
 * Date: 9/10/2019 下午 5:03
 */

@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation01 {

    // 这里定义参数, 可以添加默认值(如果不添加默认值使用的对象如果不使用就会报错)
    String studentName();
    int age = 18;

}
