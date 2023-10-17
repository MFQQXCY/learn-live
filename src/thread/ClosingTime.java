package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ClosingTime {
    public static void main(String[] args) {
        ExecutorService threadpool = Executors.newFixedThreadPool(2);
        threadpool.execute(()->longJob());
        threadpool.execute(()->System.out.println("a short job"));

        threadpool.shutdown();
        try {
            boolean finish = threadpool.awaitTermination(4, TimeUnit.SECONDS);
            System.out.println("finish? = " + finish);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadpool.shutdownNow();

    }

    private static void longJob() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("a long job");
    }
}
