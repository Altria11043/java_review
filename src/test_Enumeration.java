/**
 * 测试枚举
 * 1、当需要定义一组常量的时候，可以使用枚举类型
 * 2、尽量不要使用枚举的高级特性，事实上高级特性都可以使用普通类来实现，没有必要引入枚举
 * @author Altria
 */
public class test_Enumeration {
    public static void main(String[] args) {
        System.out.println(SeaSon.SPRING);

        Week w = Week.星期一;
        switch(w){
            case 星期一:
                System.out.println("新的一周，工作又开始了");
                break;
            case 星期二:
                System.out.println("开始工作的第二天");
                break;
            case 星期三:
                System.out.println("一周过了快一半了");
                break;
            case 星期四:
                System.out.println("明天晚上可以休息了");
                break;
            case 星期五:
                System.out.println("今晚可以通宵了");
                break;
            case 星期六:
                System.out.println("通宵之后好累啊");
                break;
            case 星期日:
                System.out.println("明天又要上班了");
                break;
        }
    }
    enum SeaSon{
        SPRING,SIMMER,AUTUMN,WINTER
    }
    enum Week{
        星期一,星期二,星期三,星期四,星期五,星期六,星期日
    }
}
