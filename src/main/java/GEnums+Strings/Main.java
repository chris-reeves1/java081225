public class Main {
    public static void main(String[] args) {
        

        StringBuilder sb = new StringBuilder("hello");
        sb.append(" world");
        sb.insert(5, ",");
        sb.replace(0, 5, "hi");
        sb.reverse();
        System.out.println(sb.toString());

        // for (Currency c : Currency.values()){
        //     System.out.println(c.name() + " " + c.symbol());
        // }

        // System.out.println(Currency.GBP.formater(10));
        // System.out.println(Currency.USD.formater(10.2356445));
        // System.out.println(Currency.EUR.formater(10.23));


       // StringBuilder

    //    - Srings very common + lots of ops
    //    - Immutable(changes result in new string objs)
    //    - why not primitive - complextiy + flexibility needed
    //    - System optimisations. 

    //    - strings
    //         comparrison:
    //             - ==, equals, compareTo,
    //         Transformational:
    //             - trim(), toupperCase()
    //         searching:
    //             - contains(), indexOf()
    //         substrings:
    //             - substrings()
    //         splits/joins

        // String builder:
        //     - avoids the inefficiances of creating new objects
        //     - is a mutable class - allows string manipulation to occur.

        // basic methods:
        //     - append()
        //     - insert()
        //     - delete()
        //     - reverse()
            
            













        // for (Day day : Day.values()){
        //     System.out.println(day);
        // }

        // Day today = Day.FRIDAY;

        // switch(today){
        //     case MONDAY -> System.out.println("start of the week...");
        //     case FRIDAY -> System.out.println("end of week reports generated...");
        //     default -> System.out.println("na");
        // }



        // Directions d = Directions.NORTH;

        // System.out.println(d.name()); // should return NORTH
        // System.out.println(d == Directions.NORTH); // true
        // System.out.println(d.equals(Directions.SOUTH)); // False

        // for(Directions y : Directions.values()){
        //     System.out.println(y.name() + y.ordinal());
        // }

        // System.out.println(d); // North - from the overidden toString
        // System.out.println(Directions.NORTH); // same
        // System.out.println(Directions.NORTH.name()); // NORTH
}
}


/*
Enums:
    - A DATA type - a set of CONSTANTS that we define.
    - Gives us a fixed menu - prevents misspelling + typing issues + misuse.
    - Always implicitly public, final and static.
    
    why:
        - types safety
        - built-in methods
        - overidable
        - can add user made methods.

    when complied:

        public final class Day extends Enum {
        
        public final static DAY MONDAY = new Day("MONDAY", 0);
        public final static DAY MONDAY = new Day("TUESDAY", 1);
        public final static DAY MONDAY = new Day("WEDNESDAY", 2);

        private Day(Sting name, int ordinal){
        super(name, ordinal)}

        public static Day[] values....{}
        public static Day[] name....{}

        


        
        
        }
    
    

*/