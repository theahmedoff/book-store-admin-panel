package book.store.admin.panel.service;

import book.store.admin.panel.model.Blog;
import book.store.admin.panel.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    private BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    @Override
    public List<Blog> getAllBlog() {
        System.out.println(blogRepository.getAllBlog());
        return blogRepository.getAllBlog();
    }

    @Override
    public void addBlog(Blog blog) {
        blogRepository.addBlog(blog);
    }
}
