package v.inc.brainconserver.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")

public class StudentController {
    @GetMapping
    public String get() {
        return "GET:: student controller";
    }
    @PostMapping
    public String post() {
        return "POST:: student controller";
    }
    @PutMapping
    public String put() {
        return "PUT:: student controller";
    }
    @DeleteMapping
    public String delete() {
        return "DELETE:: student controller";
    }
}
