package book.store.admin.panel.service;

import book.store.admin.panel.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {

    List<User> getAllUser();
    User getUserByUsername(String username);
    List<User> getUserByStatus(int status);

    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

}
