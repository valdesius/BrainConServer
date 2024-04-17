package v.inc.brainconserver.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import v.inc.brainconserver.domain.Comment;
import v.inc.brainconserver.domain.Course;
import v.inc.brainconserver.repository.CommentRepository;
import v.inc.brainconserver.repository.CourseRepository;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addCommentToCourse(Long courseId, Comment comment) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id: " + courseId));

        comment.setCourse(course);
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsByCourseId(Long courseId) {
        return commentRepository.findByCourseId(courseId);
    }
}
