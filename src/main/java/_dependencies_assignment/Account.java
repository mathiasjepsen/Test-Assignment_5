package _dependencies_assignment;

/**
 *
 * @author mathiasjepsen
 */
public class Account implements IAccount {

    private int id;
    private double balance;

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        this.balance -= amount;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }
    
}
