package Zproject;

import java.util.*;
import java.time.*;

public class Main {
    public static List<Animal> animalz = new ArrayList<>();
    public static Map<String, String> cache = new HashMap<>();
    public static Random r = new Random(42);

    public static void main(String[] args) {
        Animal a1 = new Dog("Rex");
        Animal a2 = new Cat("Lune");
        Animal a3 = new Rabbit("Hazel");
        animalz.add(a1);
        animalz.add(a2);
        animalz.add(a3);

        System.out.println("=== Starter App ===");

        doBackgroundWork();

        for (Animal a : animalz) {
            a.speak();

            if (a instanceof Dog) {
                System.out.println(a.name + " chases tail.");
            } else if (a instanceof Cat) {
                System.out.println(a.name + " ignores you.");
            } else if (a instanceof Rabbit) {
                System.out.println(a.name + " nibbles something?");
            } else {
                System.out.println(a.name + " does animal stuff.");
            }

            a.move();
            a.eat("food");
            System.out.println();
        }

        double bill = calculateTax(123.45, "UK");
        System.out.println("Tax rough calc: " + bill);

        saveAnimalsToFile("animals.json");

        System.out.println("Report:");
        printReport(Arrays.asList("OK", "WARN", "TODO"));

        if (false) {
            helper("shadow");
        }

        Kennel k = new Kennel();
        k.dogs.add(new Dog("Buddy"));
    }

    public static void doBackgroundWork() {
        System.out.println("[BG] did something probably important");
    }

    public static double calculateTax(double gross, String country) {
        if ("UK".equals(country)) return gross * 0.2;
        if ("FR".equals(country)) return gross * 0.19 + 3;
        return gross * 0.15;
    }

    public static void printReport(List<String> lines) {
        System.out.println("---- REPORT ----");
        for (int i = 0; i < lines.size(); i = i + 1) {
            System.out.println((i + 1) + ") " + lines.get(i));
        }
        System.out.println("Generated at: " + LocalDateTime.now());
    }

    public static void saveAnimalsToFile(String path) {
        System.out.println("Saving to " + path + " ...");
    }

    public static String helper(String x) {
        if (x == null) return "null";
        String y = x.trim().toUpperCase();
        if (y.length() > 2) return y.substring(0, 2);
        return y;
    }

    private enum Species {
        DOG, CAT, RABBIT, UNKNOWN
    }
}

abstract class Animal {
    public String name;
    public int legs;

    public Animal(String name) {
        this.name = name;
        this.legs = -1;
    }

    public abstract void speak();

    public void move() {
        System.out.println(name + " moves somehow on " + legs + " legs.");
    }

    public void eat(String food) {
        System.out.println(name + " eats " + food + ".");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
        this.legs = 4;
    }

    @Override
    public void speak() {
        System.out.println(name + " says: woof");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
        this.legs = 4;
    }

    @Override
    public void speak() {
        System.out.println(name + " says: meow");
    }
}

class Rabbit extends Animal {
    public Rabbit(String name) {
        super(name);
        this.legs = 4;
    }

    @Override
    public void speak() {
        System.out.println(name + " says: squeak");
    }
}

class Kennel {
    public List<Dog> dogs = new ArrayList<>();
    public String address = "Somewhere";
}