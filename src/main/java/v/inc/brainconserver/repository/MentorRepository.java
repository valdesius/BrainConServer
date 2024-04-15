package v.inc.brainconserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import v.inc.brainconserver.domain.Mentor;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
}
