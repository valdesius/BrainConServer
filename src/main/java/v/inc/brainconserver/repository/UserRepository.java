package v.inc.brainconserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import v.inc.brainconserver.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from users where email = ?1", nativeQuery = true)
    Optional<User> findByEmail(String email);
}
