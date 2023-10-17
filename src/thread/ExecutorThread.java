package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorThread {
    
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new MyRunnable());

        System.out.println("back to the main Thread");
        Thread.dumpStack();
        service.shutdown();

    }
}
