package book.store.admin.panel.controller;

import book.store.admin.panel.model.User;
import book.store.admin.panel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/get-user-by-status")
    public List<User> getUserByStatus(){
        List<User> users = userService.getUserByStatus(1);
        System.out.println(users);
        return users;
    }

    @GetMapping("/get-all-users")
    public List<User> getAllUser(){
        List<User> users = userService.getAllUser();
        System.out.println(users);
        return users;
    }

}
