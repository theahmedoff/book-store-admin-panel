package book.store.admin.panel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController {

    @RequestMapping("/")
    public String indexPage(){
        return "view/404";
    }

    @RequestMapping("/home")
    public String homePage(){
        return "view/blank";
    }

    @RequestMapping("/login")
    public String loginPage(){
        return "view/login";
    }

    @RequestMapping("/500")
    public String Page500(){
        return "view/500";
    }

    @RequestMapping("active-topics")
    public String activeTopicsPage() {
        return "view/active-topics";
    }
}
