package book.store.admin.panel.service;

import book.store.admin.panel.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {

    User getUserByUsername(String username);

    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

}
