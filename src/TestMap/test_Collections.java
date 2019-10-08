package TestMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 与Collection有区别，这里是测试Collections工具类
 * 该工具类提供了对List，Set，Map进行排序、填充、查找元素的辅助方法
 * @author Altria
 */
public class test_Collections {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        for (int i=0; i<10; i++)
            list1.add("A+" + i);
        System.out.println(list1);

        // 倒序排列list中的元素
        Collections.reverse(list1);
        System.out.println(list1);

        // 随机排列list中的元素
        Collections.shuffle(list1);
        System.out.println(list1);

        // 按照递增的方式排序
        Collections.sort(list1);
        System.out.println(list1);

        // 二分法查找
        System.out.println(Collections.binarySearch(list1, "A+9"));
    }
}
