package com.zca.运算符;

/**
 * 条件运算符（三元运算符）
 * @author Altria
 */
public class c_operator {
    public static void main(String[] args){
        int s1 = 45;
        int s2 = 85;
        int s3 = 99;
        String type = s1 < 60? "不及格" : "及格";
        System.out.println(type);
        // 双重判断
        String s = s2 < 80 ? "不及格" : ( s2 < 90 ? "良好" : "优秀");
        System.out.println(s);
    }
}
