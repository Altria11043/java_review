package oop;

/**
 * 方法的重写
 * @author Altria
 */
public class test_override_1 {
    public static void main(String[] args){
        Hores h = new Hores();
        h.run();
    }
}

class Vehicle{
    public void run(){
        System.out.println("跑...");
    }

    public void stop(){
        System.out.println("停下...");
    }
}

class Hores extends Vehicle{
    public void run(){
        System.out.println("用蹄子跑...");
    }
}
