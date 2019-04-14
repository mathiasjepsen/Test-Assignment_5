package _dependencies_assignment;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mathiasjepsen
 */
public class DataMapper implements IDataMapper {

    private MysqlDataSource dataSource;

    @Override
    public void setDataSource(MysqlDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void setCreditCard(ICreditCard creditCard) {
        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE creditcard SET last_used=" + creditCard.getLastUsed() + ","
                                                    + "pin_code=" + creditCard.getPinCode() + ","
                                     + "wrong_pin_code_attempts=" + creditCard.getWrongPinCodeAttempts() + ","
                                                     + "blocked=" + creditCard.isBlocked() + ","
                                                  + "account_id=" + creditCard.getAccount().getId() + " "
                                                    + "WHERE id=" + creditCard.getId());
        } catch (SQLException e) {

        }
    }

    @Override
    public ICreditCard getCreditCard(int id) {
        ICreditCard creditCard = null;
        IAccount account = null;

        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM creditcard WHERE id=" + id);
            ArrayList<Object> rs1ColumnValues = new ArrayList();
            ArrayList<Object> rs2ColumnValues = new ArrayList();

            if (rs1.next()) {
                for (int i = 1; i < rs1.getMetaData().getColumnCount() + 1; i++) {
                    rs1ColumnValues.add(rs1.getObject(i));
                }
            }

            ResultSet rs2 = stmt.executeQuery("SELECT * FROM account WHERE id=" + (int) rs1ColumnValues.get(5));
            if (rs2.next()) {
                for (int i = 1; i < rs2.getMetaData().getColumnCount() + 1; i++) {
                    rs2ColumnValues.add(rs2.getObject(i));
                }
            }
            
            account = new Account();
            creditCard = new CreditCard(); 
            
            account.setId((int) rs2ColumnValues.get(0));
            account.setBalance((double) rs2ColumnValues.get(1));

            creditCard.setId(id);
            creditCard.setLastUsed((Date) rs1ColumnValues.get(1));
            creditCard.setPinCode((String) rs1ColumnValues.get(2));
            creditCard.setWrongPinCodeAttempts((int) rs1ColumnValues.get(3));
            creditCard.setBlocked((boolean) rs1ColumnValues.get(4));
            creditCard.setAccount(account);

            return creditCard;
        } catch (SQLException e) {
            System.out.println(e);
        }

        return creditCard;
    }

    @Override
    public void setAccount(IAccount account) {
        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE account SET balance=" + account.getBalance() + " "
                                               + "WHERE id=" + account.getId());
        } catch (SQLException e) {

        }
    }

    @Override
    public IAccount getAccount(int id) {
        IAccount account = null;
        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM account WHERE id=" + id);
            ArrayList<Object> columnValues = new ArrayList();

            if (rs.next()) {
                for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) {
                    columnValues.add(rs.getObject(i));
                }
            }
            
            account = new Account();
            
            account.setId((int) columnValues.get(0));
            account.setBalance((double) columnValues.get(1));
            
            return account;
        } catch (SQLException e) {

        }
        return account;
    }

}
