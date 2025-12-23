package threads;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
}}
        
        
        



/*
Threading:
 - A pathway(s) of execution for our code.
 - Same memory space.
 - Resources shared accross threads.

 Why use threads:
    - Responsivness - keep code flowing, keep UI's alive/interactive.
                    - Keep heavy tasks in the background.
    - Parallel  - Get the most out of the OS. 
    - Threads can wait (happily)

- common problems:
    - race conditions: multiple threads accessing shared data without locks/coordination.
    - visability problem: threads updating shared resources 
                        - accurate values may not bet shared (cached). (volatile)
    - Deadlocks - when threads indefinately wait eachother. 

Concurrency: tasks run at virtually the same time. not 100% simultaneous. 
Parallelism: Tasks run at exactly the same tim on different cores.

Main thread:
    - Create new threads
    - Errors here take all down with it - other thread isolate errors.
    - thread.sleep()

new thread:
    - start() - build frames/stack for the new thread. 
    - run() - Executes run() on main thread (rarely used)
    - join() - wait for a thread to finish its process.
    - sleep()
    - setPriority - not guarenteed
    - synochrised, atomics..., lock, volatile. 

termination of threads:
    - normal termination
    - exception termination
    - manual termination
    - auto deamon termination

daemon thread - a background task that will no run as the only task. 

Thread daemon = new Thread(() -> {
            while (true){
                try{Thread.sleep(10000000);}catch(InterruptedException e){}
                System.out.println("daemon thread message");
            }
        });

        // Extending thread (with run) - rarely used
        Thread t1 = new Thread(){
            @Override public void run(){System.out.println("heelo from thread1");}};

        // implementing runnable
        Runnable task = () -> System.out.println("hello from thread2");
        Thread t2 = new Thread(task);


        daemon.setDaemon(false);
        daemon.start();
        t1.start();
        t2.start();

        t1.join(); // wait until t1 task has finsihed
        t2.join(); // wait until t2 task has finsihed

        System.out.println("[MAIN] - all threads finished");



interleaving example:

public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new Worker("a", 20));
        Thread b = new Thread(new Worker("b", 20));

        a.start();
        b.start();
    }
}

class Worker implements Runnable{
    String label;  
    int times;

    public Worker(String label, int times){
        this.label = label;
        this.times = times;
    }

    @Override
    public void run(){
        for(int i = 0; i < times; i++){
        System.out.println("Worker " + label + ": " + i);}
        mySleep(100000);
    }

    static void mySleep(long ms){
        try{Thread.sleep(ms);}catch(InterruptedException e){};
    }
}


//    BrokenCounter counter = new BrokenCounter();
         int threads = 8;
        int repeats = 50_000;

    //    List<Thread> list = new ArrayList<>();
    //    for (int i = 0; i < threads; i++){
    //        Thread t = new Thread(
    //            () -> {
    //                for (int r = 0; r < repeats; r++)counter.increment();
    //            }
    //        );
    //        list.add(t);
    //        t.start(); 
    //    }
    //    for (Thread t : list) t.join();
    //    System.out.println("Expected: 400000" + "actual successful ops = " + counter.value());


       SyncCounter syncCounter = new SyncCounter();
       List<Thread> syncThreads = new ArrayList<>();
       for (int i = 0; i < threads; i++) {
           Thread t = new Thread(() -> {
               for (int r = 0; r < repeats; r++) syncCounter.increment();
           });
           syncThreads.add(t);
           t.start();
       }
       for (Thread t : syncThreads) t.join();
       System.out.println("SyncCounter:");
       System.out.println("Expected: " + (threads * repeats) +
                          " | Actual: " + syncCounter.value());
   }
}

// class BrokenCounter {
//     private int count = 0;
//     void increment() { count = count + 1; } 
//     int value() { return count; }
// }

class SyncCounter {
    private int count = 0;
    synchronized void increment() { count = count + 1; } // critical section
    synchronized int value() { return count; }
}


volatile example: new Thread(() -> {
            while (running) {
                // keep working
            }
            System.out.println("Stopped");
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}

        running = false;

        static volatile boolean running = true; // guarantees visability across threads. 


    interupot basic exmaple:

    Thread worker = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Working...");
            }
            System.out.println("Stopped");
        });
        
        worker.start();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
        
        worker.interrupt();
  
   }
}


 Thread[] threads = new Thread[2];

        threads[0] = new Thread(() -> {
            try {
                threads[1].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        threads[1] = new Thread(() -> {
            try {
                threads[0].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        threads[0].start();
        threads[1].start();
        

            }}
        
        
*/