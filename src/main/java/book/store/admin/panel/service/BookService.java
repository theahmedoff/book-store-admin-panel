package book.store.admin.panel.service;

import book.store.admin.panel.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> getAllBook();
    void addBook(Book book);
    void editBook(Book book);
    void deleteBook(int id);
}
