package thread;

public class ThreadTest {
    public static void main(String[] args) {



        // 创建线程的实例，并手动管理线程
        Thread t = new Thread(new MyRunnable());
        System.out.println("begin to start a new Thread");
        
        t.start();
        System.out.println("back to the main Thread");
        Thread.dumpStack();

    

    }

}


