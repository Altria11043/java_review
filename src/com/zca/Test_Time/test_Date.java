package com.zca.Test_Time;

import java.util.Date;

/**
 * 测试Date类的常见用法
 * @author Altria
 */
public class test_Date {
    public static void main(String[] args) {
        // 当前时刻的毫秒数
        Date d = new Date();
        System.out.println(d);
        System.out.println(d.getTime());

        // 不需要用到的方法，以后遇到日期处理，使用Calendar
        Date d2 = new Date(120, 2, 3);
        System.out.println(d2);
    }
}
