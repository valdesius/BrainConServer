package v.inc.brainconserver.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import v.inc.brainconserver.domain.Course;
import v.inc.brainconserver.domain.Mentor;
import v.inc.brainconserver.domain.Test;
import v.inc.brainconserver.domain.User;
import v.inc.brainconserver.repository.CourseRepository;
import v.inc.brainconserver.repository.MentorRepository;
import v.inc.brainconserver.repository.TestRepository;

import java.util.List;

@Service
public class MentorServiceImpl implements MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TestRepository testRepository;

    @Override
    public Mentor createMentor(User user, String expertiseArea) {
        Mentor mentor = new Mentor();
        mentor.setUser(user);
        mentor.setExpertiseArea(expertiseArea);
        return mentorRepository.save(mentor);
    }

    @Override
    public List<Course> getCoursesInstructed(Long mentorId) {
        Mentor mentor = mentorRepository.findById(mentorId)
                .orElseThrow(() -> new EntityNotFoundException("Mentor not found with id: " + mentorId));
        return mentor.getCoursesInstructed();
    }

    @Override
    public Course createCourse(Long mentorId, String courseTitle) {
        Mentor mentor = mentorRepository.findById(mentorId)
                .orElseThrow(() -> new EntityNotFoundException("Mentor not found with id: " + mentorId));
        Course course = new Course();
        course.setTitle(courseTitle);
        course.setMentor(mentor);
        return courseRepository.save(course);
    }

    @Override
    public Test createTest(Long courseId, String testTitle) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id: " + courseId));
        Test test = new Test();
        test.setTitle(testTitle);
        test.setCourse(course);
        test.setCreatedByMentor(course.getMentor()); // Set the test's mentor to the course's mentor
        return testRepository.save(test);
    }
}