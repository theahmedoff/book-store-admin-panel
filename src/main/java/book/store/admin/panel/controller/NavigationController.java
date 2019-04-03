package book.store.admin.panel.controller;

import book.store.admin.panel.model.Blog;
import book.store.admin.panel.model.Book;
import book.store.admin.panel.model.User;
import book.store.admin.panel.service.BlogService;
import book.store.admin.panel.service.BookService;
import book.store.admin.panel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.plugin.liveconnect.SecurityContextHelper;

import java.util.List;

@Controller
public class NavigationController {

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private BlogService blogService;

    @RequestMapping("/")
    public String indexPage(){
        return "view/index";
    }

    @RequestMapping("/all-book")
    public String allBookPage(Model model){
        List<Book> books = bookService.getAllBook();
        model.addAttribute("books", books);
        return "view/all-book";
    }

    @RequestMapping("/all-blog")
    public String allBlogPage(Model model){
        List<Blog> blogs = blogService.getAllBlog();
        System.out.println(blogs);
        model.addAttribute("blogs", blogs);
        return "view/all-blog";
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
