package v.inc.brainconserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import v.inc.brainconserver.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
