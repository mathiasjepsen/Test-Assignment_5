
import _dependencies_assignment.Account;
import _dependencies_assignment.CreditCard;
import _dependencies_assignment.IATM;
import _dependencies_assignment.IAccount;
import _dependencies_assignment.IDataMapper;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.Statement;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

/**
 *
 * @author mathiasjepsen
 */
public class MockitoTest {

    @Mock
    private MysqlDataSource dataSource;

    @Mock
    private IDataMapper dm;

    @Mock
    private Connection mockConnection;

    @Mock
    private Statement mockStatement;

    @Mock
    private IATM atm;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDepositWithNoCard_returnsFalse() throws Exception {
        Mockito.when(this.mockConnection.createStatement()).thenReturn(mockStatement);
        Mockito.when(mockConnection.createStatement().executeUpdate(Mockito.any())).thenReturn(1);

//        MysqlDataSource dataSource = new MysqlDataSource();
//
//        dataSource.setUser("test-user");
//        dataSource.setPassword("1234");
//        dataSource.setURL("jdbc:mysql://localhost:3306/04_Dependencies_Assignment?serverTimezone=UTC");
//        
//        IATM atm = new ATM();
//        IDataMapper dm = new DataMapper();
//        dm.setDataSource(dataSource);
//        atm.setDataMapper(dm);
//
//        ICreditCard creditCard1 = dm.getCreditCard(0);
//        ICreditCard creditCard2 = dm.getCreditCard(1);
//        ICreditCard creditCard3 = dm.getCreditCard(2);
//        ICreditCard creditCard4 = dm.getCreditCard(3);
    }

    @Test
    public void sdf() throws Exception {
        Mockito.when(dm.getAccount(0)).thenReturn(new Account());
        Mockito.when(dm.getCreditCard(0)).thenReturn(new CreditCard());
        Mockito.doAnswer((Answer<Void>) (InvocationOnMock iom) -> {
            Object[] arguments = iom.getArguments();
            if (arguments != null && arguments.length > 1 && arguments[0] != null && arguments[1] != null) {
                IAccount account = (Account) arguments[0];
                dm.setAccount(account);
            }
            return null;
        }).when(dm).setAccount(any(Account.class));
    }
}
