package com.zca.运算符;

/**
 * 逻辑运算符
 * @author Altria
 */
public class l_operator {
    public static void main(String[] args){
        boolean b1 = true;
        boolean b2 = false;
        System.out.println("b1 = true; b2 = false");
        // &（与）
        System.out.println("b1 & b2 : " + (b1 & b2));
        // |（或）
        System.out.println("b1 | b2 : " + (b1 | b2));
        // && （与）
        System.out.println("b1 && b2 : " + (b1 && b2));
        // ||（或）
        System.out.println("b1 || b2 : " + (b1 || b2));
        // ！（非）
        System.out.println("!b1 : " + !b1);
        // ^（异或）
        System.out.println("b1 ^ b2 : " + (b1 ^ b2));
    }
}
