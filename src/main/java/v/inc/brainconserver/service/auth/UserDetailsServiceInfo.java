package v.inc.brainconserver.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import v.inc.brainconserver.domain.User;
import v.inc.brainconserver.service.UserService;

import java.util.Optional;
@Configuration
public class UserDetailsServiceInfo implements UserDetailsService {
    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.loadUserByEmail(username);

        if(user == null){
            throw new UsernameNotFoundException("Unable To Load User");
        }
        return new UserDetailsInfo(user);
    }
}
