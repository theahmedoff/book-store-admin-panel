package book.store.admin.panel.controller;

import book.store.admin.panel.model.Blog;
import book.store.admin.panel.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/get-all-blog")
    @ResponseBody
    public String getAllBlog(Model model){
        List<Blog> blogs = blogService.getAllBlog();
        model.addAttribute("blogs", blogs);
//        System.out.println(blogs);
        return "view/all-blog";
    }

    @PostMapping("/add-blog")
    public String addBlog(@ModelAttribute("newBlog")Blog blog, RedirectAttributes redirectAttributes){

        System.out.println(blog);

        return "redirect:/blog";
    }



}
