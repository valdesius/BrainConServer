package v.inc.brainconserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import v.inc.brainconserver.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
