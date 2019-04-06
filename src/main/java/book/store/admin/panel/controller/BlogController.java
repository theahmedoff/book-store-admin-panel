package book.store.admin.panel.controller;

import book.store.admin.panel.model.Blog;
import book.store.admin.panel.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.websocket.server.PathParam;
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

    @PostMapping("/blog/add-blog")
    public ResponseEntity addedBlog(@PathParam("titleBlog") String titleBlog,
                                    @PathParam("descBlog") String descBlog,
                                    @PathParam("imgBlog")String imgBlog){
        System.out.println(titleBlog);
        System.out.println(descBlog);
        System.out.println(imgBlog);
        return new ResponseEntity(HttpStatus.OK);
    }




}
