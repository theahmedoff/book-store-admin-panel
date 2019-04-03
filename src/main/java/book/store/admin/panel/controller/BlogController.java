package book.store.admin.panel.controller;

import book.store.admin.panel.model.Blog;
import book.store.admin.panel.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/get-all-blog")
    @ResponseBody
    public String getAllBlog(Model model){
        List<Blog> blogs = blogService.getAllBlog();
        model.addAttribute("blogs", blogs);
        System.out.println(blogs);
        return "fragment/blog-content";
    }

}
