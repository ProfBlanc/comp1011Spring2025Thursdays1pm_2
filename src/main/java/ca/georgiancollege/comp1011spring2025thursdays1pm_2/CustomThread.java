package ca.georgiancollege.comp1011spring2025thursdays1pm_2;

public class CustomThread extends Thread {

    public CustomThread() {}

    public CustomThread(String name) {
        super(name);
    }
//    public CustomThread(Runnable task, String name) {
//        super(task, name);
//    }

    @Override
    public void run() {


        System.out.println("Custom thread started");
        System.out.println("Custom thread ended");

    }

}
