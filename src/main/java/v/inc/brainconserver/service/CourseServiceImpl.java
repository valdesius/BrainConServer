package v.inc.brainconserver.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import v.inc.brainconserver.domain.Comment;
import v.inc.brainconserver.domain.Course;
import v.inc.brainconserver.domain.Mentor;
import v.inc.brainconserver.domain.Test;
import v.inc.brainconserver.repository.CommentRepository;
import v.inc.brainconserver.repository.CourseRepository;
import v.inc.brainconserver.repository.MentorRepository;
import v.inc.brainconserver.repository.TestRepository;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id: " + courseId));
    }

    @Override
    public List<Test> getTestsByCourseId(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id: " + courseId));
        return course.getTests();
    }

    @Override
    public List<Comment> getCommentsByCourseId(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id: " + courseId));
        return course.getComments();
    }
}