package v.inc.brainconserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import v.inc.brainconserver.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
