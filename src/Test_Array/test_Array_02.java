package Test_Array;

import java.util.List;

/**
 * 数组初始化的方法
 * 数组的遍历，方法：OutArray()
 * @author Altria
 */
public class test_Array_02 {
    public static void main(String[] args){
        // 方法一：静态初始化
        int[] i = {1, 2, 4};
        User[] u = {
                new User(100, "Altria"),
                new User(101, "Saber")
        };

        System.out.println(OutArray(i));
        System.out.println(OutArray(u));
        // 方法二：默认初始化
        // 默认给数组的元素进行赋值。赋值的规则和成员变量默认赋值规则一致
        int[] i2 = new int[2];
        System.out.println(OutArray(i2));
        // 方法三：动态初始化
        int[] i3 = new int[3];  // 动态初始化数组，先分配空间
        i3[0] = 1;
        i3[1] = 2;
        i3[2] = 3;
        System.out.println(OutArray(i3));
    }

    // foreach循环：用于读取数组元素的值，不能修改元素的值
    public static String OutArray(int[] i){
        String str = "数组内容：";
        for (int m:i){
            str = str + m + ";";
        }
        return str;
    }

    public static String OutArray(String[] s){
        String str = "数组内容：";
        for (int i=0; i<s.length; i++){
            str = str + s[i] + ";";
        }
        return str;
    }

    private static String OutArray(User[] u){
        String str = "数组内容：";
        for (int a = 0; a < u.length; a++){
            str = str + u[a].getId() + "/" + u[a].getName() + ";";
        }
        return str;
    }
}
