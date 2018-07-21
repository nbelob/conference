package conference.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Map implementation of account DAO.
 */
@Repository
public class MapAccountDao implements AccountDao {
    private Map<String, String> accounts;

    @Autowired
    public MapAccountDao() {
        accounts = new HashMap<>();
        accounts.put("bnl", "pppppp");
        accounts.put("user", "passuser");
        accounts.put("mp", "passmp");
    }

    @Override
    public void add(String username, String password) {
        accounts.put(username, password);
    }

    @Override
    public boolean find(String username, String password) {
        if ((accounts.containsKey(username)) && (accounts.get(username).equals(password))) {
            return true;
        } else {
            return false;
        }
    }
}
