package v.inc.brainconserver.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import v.inc.brainconserver.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT email FROM main.users WHERE email = :email", nativeQuery = true)
    List<String> doesEmailExist(@Param("email")String email);

    @Query(value = "SELECT * FROM main.users WHERE email = :email", nativeQuery = true)
    User getUserByEmail(@Param("email")String email);

    @Query(value = "SELECT id FROM main.users WHERE email = :email ", nativeQuery = true)
    int getUserIdByEmail(@Param("email") String email);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO main.users (first_name, last_name, email, password) VALUES (:first_name, :last_name, :email, :password)", nativeQuery = true)
    int signUpUser(@Param("first_name")String first_name, @Param("last_name")String last_name, @Param("email")String email, @Param("password")String password);
}
