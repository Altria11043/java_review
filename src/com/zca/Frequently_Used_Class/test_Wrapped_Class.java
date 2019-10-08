package com.zca.Frequently_Used_Class;

/**
 * 测试包装类
 * Integer类的使用，其他包装类基本一致。
 * @author Altria
 */
public class test_Wrapped_Class {
    public static void main(String[] args){
        Integer i1 = new Integer(2);
        Integer i2 = 2;
        Integer i3 = Integer.valueOf(2);    // 推荐

        // 把包装类对象转成基本数据类型
        int c = i1.intValue();
        Integer i4 = Integer.parseInt("1");

        // 把字符串转成包装类对象
        Integer e = Integer.parseInt("9999");

        // 把包装类对象转成字符串
        String str = i1.toString();

        // 常见的常量
        System.out.println("int类型最大的整数:" + Integer.MIN_VALUE);

        // 缓存[-128, 127]之间的数字，实际就是系统初始的时候，创建了[-128, 127]之间的一个缓存数组
        // 当我们调用valueOf()的时候，首先检测是否在[-128，127]之间，如果在这个范围则直接从缓存数组中拿出
        Integer i5 = Integer.valueOf(-128);
        Integer i6 = -128;
        System.out.println(i5 == i6);
        System.out.println(i5.equals(i6));
    }
}
