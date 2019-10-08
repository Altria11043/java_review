package com.zca.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 测试Collection接口中的方法
 * @author Altria
 */
public class test_Ceneric_list_01 {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList();
        // 返回这个容器的大小
        System.out.println("容器大小：" + c.size());
        // 判断容器中是否又内容
        System.out.println("容器中是否又元素：" + c.isEmpty());

        c.add("周晨安");
        c.add("Altria");
        System.out.println(c);
        System.out.println("容器中是否又元素：" + c.isEmpty());

        // 判断容器中是否包含某个元素
        System.out.println("是否包含“周晨安”：" + c.contains("周晨安"));

        // 将容器内的某个内容移出来
        // 容器中保存的是每个对象的地址，将对象移出来，只是将容器中所保存的对象地址删除，没有对对象本身进行任何操作
        c.remove("周晨安");
        System.out.println("容器大小：" + c.size());

        // 移出所有的内容
        c.clear();
        System.out.println("容器大小：" + c.size());
    }
}
