package ca.georgiancollege.comp1011spring2025thursdays1pm_2;

import java.util.concurrent.*;

public class Week11 {


    public static void main(String[] args) {
        example6();



    }


    static void example1(){

        String name = Thread.currentThread().getName();
        System.out.println(name);


                /*
                born/birth/new
                blocked
                waiting
                timed-waiting: sleep
                running/runnable
                terminated/dead

         */

        Runnable task = () -> {
            //Thread-N
            System.out.println("This is a task named " + Thread.currentThread().getName());
        };

        Thread t1 = new Thread(task);
        t1.start();

        Thread t2 = new Thread(task);
        t2.start();

        System.out.println("End of program");



    }
    static void example2(){


        Runnable task = () -> {
            System.out.println("Start of task named " + Thread.currentThread().getName());
            System.out.println("End of task named " + Thread.currentThread().getName());
        };

        task.run();
        //Thread
        new CustomThread().run();


    }
    static void example3(){

        Runnable task = () -> {
            try {
                for (int i = 10; i > 0; i--) {
                    System.out.println(i);
                    Thread.sleep(1000);

                    //Integer.parseInt("abc");
                }
            }
            catch (InterruptedException e){
                System.err.println(e.getMessage());
            }
        };

        new Thread(task).start();
        //Integer.parseInt("abc");
        System.out.println("End of program");

    }
    static Runnable task = () ->{
        try{
            System.out.println("start of task named " + Thread.currentThread().getName());
            for(int i = 3; i >= 0; i--){
                System.out.println("Thread name " + Thread.currentThread().getName() + " Value " + i);
                Thread.sleep(1000);
            }
            System.out.println("end of task named " + Thread.currentThread().getName());
        }
        catch (InterruptedException e){
            System.err.println(e.getMessage());
        }
    };
    static void example4(){

        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(task);
        service.execute(task);
        service.execute(task);
        service.execute(task);
        service.execute(task);

        //service.shutdown();
        try {
            service.shutdown();
            boolean done =  service.awaitTermination(10, TimeUnit.SECONDS);
            if(done){
                System.out.println("task finished");
            }
            else{
                System.out.println("Took too long. Shutting down now! Too bad, so sad!");
                service.shutdownNow();
            }
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    static void example5(){

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        service.scheduleAtFixedRate(()-> System.out.println("Running Task with name " + Thread.currentThread().getName()), 1, 5, TimeUnit.SECONDS);

        try{
            Thread.sleep(20000);
            service.shutdownNow();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }


    }
    static void example6(){


        Callable<Integer> callable = ()->{
            System.out.println("Callable Called");
            Thread.sleep(2000);
            return 10;
        };

        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> future = service.submit(callable);

        try{
           int value =  future.get(1, TimeUnit.SECONDS);
            System.out.println("The value was " + value);
        }
        catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }


    }
    static void example7(){}
}
