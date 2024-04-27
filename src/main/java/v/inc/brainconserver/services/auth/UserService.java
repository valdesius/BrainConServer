package v.inc.brainconserver.services.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import v.inc.brainconserver.domain.Role;
import v.inc.brainconserver.domain.User;
import v.inc.brainconserver.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



    public List<String> doesEmailExist(String email){
        return userRepository.doesEmailExist(email);
    }

    public int signUpUser(String first_name, String last_name, String email, String password, Role role){
        return userRepository.signUpUser(first_name, last_name, email, password, role);
    }

}