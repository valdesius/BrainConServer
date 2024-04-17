package v.inc.brainconserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import v.inc.brainconserver.domain.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
