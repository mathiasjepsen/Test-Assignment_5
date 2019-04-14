package _dependencies_assignment;

/**
 *
 * @author mathiasjepsen
 */
public interface IATM {

    public void setDataMapper(IDataMapper dataMapper);

    public boolean insert(ICreditCard creditCard, String pincode) throws Exception;

    public void eject();

    public boolean deposit(double amount) throws Exception;

    public boolean withdraw(double amount) throws Exception;

    public double balance() throws Exception;
}
