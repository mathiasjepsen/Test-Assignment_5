package _dependencies_assignment;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 *
 * @author mathiasjepsen
 */
public class Main {
    
    
    public static void main(String[] args) {
        MysqlDataSource dataSource = new MysqlDataSource();

//        dataSource.setServerName("localhost");
//        dataSource.setPortNumber(3306);
//        dataSource.setDatabaseName("04_Dependencies_Assignment");
        dataSource.setUser("test-user");
        dataSource.setPassword("1234");
        dataSource.setURL("jdbc:mysql://localhost:3306/04_Dependencies_Assignment?serverTimezone=UTC");
        
        IATM atm = new ATM();
        IDataMapper dm = new DataMapper();
        dm.setDataSource(dataSource);
        atm.setDataMapper(dm);

        ICreditCard creditCard = dm.getCreditCard(1);
        
        try {
            boolean inserted = atm.insert(creditCard, "1234");
            System.out.println(atm.balance());
            atm.deposit(100);
            System.out.println(atm.balance());
        } catch (Exception e) {
            System.out.println(e);
        }



    }
}
