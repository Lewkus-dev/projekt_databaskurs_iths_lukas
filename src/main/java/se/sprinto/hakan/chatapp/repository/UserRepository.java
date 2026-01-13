package se.sprinto.hakan.chatapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.sprinto.hakan.chatapp.model.Message;
import se.sprinto.hakan.chatapp.model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.messages WHERE u.username = :username AND u.password = :password")
    User findByUsernameAndPassword(String username, String password);

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.messages WHERE u.username = :username AND u.password = :password")
    User login(@Param("username") String username, @Param("password") String password);

    @Query("SELECT e FROM User e LEFT JOIN FETCH e.messages WHERE e.id = :id")
    Optional<User> findUserMessagesById(@Param("id") Long id);
}

