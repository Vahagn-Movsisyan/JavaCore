package classwork.chapter8.extendAnimal;


public class AnimalDemo {

    public static void main(String[] args) {

        Animal animal = new Animal();
        Dog dog = new Dog();
        Cat cat = new Cat();

        animal.eat();

        animal = dog;


        Animal animal1 = new Bear();

        animal.eat();
        cat.eat();
        dog.eat();
        animal1.eat();

    }
}

