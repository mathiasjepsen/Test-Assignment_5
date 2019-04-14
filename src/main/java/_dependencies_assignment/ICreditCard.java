package _dependencies_assignment;

import java.util.Date;

/**
 *
 * @author mathiasjepsen
 */
public interface ICreditCard {

    public void setId(int id);

    public int getId();

    public void setAccount(IAccount account);

    public IAccount getAccount();

    public void setLastUsed(Date lastUsed);

    public Date getLastUsed();

    public void setPinCode(String pinCode);

    public String getPinCode();

    public void setWrongPinCodeAttempts(int wrongPinCodeAttempts);

    public void addWrongPinCodeAttempt();

    public int getWrongPinCodeAttempts();

    public void resetWrongPinCodeAttempts();

    public void setBlocked(boolean blocked);

    public boolean isBlocked();
}
