package Test_Array;

import java.util.Arrays;

/**
 * 2D数组
 */
public class test_2Dimension_Array {
    public static void main(String[] args){
        int[][] i = new int[3][];

        i[0] = new int[]{12, 24, 65};
        i[1] = new int[]{52, 2};
        i[2] = new int[]{23, 53, 21, 2};
        System.out.println(Arrays.toString(i[0]));

        // 静态初始化二维数组
        int[][] j = {
                {21, 254, 1},
                {52, 21, 12}
        };
        System.out.println(Arrays.toString(j[0]));
    }
}
