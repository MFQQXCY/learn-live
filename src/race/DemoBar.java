package race;

import java.util.concurrent.TimeUnit;

public class DemoBar implements Runnable{

    private DemoFoo f;

    


    public void setF(DemoFoo f) {
        this.f = f;
    }




    @Override
    public void run() {
        go();
    }

    


    private synchronized void go(){
        System.out.println("enter bar object method");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        f.doSomething();
    }

    public synchronized void doSomething(){
        System.out.println("bar object do something method");
    }
    
}
