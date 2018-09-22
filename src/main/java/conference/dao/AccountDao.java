package conference.dao;

import conference.domain.Message;

import java.util.List;

/**
 * Account DAO.
 */
public interface AccountDao {
    void add(String username, String password);
    int find(String username, String password);
    List<Message> findAllByUsername(String username);
    void addMessage(String username, String text);
    void upd(String username, String password);
}
