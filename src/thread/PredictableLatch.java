package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PredictableLatch {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CountDownLatch latch =  new CountDownLatch(1);
        executor.execute(()->waitForLatchThenPrint(latch));
        System.out.println("back in main");
        latch.countDown();
        executor.shutdown();

    }

    private static void waitForLatchThenPrint(CountDownLatch latch) {
        try {
            latch.await();
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("top o' the stack");
    }
}
