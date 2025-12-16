
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





*/