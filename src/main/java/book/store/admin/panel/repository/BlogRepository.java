package book.store.admin.panel.repository;

import book.store.admin.panel.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository {

    List<Blog> getAllBlog();

}