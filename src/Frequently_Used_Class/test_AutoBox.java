package Frequently_Used_Class;

/**
 * 测试自动装箱，自动拆箱
 * @author Altria
 */
public class test_AutoBox {
    public static void main(String[] args){
        // 自动装箱
        Integer i = 234; // Integer i = Integer.ValueOf(234);
        // 自动拆箱
        int b = i;  //编译器会自动为我们补充好：int b = i.IntValue();
    }
}
