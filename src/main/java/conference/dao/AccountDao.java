package conference.dao;

import conference.dao.exception.AccountNotExistsException;
import conference.domain.Account;

/**
 * Account DAO.
 */
public interface AccountDao {
    void add(String username, String password);

    void update(String username, String password);

    void delete(String username);

    Account findByUsername(String username) throws AccountNotExistsException;
}