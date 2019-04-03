package book.store.admin.panel.service;

import book.store.admin.panel.model.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogService {
    List<Blog> getAllBlog();
}
