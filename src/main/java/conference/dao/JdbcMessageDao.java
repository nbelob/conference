package conference.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * JDBC implementation of message DAO.
 */
@Repository
public class JdbcMessageDao implements MessageDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcMessageDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(String username, String text) {
        jdbcTemplate.update(
                "insert into message (username, text, time) " +
                        "values (?, ?, sysdate)",
                username, text);
    }
}