package conference.dao;

import conference.domain.Message;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageRowMapper implements RowMapper<Message> {
        @Override
        public Message mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Message(
                    resultSet.getString("username"),
                    resultSet.getString("text"),
                    resultSet.getDate("time"));
        }
}
