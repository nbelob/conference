package conference.dao;

import conference.dao.exception.AccountNotExistException;
import conference.domain.Message;

import java.util.List;

/**
 * Account DAO.
 */
public interface AccountDao {
    void add(String username, String password);

    void update(String username, String password);

    void delete(String username);

    int login(String username, String password);

    List<Message> findByUsername(String username);
}