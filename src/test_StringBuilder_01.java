/**
 * 测试StringBuilder
 * @author Altria
 */
public class test_StringBuilder_01 {
    public static void main(String[] args){
        // StringBuilder线程不安全，效率高（一般使用它）
        // StringBuffer线程安全，效率低
        StringBuilder sb = new StringBuilder("asfaasda");
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);

        sb.setCharAt(2, 'Q');
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);
    }
}
