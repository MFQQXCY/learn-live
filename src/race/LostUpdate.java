package race;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LostUpdate {
    public static void main(String[] args) throws InterruptedException{
        ExecutorService pools = Executors.newFixedThreadPool(6);
        Balance balance = new Balance();
        for (int i = 0; i < 1000; i++) {
            
            pools.execute(()->balance.increment());
            pools.execute(()->balance.atomicIncrement());
        }
        pools.shutdown();
        if(pools.awaitTermination(1, TimeUnit.MINUTES)){
            System.out.println("balance = " + balance.balance);
            System.out.println("atomic balance = " + balance.newbalance.get());
        }
    }
}
