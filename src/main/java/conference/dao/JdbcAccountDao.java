package conference.dao;

import conference.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
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
    public int find(String username, String password) {
        List<Account> accounts;
        accounts = jdbcTemplate.query(
                "select username, password from account where username = ?",
                new AccountRowMapper(),
                username);
        if (accounts.size() == 0) {
            return 1;
        } else {
            accounts = jdbcTemplate.query(
                    "select username, password from account where username = ? and password = ?",
                    new AccountRowMapper(),
                    username, password);
            if (accounts.size() == 0) {
                return 2;
            } else {
                return 0;
            }
        }
    }
}
