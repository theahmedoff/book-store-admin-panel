package book.store.admin.panel.repository;

import book.store.admin.panel.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository {
    List<Book> getAllBook();
}
