package v.inc.brainconserver.service;

import v.inc.brainconserver.domain.User;

import java.util.List;

public interface UserService {
    User loadUserByEmail(String email);
    List<String> doesEmailExist(String email);

    int signUpUser(String first_name, String last_name, String email, String password);

}
