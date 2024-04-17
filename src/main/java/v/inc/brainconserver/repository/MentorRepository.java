package v.inc.brainconserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import v.inc.brainconserver.domain.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
}
