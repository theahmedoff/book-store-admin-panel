package book.store.admin.panel.service;

import book.store.admin.panel.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> getAllBook();
}