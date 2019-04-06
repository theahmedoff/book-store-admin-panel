package book.store.admin.panel.repository;

import book.store.admin.panel.model.Book;
import book.store.admin.panel.model.Stock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository {
    List<Book> getAllBook();
    void addBook(Stock stock);
    void editBook(Book book);
    void deleteBook(int id);
}
