package Collections;

import java.nio.file.attribute.AclEntryPermission;

public class Main {
    public static void main(String[] args) {


        //Dog dog = new Dog("doggo");

        // Dog dog = new Dog();
        // dog.speak();


        // Car car = new Car();
        // car.speed = 100;
        // car.displaySpeed();
        // car.superDisplaySpeed();

        // ref = what can be seen/wired
        // obj = what is implemted at runtime
        Animal animal = new Dog(); // implicit casting -always ok
        // animal.speak();
        //animal.testMethod();
        Dog dog = (Dog) animal; // explicit casting
        System.out.println(animal instanceof Dog);
           
        // polymorphism collection
        Animal[] animals = {new Dog(), new Dog(), new Cat()};

        for (Animal a: animals){
            a.speak(); // dynamic method dispatch. runtime decides. 
            a.animalOnlyMethod();
            // instanceOf = safety check
            if(a instanceof Dog){Dog d = (Dog) a; d.fetch();}
            // casting here is not making an object just telling the 
            // comiler treat as Dog/Cat not Animal.
            if (a instanceof Cat){Cat c = (Cat) a; c.sitting();}
            //if(a isinstance fetchable) Fetachble f = (Fetchable) a;
            // f.fetch()
            // maybe overridding is better than casting. 
            // adding new types neees to mod here.
            // Open/closed principle. (extensible not modifiable)
            // could improve by checking aainst behaviouir not type 
            // using an interface/ 
        }
    }
}
class Animal{
    //protected String name;

    public void speak(){
        System.out.println("Animal speaks...");
    }
    public void animalOnlyMethod(){
        System.out.println("animal something...");
    }
    // abstract or empty method
    // public void inject(){}
}
interface fetchable {
    void fetch();
    }
    

class Dog extends Animal implements fetchable{
    @Override
    public void speak(){
        System.out.println("Dog is speaking...");
    }

    public void fetch(){
        System.out.println("Dog fetchs");
    }

    //@override public void inject(){
      //  fetch();
    //}
}

class Cat extends Animal{
    @Override
    public void speak(){
        System.out.println("Cat speaks...");
    }
    public void sitting(){
        System.out.println("cat sits...");
    }
}

// // basic override 

// class Vehicle{
//     protected int speed;

//     public void displaySpeed(){
//         System.out.println(speed);
//     }
// }
// class Car extends Vehicle{
//     @Override
//     public void displaySpeed(){
//         System.out.println("cars speed = " + speed);
//     }

//     public void superDisplaySpeed(){
//         super.displaySpeed();
//     }
// }

// constructor example

// class Animal{
//     protected String name;

//     public Animal(String name){
//         this.name = name;
//     }
// }

// class Dog extends Animal{
//     protected int age;

//     public Dog(String name){
//         this(name, 1);
//     }

//     public Dog(String name, int age){
//         super(name); // always goes first
//         this.age = age;
//     }

//     public void displayName(){
//         System.out.println(name);
//     }
// }


/*
inheritance:
syntax:
    class SuperClass{
    attributes, constructors, methods}

    class SubClass extends SuperClass {
    additional fields, constructors, methods + inherits all others.  }



   Note: final methods inherited but not overriden
         final classes cant be extended. 


    rules:
        - classes only extend once
        - Automatically inherit everything from superclass()
        - Constructors not inherited - need to be called with super()
        - prefer shallow inheritance - no deep chains!
        - prefer compositions - "has-a" over "is-a"
        - always overrise toString()

    All classes extend Object - gives us toString(), hashcode(), eqauls()...

    subclasses:
        - inherits
        - Access fields and methods depending on access levels.
        - Use methods + ability to override
        - override @Override annotation - makes clear intent + checks for correct name. 



    fields:
        - inherit all (except private), access depend on methods
        - public: acessable everywhere
        - protected: package + sub-classes
        - default: package only
        - private: no access

    constructors:
        - not inhertied
        - call with super()
        - first arg in constructor needs to be this() or super()


substitutability:
    - subtypes must be substituable for the parent - without going 
    into incorrect state or altering the correct flow of the app.
    - flexible - adaptable to future changes
    - reusability - write generic code
    - abstraction. 



*/