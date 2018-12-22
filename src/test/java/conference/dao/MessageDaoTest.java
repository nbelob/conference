package conference.dao;

import conference.domain.Message;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.List;

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
/*        messageDao.add("jsmith", "Mess");
        Assert.assertEquals("jsmith", messageDao.findAll().get(0).getUserName());
        Assert.assertEquals("Mess", messageDao.findAll().get(0).getText());*/
        messageDao.add("jsmith", "Mess");
        List<Message> messages = messageDao.findAll();
        Assert.assertEquals(4, messages.size());
        Assert.assertEquals("jsmith",
                messages.get(0).getUserName());
        Assert.assertEquals("Mess",
                messages.get(0).getText());
    }

    @Test
    public void findAllTest() {
/*        int i = messageDao.findAll().size();
        messageDao.add("jsmith", "Mess1");
        Assert.assertEquals(i + 1, messageDao.findAll().size());*/
        messageDao = new JdbcMessageDao(new JdbcTemplate(
                new EmbeddedDatabaseBuilder()
                        .setType(EmbeddedDatabaseType.H2)
                        .addScripts("clean.sql", "schema.sql", "data.sql")
                        .build()
        ));

        List<Message> messages = messageDao.findAll();

        Assert.assertEquals(3, messages.size());

        Assert.assertEquals("jsmith",
                messages.get(0).getUserName());
        Assert.assertEquals("Some people care too much. I think it's called love.",
                messages.get(0).getText());
    }

}