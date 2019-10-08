/**
 * 测试可变字符序列和不可变序列使用的陷阱
 * @author Altria
 */
public class test_StringBuilder_03 {
    public static void main(String[] args) {
        String str1 = "";
        long num1 = Runtime.getRuntime().freeMemory();  // 获取系统剩余内存空间
        long time1 = System.currentTimeMillis();    // 获取系统的当前时间
        for(int i=0; i < 500; i++){
            str1 = str1 + i;    // 相当产生了大量对象，严重占用了内存
        }
        long num2 = Runtime.getRuntime().freeMemory();
        long time2 = System.currentTimeMillis();
        System.out.println("String占用内存：" + (num1 - num2));
        System.out.println("String消耗时间：" + (time2 - time1));

        StringBuilder sb1 = new StringBuilder();
        long num3 = Runtime.getRuntime().freeMemory();  // 获取系统剩余内存空间
        long time3 = System.currentTimeMillis();    // 获取系统的当前时间
        for(int i=0; i < 500; i++){
            sb1.append(i);  // 使用这个来进行字符串拼接不会占用大量内存
        }
        long num4 = Runtime.getRuntime().freeMemory();
        long time4 = System.currentTimeMillis();
        System.out.println("StringBuilder占用内存：" + (num3 - num4));
        System.out.println("StringBuilder消耗时间：" + (time4 - time3));
    }
}
