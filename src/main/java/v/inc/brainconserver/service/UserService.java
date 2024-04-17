package v.inc.brainconserver.service;

import v.inc.brainconserver.domain.User;

public interface UserService {
    User registerUser(User user);

    User loginUser(String username, String password);

    User getUserById(Long userId);
}
