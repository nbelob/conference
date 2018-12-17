package conference.dao;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * Message DAO test.
 */
public class MessageDaoTest {
    private static MessageDao messageDao;

    @BeforeClass
    public static void start() {
        messageDao = new JdbcMessageDao(new JdbcTemplate(
                new EmbeddedDatabaseBuilder()
                        .setType(EmbeddedDatabaseType.H2)
                        .addScripts("schema.sql", "data.sql")
                        .build()
        ));
    }

    @Test
    public void addTest() {
        messageDao.add("jsmith", "Mess");
        Assert.assertEquals("jsmith", messageDao.findAll().get(0).getUserName());
        Assert.assertEquals("Mess", messageDao.findAll().get(0).getText());
    }

    @Test
    public void findAllTest() {
        int i = messageDao.findAll().size();
        messageDao.add("jsmith", "Mess1");
        Assert.assertEquals(i + 1, messageDao.findAll().size());
    }
}