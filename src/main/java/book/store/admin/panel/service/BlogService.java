package book.store.admin.panel.service;

import book.store.admin.panel.model.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogService {
    List<Blog> getAllBlog();
    void addBlog(Blog blog);
    void editBlogById(Blog blog);
    void deleteBlogById(int id);
}
