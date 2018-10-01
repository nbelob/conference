package conference.dao;

import conference.domain.Message;

import java.util.List;

/**
 * Message DAO.
 */
public interface MessageDao {
    void add(String username, String text);

    List<Message> findByUsername(String username);
}