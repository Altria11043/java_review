package Test_Array;

public class test_Array_01 {
    public static void main(String[] args){
        int[] arrInt = new int[10];
        String[] arrStr;
        for (int i = 0; i < 10; i++){
            arrInt[i] = i;
            System.out.println(arrInt[i]);
        }
        System.out.println("arrInt长度：" + arrInt.length);

        User[] users = new User[3];
        users[0] = new User(1000, "Altria");
        users[1] = new User(1001, "Saber");
        users[2] = new User(1002, "Zhouchenan");
        System.out.println(users.length);
    }
}

class User{
    private int id;
    private String name;

    public User(){
    }
    public User(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}