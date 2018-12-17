package conference.dao;

import conference.dao.exception.AccountNotExistsException;
import conference.domain.Account;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * Account DAO test.
 */
public class AccountDaoTest {
    private static AccountDao accountDao;

    @BeforeClass
    public static void start() {
        accountDao = new JdbcAccountDao(new JdbcTemplate(
                new EmbeddedDatabaseBuilder()
                        .setType(EmbeddedDatabaseType.H2)
                        .addScript("schema.sql")
                        .addScript("data.sql")
                        .build()
        ));
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