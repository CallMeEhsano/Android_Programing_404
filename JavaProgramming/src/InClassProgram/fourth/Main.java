package InClassProgram.fourth;

abstract class Animal{
    protected String name;
    protected int age;

    public abstract void sound();
}

class Dog extends Animal{
    public Dog(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public void sound(){
        System.out.println("Hop Hop");
    }
}

class Cat extends Animal{
    public Cat(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public void sound(){
        System.out.println("Mio");
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a Dog instance
        Dog myDog = new Dog("Buddy", 3);
        myDog.sound(); // Output: Hop Hop

        // Create a Cat instance
        Cat myCat = new Cat("Whiskers", 2);
        myCat.sound(); // Output: Mio

        // You can also use the parent class type (polymorphism)
        Animal anotherDog = new Dog("Max", 5);
        Animal anotherCat = new Cat("Fluffy", 4);

        anotherDog.sound(); // Output: Hop Hop
        anotherCat.sound(); // Output: Mio
    }
}