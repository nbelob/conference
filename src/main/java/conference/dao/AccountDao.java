package conference.dao;

import conference.dao.exception.AccountNotExistsException;
import conference.dao.exception.WrongPasswordException;
import conference.domain.Account;

/**
 * Account DAO.
 */
public interface AccountDao {
    void add(String username, String password);

    void update(String username, String password);

    void delete(String username);

    void login(String username, String password) throws AccountNotExistsException, WrongPasswordException;

    Account findByUsername(String username) throws AccountNotExistsException;
}