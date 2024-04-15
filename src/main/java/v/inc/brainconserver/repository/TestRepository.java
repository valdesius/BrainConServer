package v.inc.brainconserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import v.inc.brainconserver.domain.Test;

public interface TestRepository extends JpaRepository<Test, Long> {
}
