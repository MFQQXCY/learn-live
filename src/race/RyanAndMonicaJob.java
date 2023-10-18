package race;

public class RyanAndMonicaJob implements Runnable {

    private BankAccount account;

    private String name;

    private int amountToSpend;

    @Override
    public void run() {
        goShopping(amountToSpend);
    }

    public RyanAndMonicaJob(BankAccount account, String name, int amountToSpend) {
        this.account = account;
        this.name = name;
        this.amountToSpend = amountToSpend;
    }

    /**
     * 将account对象锁定。
     * 在方法开始就拿走锁的钥匙
     * 等到方法步骤完成，在将钥匙归还。
     * @param amount
     */
    public void goShopping(int amount) {
        synchronized (account) {
            if (account.getBalance() >= amount) {
                System.out.println(name + " is about to spend");
                account.spend(amount);
                System.out.println(name + " finishes spending");
            } else {
                System.out.println("Sorry, not enough for " + name);
            }
        }

    }

}
