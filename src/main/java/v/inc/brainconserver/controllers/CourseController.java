package v.inc.brainconserver.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import v.inc.brainconserver.domain.Course;
import v.inc.brainconserver.dto.requests.CourseRequest;
import v.inc.brainconserver.services.auth.CourseService;

@RestController
@RequestMapping("/api/v1/auth/student/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService service;
    @PostMapping("/create")
    public ResponseEntity<Course> create(
            @RequestBody CourseRequest request
    ) {
        return ResponseEntity.ok(service.createCourse(request));
    }

    @DeleteMapping("/delete")
    public void deleteCourse(int id){
        service.deleteCourse(id);
    }
}
