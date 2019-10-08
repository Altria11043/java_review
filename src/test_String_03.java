/**
 * 测试String类
 * String类是不可变对象
 * 在比较字符串的时候，使用equals对里面的内容进行比较，==只是用来比较两个对象是否相等
 * @author Altria
 */
public class test_String_03 {
    public static void main(String[] args){
        String str1 = "hello world";
        String str2 = "hello" + " world";
        System.out.println(str1 == str2);

        String str3 = "hello";
        String str4 = " world";
        String str5 = str3 + str4;
        System.out.println(str5 == str2);
        str5.equals(str2);
    }
}
