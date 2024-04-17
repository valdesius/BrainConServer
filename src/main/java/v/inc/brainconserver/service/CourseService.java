package v.inc.brainconserver.service;

import v.inc.brainconserver.domain.Comment;
import v.inc.brainconserver.domain.Course;
import v.inc.brainconserver.domain.Test;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course getCourseById(Long courseId);

    List<Test> getTestsByCourseId(Long courseId);

    List<Comment> getCommentsByCourseId(Long courseId);
}
