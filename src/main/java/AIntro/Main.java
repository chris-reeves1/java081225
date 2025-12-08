package AIntro;

public class Main {
    public static void main(String[] args) {
  
        // vars + data types

        // int age; // primitives stored directly in stack memory. 
        // age = 10;
        // String name = "c"; // reference type - stored in heap memory. 

        // int a = 5;
        // int b = a; // copy of the value

        // b = 10;
        // System.out.println(a); // A retains its value
        // System.out.println(b);

        // // reference type (an object can have multiple references)
        // int[] arr = {1, 2, 3};
        // int[] ref = arr;

        // ref[0] = 100;
        // System.out.println(arr[0]);
        // System.out.println(ref[0]);

        // pre and post incrementation

        //  int i = 5;
        //  int result = ++i;
        //  System.out.println(i);
        //  System.out.println(result);

        //  int k = 5;
        //  int kresult = i++;
        // System.out.println(k);
        // System.out.println(kresult);

        // for (int p=0; p<5; p++){
        //     System.out.println(p);
        // }

        // casting (narrowing - explicit) and (widening - implicit)

        // int num = 100;
        // long l  = num; // implicilt allowed
        // System.out.println(l);

        // double d = 10.5;
        // int num = (int) d; // explicit cast needed. 
        // System.out.println(num); // truncated 

        // parsing

        String intString = "123";
        int num = Integer.parseInt(intString);
        System.out.println(num);

        String boolString = "true";
        boolean bool = Boolean.parseBoolean(boolString);
        System.out.println(bool);

        


        








    }
}

/*
Java (Oak) released in 1991.

- jdk (developer kit for wrtitng + running)
- jre (Just for running.)

Complied, statically typed language - JVM runs compiled bytecode. 

main method:
    - public: (this is the access level JVM needs it to be public)
    - static: (no object is required to call this method)
    - void: (no type is returned by the method)
    - main: (just a name)
    - params: corresspond to args passed through to the method.
    - In total this gives us the signature of the method. 



    // vars + data types

        int age; // primitives stored directly in stack memory. 
        age = 10;
        String name = "c"; // reference type - stored in heap memory. 

        int a = 5;
        int b = a; // copy of the value

        b = 10;
        System.out.println(a); // A retains its value
        System.out.println(b);

        // reference type (an object can have multiple references)
        int[] arr = {1, 2, 3};
        int[] ref = arr;

        ref[0] = 100;
        System.out.println(arr[0]);
        System.out.println(ref[0]);

    // convention:
    - Always start with a letter.
    - Dont use reserved words
    - classes: PascalCase
    - methods/variables camelCase
    - snake_case -- optional. 
    - Use consistancy. 
    
- incrementation, casting, parsing. 

*/