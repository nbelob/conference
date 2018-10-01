package conference.dao;

import conference.dao.exception.AccountNotExistsException;
import conference.dao.exception.WrongPasswordException;
import conference.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * JDBC implementation of account DAO.
 */
@Repository
public class JdbcAccountDao implements AccountDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(String username, String password) {
        jdbcTemplate.update(
                "insert into account (username, password) " +
                        "values (?, ?)",
                username, password);
    }

    @Override
    public void update(String username, String password) {
        jdbcTemplate.update(
                "update account set password = ? where username = ?",
                password, username);
    }

    @Override
    public void delete(String username) {
        jdbcTemplate.update(
                "delete account where username = ?",
                username);
    }

    @Override
    public void login(String username, String password) throws AccountNotExistsException, WrongPasswordException {
        List<Account> accounts = jdbcTemplate.query(
                "select username, password from account where username = ?",
                new AccountRowMapper(),
                username);
        if (accounts.size() == 0) {
            throw new AccountNotExistsException();
        }

        if (!password.equals(accounts.get(0).getPassword())) {
            throw new WrongPasswordException();
        }
    }

    @Override
    public Account findByUsername(String username) throws AccountNotExistsException {
        try {
            return jdbcTemplate.queryForObject(
                    "select username, password from account where username = ?",
                    new AccountRowMapper(),
                    username);
        } catch (EmptyResultDataAccessException e) {
            throw new AccountNotExistsException();
        }
    }
}