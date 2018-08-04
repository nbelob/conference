package conference.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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

    }

    @Override
    public int find(String username, String password) {
        return 0;
    }
}
