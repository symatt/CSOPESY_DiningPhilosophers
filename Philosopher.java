import java.util.concurrent.locks.*;

public class Philosopher {
    Condition lock;
    String state;
    
    public Philosopher(String state, Condition lock) {
        this.lock = lock;
        this.state = "THINKING";
    }
}
