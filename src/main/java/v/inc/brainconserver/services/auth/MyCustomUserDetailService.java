package v.inc.brainconserver.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import v.inc.brainconserver.domain.User;

@Service
public class MyCustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.loadUserByEmail(username);

        if(user == null){
           throw new UsernameNotFoundException("Unable To Load User");
        }
        return new MyCustomUserDetails(user);
    }
}
