package race;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicBankAccount {
    private final AtomicInteger balance = new AtomicInteger(100);
    
    public int getBalance(){
       return balance.get();
    }

    public void spend(String name, int amount){
        // 记录balance的原始值
        int initialBalance = balance.get();
        if(initialBalance >= amount){
            // 如果此处别的线程修改了balance, 与initialBalance比较时就不会成功，
            // 即只要保证compareAndSet方法是原子性的就可以，而花销更小。
            boolean success  = balance.compareAndSet(initialBalance, initialBalance - amount);
            if(!success){
                System.out.println("Sorry " + name + ", you haven't spend the money");
            }
        }else{
            System.out.println("Sorry, not enough for" + name);
        }
    }

}
