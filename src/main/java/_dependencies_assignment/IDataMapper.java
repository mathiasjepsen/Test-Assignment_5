package _dependencies_assignment;

import com.mysql.cj.jdbc.MysqlDataSource;


/**
 *
 * @author mathiasjepsen
 */
public interface IDataMapper {

    public void setDataSource(MysqlDataSource dataSource);

    public void setCreditCard(ICreditCard creditCard);

    public ICreditCard getCreditCard(int id);

    public void setAccount(IAccount account);

    public IAccount getAccount(int id);
}
