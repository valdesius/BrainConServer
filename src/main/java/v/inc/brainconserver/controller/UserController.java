package v.inc.brainconserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import v.inc.brainconserver.domain.User;
import v.inc.brainconserver.repository.UserRepository;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserRepository repository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String guestAccess() {
        return "Guest on page ";
    }

    @PostMapping("/user/create")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User result = repository.save(user);

        if (result.getId() > 0) {
            return ResponseEntity.ok("User was created");
        }
        return ResponseEntity.status(404).body("User not created");
    }
}
