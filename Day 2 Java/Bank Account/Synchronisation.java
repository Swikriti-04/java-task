class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    // synchronized means only one thread can use this at a time
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + "  Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) 
        {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + "  Balance: " + balance);
        } else 
        {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + " but not enough money!");
        }
    }
}

public class Synchronisation {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(500);

        // Thread 1 → deposits money
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                account.deposit(100);
            }
        }, "Depositor");

        // Thread 2 → withdraws money
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                account.withdraw(150);
            }
        }, "Withdrawer");

        t1.start();
        t2.start();
    }
}
