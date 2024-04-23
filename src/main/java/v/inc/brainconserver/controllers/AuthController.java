package v.inc.brainconserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import v.inc.brainconserver.dto.requests.LoginRequest;
import v.inc.brainconserver.dto.responses.AuthResponse;
import v.inc.brainconserver.services.JwtTokenService;
import v.inc.brainconserver.services.auth.MyCustomUserDetailService;
import v.inc.brainconserver.services.auth.MyCustomUserDetails;
import v.inc.brainconserver.services.auth.UserService;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;

    @Autowired
    private MyCustomUserDetailService myCustomUserDetailService;
    @Autowired
    private JwtTokenService jwtTokenService;

    @PostMapping("/authenticate")
    public ResponseEntity signIn(@RequestBody LoginRequest loginRequest){
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        MyCustomUserDetails userDetails =
                (MyCustomUserDetails) myCustomUserDetailService.loadUserByUsername(loginRequest.getEmail());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenService.generateToken(userDetails);

        AuthResponse response = new AuthResponse(token, userDetails);

        return new ResponseEntity(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/register")
    public ResponseEntity signUp(@RequestParam("first_name") String firstName,
                                 @RequestParam("last_name") String lastName,
                                 @RequestParam("email") String email,
                                 @RequestParam("password") String password){

        // TODO: VALIDATE IF EMAIL IS NOT ALREADY TAKEN.

        String hashed_password = passwordEncoder.encode(password);

        int result = userService.signUpUser(firstName,lastName,email, hashed_password);
        if(result != 1){
            return new ResponseEntity("Something went wrong", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("User Sign Up Successful!", HttpStatus.CREATED);
    }
}
