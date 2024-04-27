package v.inc.brainconserver.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import v.inc.brainconserver.domain.Role;
import v.inc.brainconserver.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "SELECT email FROM test.public.users WHERE email = :email", nativeQuery = true)
    List<String> doesEmailExist(@Param("email")String email);

    @Query(value = "SELECT * FROM test.public.users WHERE email = :email", nativeQuery = true)
    Optional<User> getUserByEmail(@Param("email")String email);

    @Query(value = "SELECT user_id FROM test.public.users WHERE email = :email ", nativeQuery = true)
    int getUserIdByEmail(@Param("email") String email);
    Optional<User> findByEmail(String email);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO  test.public.users(first_name, last_name, email, password, role) VALUES (:first_name, :last_name, :email, :password, :role)", nativeQuery = true)
    int signUpUser(@Param("first_name")String first_name, @Param("last_name")String last_name, @Param("email")String email, @Param("password")String password, @Param("role")Role role);
}
