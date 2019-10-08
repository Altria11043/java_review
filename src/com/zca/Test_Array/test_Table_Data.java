package com.zca.Test_Array;

import java.util.Arrays;

/**
 * 测试数组存储表格数据
 * @author Altria
 */
public class test_Table_Data {
    public static void main(String[] args){
        Object[] emp1 = {1001, "Altria", 14};
        Object[] emp2 = {1002, "Alter", 1};
        Object[] emp3 = {1003, "Saber", 16};

        Object[][] tableData = new Object[3][];
        tableData[0] = emp1;
        tableData[1] = emp2;
        tableData[2] = emp3;

        for (Object[] temp:tableData){
            System.out.println(Arrays.toString(temp));
        }
    }
}
