package book.store.admin.panel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController {

    @RequestMapping("/")
    public String indexPage(){
        return "view/index";
    }

    @RequestMapping("/all-book")
    public String blankPage(){
        return "view/all-book";
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
    public String proilePage(){
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
