package conference.dao;

import conference.dao.utils.H2TestSupport;
import conference.dao.utils.TestSupport;
import conference.domain.Message;
import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;

/**
 * Message DAO test.
 */
public class MessageDaoTest {
    private static TestSupport testSupport;
    private static MessageDao messageDao;

    @BeforeClass
    public static void start() {
        testSupport = new H2TestSupport();
        messageDao = new JdbcMessageDao(new JdbcTemplate(testSupport.getDataSource()));
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
    public void addTest() {
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
        List<Message> messages = messageDao.findAll();

        Assert.assertEquals(3, messages.size());
        Assert.assertEquals("jsmith",
                messages.get(0).getUserName());
        Assert.assertEquals("Some people care too much. I think it's called love.",
                messages.get(0).getText());
        Assert.assertEquals("jsmith",
                messages.get(1).getUserName());
        Assert.assertEquals("You can't stay in your corner of the Forest waiting for others to come to you. You have to go to them sometimes.",
                messages.get(1).getText());
        Assert.assertEquals("jsmith",
                messages.get(2).getUserName());
        Assert.assertEquals("It is more fun to talk with someone who doesn't use long, difficult words but rather short, easy words like \"What about lunch?\"",
                messages.get(2).getText());
    }
}