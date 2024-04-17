package v.inc.brainconserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import v.inc.brainconserver.domain.Test;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    @Query("SELECT t FROM Test t WHERE t.course.id = :courseId")
    List<Test> findByCourseId(@Param("courseId") Long courseId);
}
