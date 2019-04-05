package book.store.admin.panel.service;

import book.store.admin.panel.model.User;
import book.store.admin.panel.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public List<User> getUserByStatus(int status) {
        System.out.println(userRepository.getUserByStatus(1));
        return userRepository.getUserByStatus(status);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(s);

        if (user == null){
            throw new UsernameNotFoundException(s);
        }

        return user;
    }



}
