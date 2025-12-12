/*
    Arrays:
        - collection: of values
        - must be of the same type.
        
    syntax:
        - //declaring
        - int[] arrayInt;
        - type arrayType[] // also valid

        declare and initialise:
        - int[] arrayint = new int[5] //sets the length
        - int[] arrayint = {1, 2, 3, 4} // literal initialistion.

        characteristics:
            - fixed length
            - zero-based indexing
            - Only one data type
            - NO inbuilt methods

        in-memory:
            - contiguous memory in the heap. 
            - primitives in heap. 
            - referneces stored in the arrays memory boxes(not the actual object)

        defaults:
            int: 0;
            boolean: False
            float: 0.0
            obj/string: null
            char: u/0000

        why use: 
            - speed + predictable performance and code
            - memory efficiant
            - legacy code
            - best for primitives.
            - outofboundserror
    */

            int[] numbers = {10, 20, 30};

            numbers[0] = 100;

            System.out.println(numbers.length);

            // copy + copyof + nested. 








}
}
