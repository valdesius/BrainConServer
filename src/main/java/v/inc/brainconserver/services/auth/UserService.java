package v.inc.brainconserver.services.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import v.inc.brainconserver.domain.User;
import v.inc.brainconserver.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User loadUserByEmail(String email){
        return userRepository.getUserByEmail(email);
    }

    public List<String> doesEmailExist(String email){
        return userRepository.doesEmailExist(email);
    }

    public int signUpUser(String first_name, String last_name, String email, String password){
        return userRepository.signUpUser(first_name, last_name, email, password);
    }

}