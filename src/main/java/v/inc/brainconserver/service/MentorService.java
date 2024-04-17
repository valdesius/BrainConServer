package v.inc.brainconserver.service;

import v.inc.brainconserver.domain.Course;
import v.inc.brainconserver.domain.Mentor;
import v.inc.brainconserver.domain.Test;
import v.inc.brainconserver.domain.User;

import java.util.List;

public interface MentorService {
    Mentor createMentor(User user, String expertiseArea);

    List<Course> getCoursesInstructed(Long mentorId);

    Course createCourse(Long mentorId, String courseTitle);

    Test createTest(Long courseId, String testTitle);
}
