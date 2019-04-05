package book.store.admin.panel.repository;


import book.store.admin.panel.model.User;

import java.util.List;

public interface UserRepository {

    List<User> getAllUser();
    User getUserByUsername(String username);
    List<User> getUserByStatus(int status);

}
