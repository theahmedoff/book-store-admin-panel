package book.store.admin.panel.repository;


import book.store.admin.panel.model.User;

public interface UserRepository {

    User getUserByUsername(String username);
}
