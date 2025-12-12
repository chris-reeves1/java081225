
        // System.out.println(Counter.count);
        // new Counter();
        // Counter c = new Counter();

        // System.out.println(Counter.count);
        // System.out.println(c.count); // can do but discouraged!! 



        // Person person1 = Person.createChild("name");
        // Person person = new Person();
        //Person person1 = new Person("c", 10);
        // Person person2 = new Person("c");



//         Person person = new Person();
//         person.setAge(-10);
//         person.setName("name");
//         person.introduce();
// Person person1 = new Person();
// Person person2 = person1;

// System.out.println(person1 == person2); // true as points to same obj

// Person person3 = new Person();
// System.out.println(person1 == person3); // false not same obj

// System.out.println(person1.equals(person3)); // our Person does not override therefore is still false. 

// String str1 = new String("hello");
// String str2 = new String("hello");

// System.out.println(str1.equals(str2)); // should be true - same content but diff obj







    }
}

// class Person{
//     private String name;
//     private int age;

//     // paramtrized constructor
//     private Person(String name, int age){
//         this.name = name;
//         this.age = age;
//     }

  
//     // factory method
//     public static Person createChild(String name){
//         return new Person(name, 10);
//     }



// }




// class Person{
//     // fields (attributes) - makes the state of the object
//     private String name;
//     private int age; 

//     // methods - behaviour available to the object.
//     public void introduce(){
//         System.out.println("name is " + name + " age is " + age);
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public int getAge() {
//         return age;
//     }

//     public void setAge(int age) {
//         if (age >= 0){ // validation 
//             this.age = age;}
//     }
    
//}









/*
types/OOP:
    - there are two types in Java:
        - primitives
        - Reference types

    - difference:
        - what type of data they hold
        - The actions that can be performed.

    - We can make our own custom types.
        - This extends the language itself.
        
    
 example:

 class Person{
    // fields (attributes) - makes the state of the object
    String name;
    int age; 

    // methods - behaviour available to the object.
    public void introduce(){
        System.out.println("name is " + name + " age is " + age);
    }
    Person person = new Person();

        person.name = "chris";
        person.age = 10;
        person.introduce();

 - mutable vs immutable:
    - immutable types - Once created cannot be changed (eg String)
    - mutable - Can be changed (eg customn objects like Person)

    Best practice:
        - Encapsulation: use private fields + public getters/setters
        - Avoid magic numbers - always initialise with meaningful state.
        - use meaningful names


        constructors/factory method//composition....

example with getters + setters and small validation: 

Person person = new Person();
        person.setAge(-10);
        person.setName("name");
        person.introduce();


    }
}

class Person{
    // fields (attributes) - makes the state of the object
    private String name;
    private int age; 

    // methods - behaviour available to the object.
    public void introduce(){
        System.out.println("name is " + name + " age is " + age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0){ // validation 
            this.age = age;}
    }
    
}

equals and ==:

primitives: == checks for values. 
int a = 5;

int b = 5;
print(a == b) true as values are the same.

for objects == checks if pointed towards the same obj in memery. 

.equals()
Compares the content of refernece types (ie state)
(Strings/lists/Integer override .equals())



Encapsulation:
    - Resticting access.
    purpose:
        - protect the state of an object
        - control who/where access to state comes from.
        - promotes modularity

Abstraction:
    - Hide implementation details. 
    - reduce complexity, cogntive load. 
    - focus on design and structure.
    

Composition:
 - inheritance leads to coupling. 


// without composition:
    // class Engine{
    //     public void start(){
    //         System.out.println("Engine started...");
    //     }
    // }

    // class Car extends Engine {
    // }


    // with compostition:

    class Engine{
             public void start(){
                 System.out.println("Engine started...");
             }
         }

    class Car{
        public Engine engine; // stored as a pointer on heap
        int speed = 100; // stored directly in heap

        // contructor
        public Car(Engine engine){
            this.engine = engine;
        }
        public void startCar(){
            engine.start(); // delegating
            System.out.println("Car is started");
        } 
    }

    Engine engine = new Engine();
        Car car = new Car(engine);

        car.startCar();
        car.engine.start();

State:
    - determined by fields + attrs
    - accessors/mutators - getters/setters
    - for immutablity:
        - keep things private
        - prefer final
        - prefer constructors over setters(validated). 

constructors:

- block of code called when an object is created.
- provides defaults or allows specific values to be passed when created.
- default constructor used if none provided.

- a constructor has:
    - same name as the class.
    - No return type. (not even void)

- Further encapsulation - logic is centralised inside the class. 

- overloading:
    - multiple constructors (each with different params).

example: 
Person person = new Person();
        Person person1 = new Person("c", 10);
        Person person2 = new Person("c");

class Person{
    private String name;
    private int age;

    // no param constructor
    public Person(){}

    // paramtrized constructor
    public Person(String name, int age){
        this.age = age;
        this.name = name;
    }

    // single-param constructor
    public Person(String name){
        this.name = name;
        this.age = 18;

    }

Simple factory method (not a design pattern):
- return instance of a class.
- Decouples object creation fromclass logic.
- encapsulate creation to within the class itself. 
- better readability + intent

class Person{
//     private String name;
//     private int age;

//     // paramtrized constructor
//     private Person(String name, int age){
//         this.name = name;
//         this.age = age;
//     }

  
//     // factory method
//     public static Person createChild(String name){
//         return new Person(name, 10);
//     }

positives:
    - encapsulation
    - just 1 constructor needed - no overloading
    - readbilibity + intent
negatives:
    - extra overhead
    - more to debug
    - more complexity


Static attributes:
 - declare fields the static keyword - shared state accross all instances.




 */
// class Counter{
//     public static int count = 0;
//     public static final double PI = 3.14;

//     public Counter(){
//         count++;
//     }
// }