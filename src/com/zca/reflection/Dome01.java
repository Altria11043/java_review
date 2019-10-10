package com.zca.reflection;

/**
 * 测试各种类型对应的Class对象的获取方式
 * @author Altria
 * Date: 10/10/2019 上午 9:18
 */
public class Dome01 {
    public static void main(String[] args) {
        String path = "com.zca.reflection.bean.User";
        try {
            Class clazz = Class.forName(path);

            // 对象是表示或封装一些数据. 一个类被加载后, JVM会创建以恶搞对应该类的Class对象, 类的整个结构信息会放到对应的Class对象中
            // 这个Class对象就像一面镜子一样, 通过这面镜子我们可以看到对应类的全部信息.
            System.out.println(clazz.hashCode());

            Class clazz2 = Class.forName(path);// 一个类只对应一个Class对象
            System.out.println(clazz2.hashCode());


            // 获取Class对象的方法
            System.out.println("获取Class对象方法其二");
            Class strClass01 = String.class;
            Class strClass02 = path.getClass();
            System.out.println(strClass01.hashCode());
            System.out.println(strClass02.hashCode());

            System.out.println("获取Class对象方法其三");
            int[] arr01 = new int[10];
            int[] arr02 = new int[20];
            int[][] arr03 = new int[30][10];
            System.out.println(arr01.getClass().hashCode());
            System.out.println(arr02.getClass().hashCode());
            System.out.println(arr03.getClass().hashCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
