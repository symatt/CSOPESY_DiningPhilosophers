import java.util.Random;

public class PhilosopherThread extends Thread {

    DiningPhilosopher dp;
    Philosopher[] philosophers;
    int i;
    String threadName;

    public PhilosopherThread(DiningPhilosopher dp, Philosopher[] philosophers, int i, String threadName) {
        super(threadName);
        this.dp = dp;
        this.philosophers = philosophers;
        this.i = i;
        this.threadName = threadName;
    }

    @Override public void run() {
        // System.out.println("This code is running in a thread" + this.threadName);
        System.out.println(this.threadName + " is thinking.");
        Random rand = new Random();
        int randomNum = (1 + rand.nextInt((10 - 1) + 1)) * 1000;
        try {
            Thread.sleep(randomNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        do {
            try {
                dp.pickup(i, philosophers);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rand = new Random();
            randomNum = (1 + rand.nextInt((10 - 1) + 1)) * 1000;
            try {
                Thread.sleep(randomNum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dp.putdown(i, philosophers);
            
            if (philosophers[i].state == "THINKING") {
                rand = new Random();
                randomNum = (1 + rand.nextInt((10 - 1) + 1)) * 1000;
                try {
                    Thread.sleep(randomNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } while(true);
    }
}