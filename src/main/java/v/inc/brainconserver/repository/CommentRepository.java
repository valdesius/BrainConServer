package v.inc.brainconserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import v.inc.brainconserver.domain.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByCourseId(Long courseId);
}
