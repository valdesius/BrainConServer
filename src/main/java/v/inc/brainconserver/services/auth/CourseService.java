package v.inc.brainconserver.services.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import v.inc.brainconserver.domain.Course;
import v.inc.brainconserver.dto.requests.CourseRequest;
import v.inc.brainconserver.repository.CourseRepository;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository repository;

    public Course createCourse(CourseRequest request) {
        Course course = Course.builder().title(request.getTitle()).build();
        return repository.save(course);
    }

    public void deleteCourse(int id){
        repository.deleteById(id);
    }
}
