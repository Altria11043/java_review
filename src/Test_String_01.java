/**
 * String类测试
 * @author Altria
 */
public class Test_String_01 {
    public static void main(String[] args){
        // 创建方法
        String s1 = "abc";
        String s2 = new String("abc");

        // 直接拼接
        String s3 = 1 + "abc";
        String s4 = "1" + 2;
        String s5 = "abc";
        System.out.println(s4);
        System.out.println(s1 == s5);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        // 上面两个虽然内容一样，但是s1和s5的字符串是在常量池中,而s2是新建了一个对象
        // == 比较的是地址，也就是说s1和s5的地址一样，s2是一个新地址里面存放了和s1与s5一样的东西

        // 如果要比较内容是否相同，建议使用equals方法。
    }
}
