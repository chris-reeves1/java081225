 // int number = 10;

        // String result = (number > 5) ? "positive" : "negative";
        // System.out.println(result);

        // avoid complex + deep operators:

        // int a = 10;
        // int b = 12;
        // int c = 14;

        // String abc = !(a > b) ? (b > c ? "b is greater than c" : "c is greater than b") : "a is greater than b";
        // System.out.println(abc);

        // int number = 10;

        // int squaredOrDoubled = (number % 2 == 0) ? number * number : number * 2; 
        // System.out.println(squaredOrDoubled);

        // int number = 10;
        // int squaredOrDoubled = (number % 2 == 0) ? squaredValue(number) : doubleValue(number);
        // System.out.println(squaredOrDoubled);

        // logical and + logical or && || 

        // int age = 16;
        // boolean hasLicense = true;

        // if (age >=17 && hasLicense){
        //     System.out.println("can drive");
        // } else {
        //     System.out.println("not ok to drive");
        // }
        // if (age>=17 || hasLicense){
        //     System.out.println();
        // }else {
        //     System.out.println("not ok to drive");
        // }


        // boolean onHoliday = true;
        // boolean isVerified = false;
        // boolean isAdmin = true;
        // if(isAdmin || isVerified && !onHoliday){
        //     System.out.println("access granted");
        // } else{
        //     System.out.println("denied!");
        // }

        // int day = 2;

        // switch(day){
        //     case 1:
        //         System.out.println("monday");
        //         break;
        //     case 2:
        //         System.out.println("tuesday");
        //         break;
        //     case 3:
        //         System.out.println("wednesday");
        //         break;
        //     default: // if no matches
        //         System.out.println("other");
        // }  
        
        
        String grade = "a";
            switch (grade){
            case "a" ,"b", "c" -> System.out.println("passed");
            case "d" ,"f" -> System.out.println("failed");
            default -> System.out.println("n/a");
            }
    }



    public static int doubleValue(int x){
        return x * 2;
    }

    public static int squaredValue(int x){
        return x * x;
    }
}



/* If, if + else, if + else-if + else, ternary ops, switches.  
 * 
 * If statement
 *  - A statement to execute a block of code when a condition evaluates to being true.
 * 
 * 
 * syntax:
 * 
 *  if(condition){
 *          block of code to execute}
 * 
 *  -if - else - else provides an alternative block of code to run if 
 *                  origninal statement was false. 
 * 
 *  syntax:
 *      
 *      if(condition){
 *          code block for truthy} else{
 *          code block for falsy}
 * 
 * else - if else ladder:
 *  - provides conditions for multiple elses.
 * 
 *  syntax:
 *  
 *  if(condition){
 *          code block for truthy} else if (){
 *          code block for true} else if (){
 *          code block for true} else{
 *          code for false}
 * int x = -10;

        if (x < 0){
            System.out.println("number is less than zero");
        }

        int num = 5;

        if(num > 0){
            System.out.println("number is gretaer than zero");
        } else{
            System.out.println("number is not greater than zero!");
        }

        int number = 0;

        if(number > 0){
            System.out.println("Number is more than zero");
        } else if(number < 0){
            System.out.println("Number is less than zero");
        } else {
            System.out.println("number must be zero");
        }
 * 
 *  ternary operator - simple, single line conditionals.
 *                   - "?" stand-in for if and ":" else
 *                   - Can use to call methods
 * 
 *  syntax:
 *      variable = (condition) ? valueIfTrue : valueIfFalse
 * 
 * 
 * - switches flows like if else if else
 * - multiple blocks of code - can be run under diff circumstances.
 * - can only evaluate against bytes, chars, strings, ints, shorts. 
 * - default block - optional - can go anywhere. (c# must go at end)
 * - fall through logic. 
 * 
 * - backwards compatability
 * - avoiding repitition
 * - efficiancy/flex
 * - comments for intentioal fall-through. 
