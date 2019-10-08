package com.zca.exception;

/**
 * 运行时如何处理
 * RuntimeException
 * @author Altria
 */
public class test_Exception_01 {
    public static void main(String[] args) {
        int a = 0;
        if (a!=0)
            System.out.println(1/a);

        String str = null;
        if (str != null)
            System.out.println(str.length());
    }
}
