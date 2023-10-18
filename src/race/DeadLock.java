package race;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pools = Executors.newFixedThreadPool(2);
        DemoFoo fjob = new DemoFoo();
        DemoBar bjob = new DemoBar();
        fjob.setB(bjob);
        bjob.setF(fjob);
        pools.execute(bjob);
        pools.execute(fjob);
        pools.shutdown();
        if(!pools.awaitTermination(30, TimeUnit.SECONDS)){
            System.out.println("time out 30 second and shut down now");
            pools.shutdownNow();
        }
                
        
    }
}
