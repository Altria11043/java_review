package oop;

import javax.annotation.processing.SupportedSourceVersion;

/**
 * 多态
 * @author Altria
 */
public class test_polymorphism_1 {
    public static void main(String[] args){
        Animal a = new Animal();
        a.shout();
        animalCry(a);
        Dog d = new Dog();
        animalCry(d);
        Animal c = new Cat();
        c.shout();
    }

    static void animalCry(Animal a){
        a.shout();
    }
}

class Animal{
    public void shout(){
        System.out.println("叫...");
    }
}

class Dog extends Animal{
    public void shout(){
        System.out.println("汪汪汪");
    }
}
class Cat extends Animal{
    public void shout(){
        System.out.println("喵喵喵");
    }
}

