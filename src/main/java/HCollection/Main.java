package collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        
        // generics
        // ArrayList list = new ArrayList();
        // list.add(123);
        // list.add("123");

        // ArrayList<String> glist = new ArrayList<>();
        // glist.add(123);
        // glist.add("123");

        ArrayList<String> food = new ArrayList<>();

        food.add("apple");
        food.add("kiwi");
        food.add("pear");

        System.out.println(food);

        //accesing items:
        food.get(0);
        food.set(0, "zblueberry");

        //food.clear();
        food.remove(2);

        food.size();
    System.out.println(food);
    Collections.sort(food);
    System.out.println(food);

    // dequeue:

    ArrayDeque<Integer> deque = new ArrayDeque<>();

    deque.addFirst(1); // head
    deque.addLast(2); // tail

    deque.offerFirst(3); // returns a boolean
    deque.removeFirst(); // errors if nothing there - be cautious.
    deque.pollFirst(); // doesnt error if empty

    deque.peekFirst(); // returns null if empty

    // hashmap

    HashMap<String, Integer> map = new HashMap<>();
        // keys are unique. 
    map.put("a", 1);
    map.put("b", 2);

    map.put("a", 3);

    map.putIfAbsent("c", 10);

    for(Integer value : map.values()){
        System.out.println(value);
    }

    for(String keys: map.keySet()){
        System.out.println(keys);
    }

    for (Map.Entry<String, Integer> entry: map.entrySet()){
        String key = entry.getKey();
        Integer value = entry.getValue();

        System.err.println("key: " + key +" , value is " + value);
    }

*************

package collections;

import java.util.*;

public class LookupTimingDemo {
    public static void main(String[] args) {
        int n = 32_000_000; // 100k for quick demo; increase if you like
        List<Integer> arrayList = new ArrayList<>(n);
        Set<Integer> hashSet = new HashSet<>(n * 2);
        Map<Integer, Integer> hashMap = new HashMap<>(n * 2);

        for (int i = 0; i < n; i++) {
            arrayList.add(i);
            hashSet.add(i);
            hashMap.put(i, i);
        }

        int miss = -1;     // a value not present
        int hit = n - 1;   // a value present

        // Warm-up
        for (int i = 0; i < 3_000; i++) {
            arrayList.contains(hit);
            hashSet.contains(hit);
            hashMap.get(hit);
        }

        time("ArrayList.contains (hit)", () -> arrayList.contains(hit));
        time("ArrayList.contains (miss)", () -> arrayList.contains(miss));

        time("HashSet.contains (hit)", () -> hashSet.contains(hit));
        time("HashSet.contains (miss)", () -> hashSet.contains(miss));

        time("HashMap.get (hit)", () -> hashMap.get(hit));
        time("HashMap.get (miss)", () -> hashMap.get(miss));
    }

    static void time(String label, Runnable r) {
        long t0 = System.nanoTime();
        for (int i = 0; i < 200; i++) r.run();
        long t1 = System.nanoTime();
        System.out.printf("%-28s ~ %7.3f µs per call%n",
                label, (t1 - t0) / 200.0 / 1_000.0);
    }
}



*********************

package collections;

import java.util.*;

public class MiddleOpsDemo {
    public static void main(String[] args) {
        int n = 200_000;
        int mid = n / 2;

        List<Integer> arr = new ArrayList<>(n);
        List<Integer> link = new LinkedList<>();
        for (int i = 0; i < n; i++) { arr.add(i); link.add(i); }

        // Warm-up
        arr.get(mid); link.get(mid);

        // Insert at middle
        time("ArrayList add(mid)", () -> {
            List<Integer> a = new ArrayList<>(arr); // copy to isolate timing
            a.add(a.size()/2, -1);
        });

        time("LinkedList add(mid)", () -> {
            List<Integer> l = new LinkedList<>(link);
            l.add(l.size()/2, -1);
        });

        // Remove at middle
        time("ArrayList remove(mid)", () -> {
            List<Integer> a = new ArrayList<>(arr);
            a.remove(a.size()/2);
        });

        time("LinkedList remove(mid)", () -> {
            List<Integer> l = new LinkedList<>(link);
            l.remove(l.size()/2);
        });
    }

    static void time(String label, Runnable r) {
        long t0 = System.nanoTime();
        r.run();
        long t1 = System.nanoTime();
        System.out.printf("%-22s %7.3f ms%n", label, (t1 - t0) / 1_000_000.0);
    }
}


*******************************************


package collections;

import java.util.*;

public class LinkedListBestCase {
    public static void main(String[] args) {
        final int n = 200_000, ops = 10_000;

        // Prepare lists
        List<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) arr.add(i);

        LinkedList<Integer> link = new LinkedList<>(arr);

        // Warm up
        for (int i = 0; i < 5_000; i++) { arr.contains(-1); link.contains(-1); }

        // ArrayList: repeatedly insert at middle (pays shift each time)
        long t0 = System.nanoTime();
        int mid = arr.size() / 2;
        for (int i = 0; i < ops; i++) arr.add(mid, -i); // each insert shifts ~n/2
        long t1 = System.nanoTime();

        // LinkedList: move iterator ONCE to middle, then add next to it (O(1) per add)
        long t2 = System.nanoTime();
        ListIterator<Integer> it = link.listIterator(link.size() / 2);
        for (int i = 0; i < ops; i++) it.add(-i); // no traversal between adds
        long t3 = System.nanoTime();

        System.out.printf("ArrayList middle inserts: %.2f ms%n", (t1 - t0)/1e6);
        System.out.printf("LinkedList (iterator parked) inserts: %.2f ms%n", (t3 - t2)/1e6);
    }
}