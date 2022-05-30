import java.util.concurrent.locks.*;

public class Activity2 {
    public static void main(String[] args) {
        System.out.println("Driver class");
        
        // instance of each philosopher
        Philosopher[] philosophers = new Philosopher[5];
        ReentrantLock entLock = new ReentrantLock();

        for (int i = 0; i < 5; i++) {
            philosophers[i] = new Philosopher("THINKING", entLock.newCondition());
        }

        // create dining philosopher object
        DiningPhilosopher dp = new DiningPhilosopher(entLock);

        // start execution of each philosopher
        PhilosopherThread t0 = new PhilosopherThread(dp, philosophers, 0, "Philosopher 0");
        PhilosopherThread t1 = new PhilosopherThread(dp, philosophers, 1, "Philosopher 1");
        PhilosopherThread t2 = new PhilosopherThread(dp, philosophers, 2, "Philosopher 2");
        PhilosopherThread t3 = new PhilosopherThread(dp, philosophers, 3, "Philosopher 3");
        PhilosopherThread t4 = new PhilosopherThread(dp, philosophers, 4, "Philosopher 4");
        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t0.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}