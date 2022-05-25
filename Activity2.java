import java.util.concurrent.*;
public class Activity2 {
    public static void main(String[] args) {
        System.out.println("Driver class");
        // create dining philosopher object
        DiningPhilosopher dp = new DiningPhilosopher();
        // instance of each philosopher
        String[] philosophers = new String[5];
        // start execution of each philosopher
        Thread t0 = new Thread("0");
        Thread t1 = new Thread("1");
        Thread t2 = new Thread("2");
        Thread t3 = new Thread("3");
        Thread t4 = new Thread("4");
        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}