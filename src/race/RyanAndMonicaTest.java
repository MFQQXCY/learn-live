package race;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RyanAndMonicaTest {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        
        RyanAndMonicaJob ryan = new RyanAndMonicaJob(bankAccount, "ryan", 50);
        RyanAndMonicaJob monica = new RyanAndMonicaJob(bankAccount, "monica", 100);


        ExecutorService threadpools = Executors.newFixedThreadPool(2);
        threadpools.execute(monica);

        threadpools.execute(ryan);
        threadpools.shutdown();
        

    }
}
