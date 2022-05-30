import java.util.concurrent.locks.*;

public class DiningPhilosopher {
    
    ReentrantLock entLock;

    public DiningPhilosopher(ReentrantLock entLock) {
        this.entLock = entLock;
    }
    
    void pickup(int i, Philosopher[] philosophers) throws InterruptedException {
		this.entLock.lock();
		philosophers[i].state = "HUNGRY";
		test(i, philosophers);
		
		if(philosophers[i].state != "EATING")
			philosophers[i].lock.await();
		
		this.entLock.unlock();
	}
	
	void test(int i, Philosopher[] philosophers){
        if ((philosophers[(i + 4) % 5].state != "EATING") &&
            (philosophers[i].state == "HUNGRY") &&
            (philosophers[(i + 1) % 5].state != "EATING")) { 
                System.out.println("Philosopher " + i + " acquired its left and right chopsticks.");
                philosophers[i].state = "EATING";
                System.out.println("Philosopher " + i + " is eating.");
                philosophers[i].lock.signal();
        }
	}
	
	void putdown(int i, Philosopher[] philosophers){
		this.entLock.lock();
        System.out.println("Philosopher " + i + " released its left and right chopsticks.");
		philosophers[i].state = "THINKING";
		System.out.println("Philosopher " + i + " is thinking.");
		test((i + 4) % 5, philosophers);
        test((i + 1) % 5, philosophers);
		
		this.entLock.unlock();


	}
}