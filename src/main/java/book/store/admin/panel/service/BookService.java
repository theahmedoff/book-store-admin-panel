package book.store.admin.panel.service;

import book.store.admin.panel.model.Book;
import book.store.admin.panel.model.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> getAllBook();
    void addBook(Stock stock);
    void editBook(Book book);
    void deleteBook(int id);
}
