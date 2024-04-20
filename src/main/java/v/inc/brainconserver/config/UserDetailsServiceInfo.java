package v.inc.brainconserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import v.inc.brainconserver.domain.User;
import v.inc.brainconserver.repository.UserRepository;

import java.util.Optional;
@Configuration
public class UserDetailsServiceInfo implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByEmail(username);
        return user.map(UserDetailsInfo::new).orElseThrow(()->new UsernameNotFoundException("User Does Not Exist"));
    }
}
