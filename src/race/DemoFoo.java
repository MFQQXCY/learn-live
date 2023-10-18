package race;

// import java.util.concurrent.TimeUnit;

public class DemoFoo implements Runnable{

    private DemoBar b;

    

    @Override
    public void run() {
        go();
    }


    private synchronized void go(){
        System.out.println("enter foo object method");
        // try {
        //     TimeUnit.SECONDS.sleep(3);
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        b.doSomething();
        
    }

    public synchronized void doSomething(){
        System.out.println("foo object do something method");
    }


    public void setB(DemoBar b) {
        this.b = b;
    }
    
    

}
