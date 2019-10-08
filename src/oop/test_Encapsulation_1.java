package oop;

/**
 * 测试封装
 * @author Altria
 */
public class test_Encapsulation_1 {
    public static void main(String[] args){
    }

    protected int age;
    private String name;
    // 这里对name变量进行封装，外部想改变name的值只能通过setName方法实现
    // 这里可以对传进来的数据进行操作
    public void setName(String name){
        this.name = name;
    }
    // 外部想要获取name的值只能通过getName方法获取
    public String getName(){
        return this.name;
    }
}
// 这里默认是default，只用同一个包中可以使用，不需要特意把default加在前面
class Human{
    // 私有变量，只有当前类可以用；包括子类都不能用
    private int age;
    void sayAge(){
        System.out.println(age);
    }
}

