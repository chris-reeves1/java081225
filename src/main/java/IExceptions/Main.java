package exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class Main {
    public static void main(String[] args) throws IOException {
        try{level1();}catch(ArithmeticException e){System.out.println(e.getMessage());}

        }
        public static void level1(){
            level2();
        }
        public static void level2(){
            level3();
        }
        public static void level3(){
            int result = 10 / 0;
        }
}





/*
Exceptions
----------
- mechanism to deal with run time errors
- allows normal flow to continue
- try-catch-finally block. throw/throws
- try-with

types:
    - checked exceptions:
        must be dealt with before we compile - either try/catch or throws.
        - eg: sqlexceptions, IOexceptions
    - unchecked exceptions:
        Occur at runtime and not caught by the compiler
        mathsexceptions.
    - errors:
        - represents issues we cant deal with in code (like memory)

syntax:

    try{
        code thay might throw an exception - multi allowed but only first exception
        raised can be dealt with and potentially skip further code here.
        } catch(ExceptionType e){
         optionally print info, send to logs, [ERROR] - e.getmessage()}
         catch (ExceptionType (broader)){}
         finally{clean-up ops}
        

examples: 
// checked exception:
        try{
        FileReader fr = new FileReader("nonExistantfile.txt");
    } catch(IOException e){
       System.out.println("[ERROR] file error - " + e.getMessage());
    } 
    finally{System.out.println("logging...");}
        
    // unchecked exceptions -- example of 2nd exception being ignored!!!!!!
        try{
            int result = 10 / 0;
            String s = null;
            System.out.println(s.length());
        }catch(ArithmeticException e){
            System.out.println("[ERROR] maths error - " + e.getMessage());
        }catch(NullPointerException e){System.out.println("[ERROR] null error - " + e.getMessage());}


class InvalidAgeException extends Exception{
    public InvalidAgeException(String message){
        super(message);
    }
}

class AgeValidator{
    public void validateAge(int age) throws InvalidAgeException {
        if(age < 18){
            throw new InvalidAgeException("Age must be 18 or over");
        }
    }
}

 AgeValidator av = new AgeValidator();
        try{
            av.validateAge(15);
        }catch(InvalidAgeException e){
            System.out.println(e.getMessage());
        }


try with -
close() - anything that implements this can be auto closed.
syntax:

    try (create obj/resource){run the code}catch(){}finally{optional}


    try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))){
    String s;
} catch(IOException e){}
    

}}

propagation (bubbling up)
- When exception occurs java looks for a catch to handle it.
- IF not caught by the calling methos 1) error out or 2) pass on to higher calling method.
- if reaches main method must be dealt with here or error out. 
*/