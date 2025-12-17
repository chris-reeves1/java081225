package interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Person> person = new ArrayList<>();
        person.add(new Person(60, "C"));
        person.add(new Person(80, "B"));
        person.add(new Person(60, "A"));

        Collections.sort(person);
        for (Person x: person){
            System.out.println(x.getAge() + " " + x.getName());
        }

    }
}
   
// inbuilt interfaces - 100's+ learn a few. 
// comparable
// allows us to define how objects get compared to eachother.
// smallest to largest
// useful sorting - Collections.sort() -- implements it! 
class Person implements Comparable<Person>{
    private int age;
    private String name;
    
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge(){return age;}
    public void setAge(int age) {this.age = age;}
    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    @Override
    public int compareTo(Person x){
        int result = Integer.compare(this.age, x.age);
        if (result !=0) {return result;}
        return this.name.compareTo(x.name);
    }
}



//     Operation add = (a, b) -> a + b;
//     Operation multiply = (a, b) -> a * b;

//     System.out.println(multiply.apply(3, 4));


//     ShoppingCart cart = new ShoppingCart(new PayPal());
//     cart.checkout(2000);
//    }
// }

// class CreditCard implements PaymentStrategy{
//     @Override
//     public void pay(int amount){
//         System.out.println("Paid " + amount + " with CreditCard.");
//     }
// }
// class PayPal implements PaymentStrategy{
//     @Override
//     public void pay(int amount){
//         System.out.println("Paid " + amount + " with PayPal");
//     }
// }

// class ShoppingCart{
//     private PaymentStrategy strategy;

//     public ShoppingCart(PaymentStrategy strategy){
//         this.strategy = strategy;
//     }

//     public void checkout(int amount){
//         strategy.pay(amount);
//     }
// }

// in built interfaces:
// - comparable()



/*
Interfaces
----------

- Helps us to define more abstraction + contracts of behaviour.
- Define shared behaviour, any class can implement regardless of any hierarchies. 

relationships:
    inheritance: "is-a"
    composition: "uses"
    interfaces: "can-do"

why:
    - abstraction
    - decoupled
    - multiple implementations per class allowed.

design:
    - holds constants - implicitly static, final and public.
    - abstracts + defaults

implementation:
    - keyword: implements
    - default - are optional - use them or not!
    - bodyless mehtod must be implemented by the class. 
    - speration principle - smaller + frequent over larger + rarer. 


    class MyClass implements A, B {
    @Override
    public void show(){
        A.super.show();
        System.out.println("Custom implementation also...");
    }
}
    -- inherited methods will take prcedence over interfaces with
    methods of the same name.
    -- Otherwise you need to decide which one to use. 

    Naming convention:
        - the name should convey the behaviour.
        - adjective, verbs...
        - Ianimal, Iflyable, Ioperable.... 

    
lass Drone implements Flyable, Operable{

    @Override
    public void operate() {  
    }

    @Override
    public void fly() {
    }}

class Airplane implements Flyable{
    @Override
    public void fly(){System.out.println("Airplane is flying");};
}

class Dog implements Animal{
    @Override
    public void eat(){};
}

class Cat implements Animal{
    @Override
    public void eat(){};
    @Override
    public void sleep(){};
    
}

class MyClass implements A, B {
    @Override
    public void show(){
        A.super.show();
        System.out.println("Custom implementation also...");
    }
}
pattern strategy:

public class Main {
   public static void main(String[] args) {
        Logger logger = new ConsoleLogger();
        App app = new App(logger);
        app.run();
   }
    }
// strategy pattern / dependancy injection
class ConsoleLogger implements Logger{
    @Override
    public void log(String message){
        System.out.println("[LOG] - " + message);
    }
}

class App{
    private final Logger logger;

    public App(Logger logger){
        this.logger = logger;
    }

    public void run(){
        logger.log("application runs successfully");
    }

package interfaces;

public interface Logger {
    void log(String message);
}
}

Marker Interfaces:
- Tagging/marking a class with an empty interfaces. 
- acts as a flag/tag/metadata
- eg: serializable{} clonable{}

- replaced by annotations.

Functional interfaces:
- @FunctionalInterface = SAM single abstract method.
- lets us implement lambda functions.
- streams, API, method references.

Operation add = (a, b) -> a + b;
    Operation multiply = (a, b) -> a * b;

    System.out.println(multiply.apply(3, 4));

package interfaces;

@FunctionalInterface
public interface Operation {
    int apply(int a, int b);
}

Generic interfaces: 
- types saftey
- Flexibility

syntax:
    package interfaces;

public interface Container<T> {
    void add(T item);
    T get();
}


public static void main(String[] args) {
    IntegerContainer ic = new IntegerContainer();
    ic.add(100);
    System.out.println(ic.get());

    GenricContainer<String> gc = new GenricContainer<>();
    gc.add("£10@");
   }
}
class GenricContainer<T> implements Container<T>{
    private T item;

    @Override
    public void add(T item){
        this.item = item;
    }
    @Override
    public T get(){
        return item;
    }
}

class IntegerContainer implements Container<Integer>{
private int item;

    @Override
    public void add(Integer item){
        this.item = item;
    }
    @Override
    public Integer get(){
        return item;
}
}



*/
/*
Abstracts
---------
- An abstract class cannot be initialised.
- declared by abstract keyword. 
- method - abstract keyword and bodyless.
- abstract implementations must be doen in a sub-class.
- allows stonger hierarchical design, more detailed blueprint.

- Shared state, common mehtods and properties given to all child classes.
- FORCING BEHAVIOUR. 

benifts to design:
    - enforce contracts
    - ensures specific/important behaviour can be delegated.
    - flixibility - concretes - allow regular code reuse. 

problems:
    - tight coupling
    - less modular
    - scalability issues.
    - complexity

problems with concretes:
    - Cant enforce behaviour
    - instantiation is allowed and can be dangerous. 
    - coupling 

Advanced rules:
    - primitives: NO variance is allowed. wrapper class to side-step this. 
    - Refernece types: Original or a sub-type. 
    - Void cannot be changed. 
    
    Override rules:
        - access: Must be same or more permissive.
        - unchecked exceptions can be anything - broader/narrower
        - checked exceptions narrower only!
        
abstracts vs Interfaces:
                            abstracts                   interfaces
instantiation:                  no                          no
constructors:                   yes                         no
fields:                         yes(plus full A/C)          CONSTANTS(only)
methods:                        abstract/concrete           abstract/concrete
inheritance:                    Only extend once            implements many


examples:

public static void main(String[] args) {
        DataProcess json = new JsonProcess();
        json.process();
    }
}

abstract class DataProcess{
    // template Design pattern - method
    public final void process(){
        statusCheck();
        readFile();
        transformData();
        saveData();
        logOutcome();
    } 

    public void statusCheck(){
        System.out.println("file found, can continue...");
    }
    public void logOutcome(){
        System.out.println("outcome logged...");
    }

    abstract void readFile();
    abstract void saveData();
    abstract void transformData();
} 

class JsonProcess extends DataProcess{
    @Override
    void readFile(){
        System.out.println("data read...");   
    }

    @Override
    void saveData(){
        System.out.println("data saved..."); 
    }

    @Override
    void transformData(){
        System.out.println("data updated..."); 
    }

}

abstract class Animal{ // technially an incomplete class.
    abstract void sleep(); //bodyless to be abstract
}

class Dog extends Animal{
    @Override
    void sleep(){System.out.println("sleeping...");};
}

// mix of abstracts and concretes

abstract class Vehicle{
    abstract void drive();
    void something(){
        System.out.println("something...");
    }
}

class Car extends Vehicle{
    @Override
    void drive(){};

    @Override // optional how we deal with concretes. 
    void something(){};
}

// abstract to abstract to concrete

abstract class Vehicle1{
    abstract void drive();
    void something(){
        System.out.println("something...");
    }
}

abstract class Car1 extends Vehicle1{
    //@Override
    //void drive(){};

    @Override // optional how we deal with concretes. 
    void something(){};
}

class ElectricCar extends Car1{
    @Override
    void drive(){};

    // @Override // optional how we deal with concretes. 
    // void something(){};
}






*/