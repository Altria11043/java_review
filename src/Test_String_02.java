/**
 * 测试String类中常用的方法
 * @author Altria
 */
public class Test_String_02 {
    public static void main(String[] args){
        test_charAt();
        test_length();
        test_equals();
        test_IndexOf();
        test_replace();
        test_start_end_With();
        test_substring();
        test_lower_upper_case();
        test_trim();
    }

    /**
     * 打印出指定下标下的字符
     * 异常：超出字符串长度或者为负则报错
     */
    public static void test_charAt(){
        String s1 = "core java";
        String s2 = "CORE JAVA";
        System.out.println("打印出指定下标的字符：" + s1.charAt(2));
        System.out.println("打印出指定下标的字符：" + s2.charAt(2));
    }

    /**
     * 打印出字符串的长度
     */
    public static void test_length(){
        String s1 = "core java";
        System.out.println("打印出字符串长度：" + s1.length());
    }

    /**
     * 比较两个字符串的长度
     */
    public static void test_equals(){
        String s1 = "core java";
        String s2 = "CORE JAVA";
        System.out.println("比较两个字符串是否相等：" + s1.equals(s2));
        // 忽略大小写比较两个字符串是否相等
        System.out.println("比较两个字符串是否相等：" + s1.equalsIgnoreCase(s2));
    }

    /**
     * 查找字符串中是否有匹配的字符串
     * 有就返回第一个匹配的字符串下标，没有就返回-1
     */
    public static void test_IndexOf(){
        String s1 = "core java";
        String s2 = "CORE JAVA";
        // 遇到第一个符合条件的字符串就立即返回
        System.out.println("s1中是否包含“java”字符串" + s1.indexOf("java"));
        // 如果没有查到就返回-1
        System.out.println("s2中是否包含“java”字符串" + s2.indexOf("java"));
    }

    /**
     * 将一个字符串中指定的字符替换成另一个字符
     */
    public static void test_replace(){
        String s1 = "core java or JAVA";
        String s2 = s1.replace(" ","&");
        System.out.println(s2);
    }

    /**
     * 判断字符串是否已某个字符串开头/结尾
     */
    public static void test_start_end_With(){
        String s1 = "How are you?";
        System.out.println(s1.startsWith("How"));
        System.out.println(s1.endsWith("you"));
    }

    /**
     * 提取子字符串：
     * 1、从指定下标开始到字符串结尾
     * 2、从一个指定下标开始到另一个指定下标为止
     */
    public static void test_substring(){
        String s1 = "I am the bone of my sword";
        System.out.println(s1.substring(5));
        System.out.println(s1.substring(5, 9));
    }

    /**
     * 转换大小写
     */
    public static void test_lower_upper_case(){
        String s1 = "I am the bone of my sword";
        // 转小写
        System.out.println(s1.toLowerCase());
        // 转大写
        System.out.println(s1.toUpperCase());
    }

    /**
     * 去除字符串首尾的空格（中间的不会去掉）
     */
    public static void test_trim(){
        String s1 = " I am the bone of my sword   ";
        System.out.println(s1.trim());
        // 上面虽然去掉了首尾空格，但是s1本身没有变
        System.out.println(s1);
    }
}
