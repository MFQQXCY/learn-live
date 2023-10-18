package race;

import java.util.concurrent.atomic.AtomicInteger;

public class Balance {
    int balance = 0;

    AtomicInteger newbalance = new AtomicInteger(0);

    public synchronized  void increment(){
        balance ++;
    }

    public void atomicIncrement(){
        newbalance.incrementAndGet();
    }
}
