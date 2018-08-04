package conference.dao;

/**
 * Account DAO.
 */
public interface AccountDao {
    void add(String username, String password);
    int find(String username, String password);
}
