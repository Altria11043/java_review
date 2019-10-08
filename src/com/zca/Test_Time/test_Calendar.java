package com.zca.Test_Time;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 测试日期类的使用
 * @author Altria
 */
public class test_Calendar {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(2999,10,9,22,10, 50);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);   // 0-11表示对应的月份，0->1月，11->12月

        // 1表示星期日，7表示星期六
        // 7 1 2 3 4 5 6
        int week = calendar.get(Calendar.DAY_OF_WEEK);

        // 获取几号
        int day = calendar.get(Calendar.DATE);

        System.out.println(calendar);
        System.out.println(year);
        System.out.println(month);
        System.out.println(week);
        System.out.println(day);


        // 设置日期的相关元素
        Calendar calendar1 = new GregorianCalendar();
        calendar1.set(Calendar.YEAR, 2020);
        System.out.println(calendar1);
        // 日期的计算
        Calendar calendar2 = new GregorianCalendar();
        calendar2.add(Calendar.DATE, 500);  // 往后500天
        System.out.println(calendar2);

        // 日期对象和时间对象的转化
        Date d3 = calendar2.getTime();
        System.out.println(d3);
    }

    public static void printCalendar(Calendar c){
        // 打印
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DAY_OF_MONTH);
        int dayweek = c.get(Calendar.DAY_OF_WEEK);
    }
}
