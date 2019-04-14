package _dependencies_assignment;

import java.util.Date;

/**
 *
 * @author mathiasjepsen
 */
public class ATM implements IATM {

    private IDataMapper dataMapper;
    private boolean isCardInserted = false;
    private ICreditCard insertedCard;

    @Override
    public void setDataMapper(IDataMapper dataMapper) {
        this.dataMapper = dataMapper;
    }

    @Override
    public boolean insert(ICreditCard creditCard, String pincode) throws Exception {
        IAccount account = dataMapper.getAccount(creditCard.getId());

        if (account == null || creditCard.isBlocked()) {
            this.eject();
            System.out.println("Account was not found or the card is blocked");
            return false;
        }

        if (!pincode.equals(creditCard.getPinCode())) {
            creditCard.addWrongPinCodeAttempt();
            dataMapper.setCreditCard(creditCard);
            System.out.println("Incorrect pin code");
            this.eject();
        } else {
            creditCard.resetWrongPinCodeAttempts();
            creditCard.setLastUsed(new Date());
            dataMapper.setCreditCard(creditCard);
            this.isCardInserted = true;
            this.insertedCard = creditCard;
            return true;
        }

        return false;
    }

    @Override
    public void eject() {
        this.isCardInserted = false;
        this.insertedCard = null;
    }

    @Override
    public boolean deposit(double amount) throws Exception {
        if (!this.isCardInserted) {
            throw new NoCardInsertedException("No card inserted");
        }

        this.insertedCard.getAccount().deposit(amount);
        
        this.dataMapper.setAccount(this.insertedCard.getAccount());

        return true;
    }

    @Override
    public boolean withdraw(double amount) throws Exception {
        if (!this.isCardInserted) {
            throw new NoCardInsertedException("No card inserted");
        }

        this.insertedCard.getAccount().withdraw(amount);
        
        this.dataMapper.setAccount(this.insertedCard.getAccount());

        return true;
    }

    @Override
    public double balance() throws Exception {
        if (this.isCardInserted) {
            return this.insertedCard.getAccount().getBalance();
        }
        
        throw new NoCardInsertedException("No card inserted");
    }

}
