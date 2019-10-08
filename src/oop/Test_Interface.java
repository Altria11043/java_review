package oop;

/**
 * 接口类
 * @author Altria
 */
public interface Test_Interface {
    /*
        1、访问修饰符只能是public或默认
        2、接口名：和类名采用相同的命名机制
        3、extends：接口可以多继承
        4、常量：接口中的属性只能说常量，总是：public、static
        5、方法：接口中的方法只能是：public abstract。省略的话，也是public abstract
     */

    int maxAge=100;
    public static final int minAge = 0;

    void test01();
    public abstract void test02();

    /*
        1、子类通过implements来实现接口中的规范
        2、接口不能创建实例，但是可用声明引用变量类型
        3、一个类实现了接口,必须实现接口中所有的方法,并且这些方法只能是public的
        4、JDK1.7之前，接口中只能包含静态常量、抽象方法，不能有普通属性、构造方法、普通方法
        5、JDK1.8后，接口中包含普通的静态方法
     */
}


class My_Interface implements Test_Interface{

    @Override
    public void test01() {
        System.out.println("实现接口中的方法");
    }

    @Override
    public void test02() {
        System.out.println("打印接口中的常量" + maxAge + ":" + minAge);
    }
}

// 接口可以多继承
interface Test_Extends01{
    void Extends01();
}
interface Test_Extends02{
    void Extends02();
}

interface Test_Extends03 extends Test_Extends01,Test_Extends02{
    void Extends03();
}

class MyExtends04 implements Test_Extends03{

    @Override
    public void Extends01() {
        System.out.println("只要是继承了的，都要实现：Extends01");
    }

    @Override
    public void Extends02() {
        System.out.println("只要是继承了的，都要实现：Extends02");
    }

    @Override
    public void Extends03() {
        System.out.println("只要是继承了的，都要实现：Extends03");
    }
}