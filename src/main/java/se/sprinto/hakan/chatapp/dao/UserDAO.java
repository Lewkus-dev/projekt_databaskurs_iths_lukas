package se.sprinto.hakan.chatapp.dao;

import org.springframework.data.jpa.repository.Query;
import se.sprinto.hakan.chatapp.model.User;

public interface UserDAO {
    @Query("SELECT e FROM User e LEFT JOIN FETCH e.messages WHERE e.username = :username AND e.password = :password")
    User login(String username, String password);

    User register(User user);
}
