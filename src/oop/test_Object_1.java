package oop;

/**
 * 了解Object类之：重写toString方法
 * @author Altria
 */
public class test_Object_1 {
    public static void main(String[] args){
        Object obj;

        test_Object_1 to = new test_Object_1();
        System.out.println(to.toString());
    }

    public String toString(){
        return "重写toString方法";
    }
}
