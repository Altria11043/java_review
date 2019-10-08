package com.zca.oop;

/**
 * 抽象类
 * 1、有抽象方法的类只能定义为抽象类
 * 2、抽象类不能实例化，即不能用new来实例化抽象类
 * 3、抽象类可以包含属性，方法，构造方法。但是构造发方法不能用new实例，只能用来被子类调用
 * 4、抽象类只能用来被继承
 * 5、抽象方法必须被子类实现
 *
 * 抽象类的意义就在于，为子类提供统一的、规范的模板。子类必须实现相关的抽象方法
 * @author Altria
 */
public abstract class Test_Abstract {

    // 第一：没有实现
    abstract public void shout();

    public void run(){
        System.out.println("抽象类中的普通方法");
    }

}

class Test_Dog extends Test_Abstract{

    @Override
    public void shout() {
        System.out.println("抽象类中的抽象方法，子类必须实现");
    }
}
