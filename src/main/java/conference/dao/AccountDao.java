package conference.dao;

/**
 * Account DAO.
 */
public interface AccountDao {
    void add(String username, String password);
    boolean find(String username, String password);
}
