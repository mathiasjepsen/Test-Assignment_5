package _dependencies_assignment;

import java.util.Date;

/**
 *
 * @author mathiasjepsen
 */
public class CreditCard implements ICreditCard {

    private int id;
    private IAccount account;
    private Date lastUsed;
    private String pinCode;
    private int wrongPinCodeAttempts;
    private boolean isBlocked;

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setAccount(IAccount account) {
        this.account = account;
    }

    @Override
    public IAccount getAccount() {
        return this.account;
    }

    @Override
    public void setLastUsed(Date lastUsed) {
        this.lastUsed = lastUsed;
    }

    @Override
    public Date getLastUsed() {
        return this.lastUsed;
    }

    @Override
    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String getPinCode() {
        return this.pinCode;
    }

    @Override
    public void setWrongPinCodeAttempts(int wrongPinCodeAttempts) {
        this.wrongPinCodeAttempts = wrongPinCodeAttempts;
    }

    @Override
    public void addWrongPinCodeAttempt() {
        this.wrongPinCodeAttempts += 1;
    }

    @Override
    public int getWrongPinCodeAttempts() {
        return this.wrongPinCodeAttempts;
    }

    @Override
    public void resetWrongPinCodeAttempts() {
        this.wrongPinCodeAttempts = 0;
    }

    @Override
    public void setBlocked(boolean blocked) {
        this.isBlocked = blocked;
    }

    @Override
    public boolean isBlocked() {
        return this.isBlocked;
    }
    
}
