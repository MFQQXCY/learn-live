package thread;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("My Runner ...");
        System.out.println("current Thread is +  " + Thread.currentThread().getName());
        Thread.dumpStack();

    }
}
