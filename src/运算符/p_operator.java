package 运算符;

/**
 * 位运算符
 * @author Altria
 */
public class p_operator {
    public static void main(String[] args){
        int a = 3;
        int b = 4;
        // ~：取反
        System.out.println("~a : " + ~a);
        // &：转位与
        System.out.println("a & b : " + (a & b));
        // |：转位或
        System.out.println("a | b : " + (a | b));
        // ^：按位异或
        System.out.println("a ^ b : " + (a ^ b));

        int c = 5;
        // <<：左移
        System.out.println("c << 2 : " + (c << 1));
        // >>：右移
        System.out.println("c >> 2 : " + (c >> 1));
    }
}

