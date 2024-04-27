package v.inc.brainconserver.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/mentor")
@PreAuthorize("hasRole('MENTOR')")
public class MentorController {
    @GetMapping
    @PreAuthorize("hasAuthority('mentor:read')")
    public String get() {
        return "GET:: mentor controller";
    }
    @PostMapping
    @PreAuthorize("hasAuthority('mentor:create')")
    public String post() {
        return "POST:: mentor controller";
    }
    @PutMapping
    @PreAuthorize("hasAuthority('mentor:update')")
    public String put() {
        return "PUT:: mentor controller";
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('mentor:delete')")
    public String delete() {
        return "DELETE:: mentor controller";
    }
}
