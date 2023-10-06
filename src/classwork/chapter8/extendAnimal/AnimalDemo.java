package classwork.chapter8.extendAnimal;

import java.util.Scanner;

public class AnimalDemo {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Animal animal = new Cat();
        Dog dog = new Dog();

        Cat cat = new Cat();
        Bear bear = new Bear();

        animal.eat();
        dog.eat();

    }
}

