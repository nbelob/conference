package conference.dao;

import conference.dao.exception.AccountNotExistsException;
import conference.dao.utils.H2TestSupport;
import conference.dao.utils.TestSupport;
import conference.domain.Account;
import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

/**
 * Account DAO test.
 */
public class AccountDaoTest {
    private static TestSupport testSupport;
    private static AccountDao accountDao;

    @BeforeClass
    public static void start() {
        testSupport = new H2TestSupport();
        accountDao = new JdbcAccountDao(new JdbcTemplate(testSupport.getDataSource()));
    }

    @Before
    public void setUp() throws SQLException {
        testSupport.setUp();
    }

    @After
    public void tearDown() throws SQLException {
        testSupport.tearDown();
    }

    @AfterClass
    public static void stop() {
        testSupport.stop();
    }

    @Test
    public void addTest() throws AccountNotExistsException {
        accountDao.add("bnl", "qwerty");
        Account account = accountDao.findByUsername("bnl");

        Assert.assertEquals("bnl", account.getUserName());
        Assert.assertEquals("qwerty", account.getPassword());
    }

    @Test
    public void updateTest() throws AccountNotExistsException {
        accountDao.update("jsmith", "passwnew");
        Account account = accountDao.findByUsername("jsmith");

        Assert.assertEquals("jsmith", account.getUserName());
        Assert.assertEquals("passwnew", account.getPassword());
    }

    @Test(expected = AccountNotExistsException.class)
    public void deleteTest() throws AccountNotExistsException {
        accountDao.delete("jdoe");
        accountDao.findByUsername("jdoe");
    }

    @Test
    public void findByUsernameTest() throws AccountNotExistsException {
        Account account = accountDao.findByUsername("rroe");

        Assert.assertEquals("rroe", account.getUserName());
        Assert.assertEquals("password", account.getPassword());
    }
}