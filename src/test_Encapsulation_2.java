import oop.test_Encapsulation_1;

public class test_Encapsulation_2{
    public static void main(String[] args){
        test_Encapsulation_1 te = new test_Encapsulation_1();
        // 这里是对test_Encapsulation_1中的私用变量进行操作
        System.out.println(te.getName());
        te.setName("Altria");
        System.out.println(te.getName());
    }

}

// 这里继承了test_Encapsulation_1类，所以test_Encapsulation_1类中用protected修饰的属性都能使用
class test_Protected extends test_Encapsulation_1{
    public void test(){
        // 这个变量名来自test_Encapsulation_1
        age = 10;
    }
}