/**
 * 测试static关键字的用法
 * @author Altria
 */
public class test_static {
    int id;
    String name;
    String pwd;

    static String company = "Altria";

    public test_static(int id, String name){
        this.id = id;
        this.name = name;
    }
    public void login(){
        System.out.println("登入：" + name);
    }
    public static void printCompany(){
        System.out.println(company);
    }
    public static void main(String[] args){
        test_static ts = new test_static(123, "周晨安");
        test_static.printCompany();
        test_static.company = "Saber";
        test_static.printCompany();
    }
}
