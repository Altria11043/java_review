package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author Altria
 */
public class test_BubbleSort {
    public static void main(String[] args){
        int[] values = {2, 3, 5, 1, 4, 9, 7, 8, 6};
        int temp = 0;
        boolean flag = true;

        for(int i=1; i<values.length-1; i++){
            for(int j=0; j<values.length-i; j++){
                // 比较大小排序
                if (values[j] > values[j+1]){
                    temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = temp;

                    // 如果有一次循环没有进入判断，就可以终止所有循环了
                    flag = false;
                }
                System.out.println(Arrays.toString(values));
            }
            if (flag){
                break;
            }
            System.out.println("----------------------------------");
        }
    }
}
