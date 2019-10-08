package oop;

/**
 * 使用equals方法，试着重写
 * @author Altria
 */
public class test_Equals_1 {
    public static void main(String[] args){
        User u1 = new User(1001, "Altria", "11043");
        User u2 = new User(1001, "zhouchenan", "6666");

        System.out.println(u1 == u2);
        System.out.println(u1.equals(u2));

        String st1 = new String("zhou");
        String st2 = new String("zhou");
        System.out.println(st1 == st2);
        System.out.println(st1.equals(st2));
    }
}

class User{
    int id;
    String name;
    String pwd;

    public User(int id, String name, String pwd){
        super();
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public boolean equals(Object object){
        if (this == object)
            return true;
        if (object == null)
            return true;
        if (getClass()!= object.getClass())
            return true;
        User u = (User) object;
        if (id != u.id)
            return false;
        return true;
    }
}

