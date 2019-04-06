package book.store.admin.panel.controller;

import book.store.admin.panel.model.User;
import book.store.admin.panel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class NavigationController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String indexPage(){
        return "view/index";
    }

    @RequestMapping("/book")
    public String bookPage(){
        return "view/all-book";
    }

    @RequestMapping("/book-added")
    public String addBookPage(){
        return "view/add-book";
    }

    @RequestMapping("/blog")
    public String blogPage(){
        return "view/all-blog";
    }

    @RequestMapping("/blog-added")
    public String addBlogPage(){
        return "view/add-blog";
    }

    @RequestMapping("/user-active")
    public String activeUserPage(){
        return "view/active-user";
    }

    @RequestMapping("/login")
    public String loginPage(){
        return "view/login";
    }

    @RequestMapping("/inbox")
    public String inboxPage(){
        return "view/inbox";
    }

    @RequestMapping("/mail-compose")
    public String mailComposePage(){
        return "view/mail-compose";
    }

    @RequestMapping("/mail-view")
    public String mailViewPage(){
        return "view/mail-view";
    }

    @RequestMapping("/profile")
    public String proilePage(Model model){
        User userData = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUserByUsername(userData.getUsername());
        model.addAttribute("userData", user);
        return "view/profile";
    }

    @RequestMapping("/basic-table")
    public String basicTablePage(){
        return "view/basic_table";
    }

    @RequestMapping("/lock-screen")
    public String lockScreenPage(){
        return "view/lock-screen";
    }

    @RequestMapping("/font")
    public String fontPage(){
        return "view/font-awesome";
    }

    @RequestMapping("/maps")
    public String mapsPage(){
        return "view/google-maps";
    }

    @RequestMapping("/500")
    public String page500(){
        return "view/500";
    }

    @RequestMapping("/404")
    public String page404(){
        return "view/404";
    }








}
