package oop;

/**
 * 内部类
 * @author Altria
 */
public class Test_Internal_Class {
    // 展示匿名内部类需要
    public static void test01(Test_IC_01 t){
        // 使用匿名内部类，但是方法实际是在这里实现的，如果把这里注释掉，就不会实现
        t.t_Ic();
        // 局部内部类
        class test_class{
            public void fun(){
                System.out.println("局部内部类只能在方法中使用，方法外无法被调用");
            }
        }
        // 这里new的使用要注意顺序，放在上面无法实例化
        new test_class().fun();
    }

    /*
        在java中内部类主要分为成员内部类（非静态内部类、静态内部类）、匿名内部类、局部内部类
     */
    public static void main(String[] args){
        // 创建内部类对象
        Outer.Inner1 inner1 = new Outer().new Inner1();
        inner1.show();
        // 创建静态内部类与非静态内部类不一样，不依赖于外部类
        Outer.Inner2 inner2 = new Outer.Inner2();
        System.out.println("调用静态的内部类中的静态属性：" + inner2.num);

        // 匿名内部类
        Test_Internal_Class.test01(new Test_IC_01() {
            @Override
            public void t_Ic() {
                System.out.println("匿名内部类");
            }
        });
    }
}

// 展示匿名内部类需要
interface Test_IC_01{
    void t_Ic();
}

class Outer{
    private int age = 10;

    public void testOuter(){
    }

    // 非静态内部类中不能添加静态类的方法
    class Inner1{
        int age = 20;
        public void show(){
            // 访问外部变量
            int age = 30;
            System.out.println("外部类的私有成员变量age：" + Outer.this.age);
            System.out.println("类的成员变量age：" + this.age);
            System.out.println("局部成员变量age：" + age);
        }

    }

    // 静态内部类
    static class Inner2{
        static int num = 50;
    }
}
