package v.inc.brainconserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import v.inc.brainconserver.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
