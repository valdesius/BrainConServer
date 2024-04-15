package v.inc.brainconserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import v.inc.brainconserver.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
