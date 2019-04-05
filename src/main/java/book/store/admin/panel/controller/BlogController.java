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

public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blog/get-all-blog")
    @ResponseBody
    public List<Blog> getAllBlog(){
        List<Blog> blogs = blogService.getAllBlog();
//        System.out.println(blogs);
        return blogs;
    }




}
