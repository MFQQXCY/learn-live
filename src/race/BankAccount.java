package race;

public class BankAccount {
    
    private int balance = 100;
    
    public int getBalance(){
        return balance;
    }

    public void spend(int cost){
        balance = balance - cost;
        if(balance < 0){
            System.out.println(" OVERDRAWN !");
        }
        
    }
}
