public class DiningPhilosopher {
    // initialize philosophers
    public void initialization_code(String[] philosophers) { 
        for (int i = 0; i < 5; i++)
            philosophers[i] = "THINKING";
    }
    
    // TO DO: find out self
    condition self[5];

    public void pickup(int i, String[] philosophers) { 
        philosophers[i] = "HUNGRY";
        test(i, philosophers);
        if (philosophers[i] != "EATING")
            self[i].wait();
    }

    public void putdown(int i, String[] philosophers) { 
        philosophers[i] = "THINKING";
        test((i + 4) % 5, philosophers);
        test((i + 1) % 5, philosophers);
    }

    public void test(int i, String[] philosophers) { 
        if ((philosophers[(i + 4) % 5] != "EATING") &&
            (philosophers[i] == "HUNGRY") &&
            (philosophers[(i + 1) % 5] != "EATING")) { 
                philosophers[i] = "EATING";
                self[i].signal();
        }
    }
}