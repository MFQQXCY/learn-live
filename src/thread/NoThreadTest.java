package thread;

public class NoThreadTest {
    public static void main(String[] args) {
        // 此处只是在main方法栈中的正常调用，并没有起一个新的线程。
        MyRunnable r = new MyRunnable();
        r.run();

        System.out.println("to the new Thread");
        System.out.println("current Thread is +  " + Thread.currentThread().getName());
    }
}
