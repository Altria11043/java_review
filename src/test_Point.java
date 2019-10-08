/**
 * 构造方法
 * @author Altria
 */

class Point{
    double x, y;
    public Point(double _x, double _y){
        x = _x;
        y = _y;
    }

    public double getDistance(Point p){
        return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
    }
}
// 构造方法重载
class User{
    int id;
    String name;
    String password;
    public User(){
    }

    public User(int id, String name){
        super();    // 构造方法的第一句总数super()
        this.id = id;
        this.name = name;
    }

    public User(String name, String password){
        super();
        this.name = name;
        this.password = password;
    }

}

public class test_Point {
    public static void main(String[] args){
        Point p = new Point(0.0, 0.0);
        Point o = new Point(3.0, 4.0);
        System.out.println(p.getDistance(o));

        // 构造方法重载，下面的方法调用都是正确的
        User u1 = new User();
        User u2 = new User(1, "Altria");
        User u3 = new User("Altria", "6666");
    }
}

