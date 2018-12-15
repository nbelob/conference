package conference.dao;

import org.junit.Assert;
import org.junit.Test;

/**
 * Message DAO test.
 */
public class MessageDaoTest {
    private static MessageDao messageDao;

    @Test
    public void addTest() {
        messageDao.add("jsmith", "Mess");
        Assert.assertEquals("jsmith", messageDao.findAll().get(messageDao.findAll().size() - 1).getUserName());
        Assert.assertEquals("Mess", messageDao.findAll().get(messageDao.findAll().size() - 1).getText());
    }

    @Test
    public void findAllTest() {
        int i = messageDao.findAll().size();
        messageDao.add("jsmith", "Mess1");
        Assert.assertEquals(i + 1, messageDao.findAll().size());
    }
}