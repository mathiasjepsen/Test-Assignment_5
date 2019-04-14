package _dependencies_assignment;

/**
 *
 * @author mathiasjepsen
 */
public interface IAccount {

    public void setId(int id);

    public int getId();

    public void setBalance(double balance);

    public void deposit(double amount);

    public void withdraw(double amount);
    
    public double getBalance();
}
