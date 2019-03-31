package book.store.admin.panel.service;

import book.store.admin.panel.model.Book;
import book.store.admin.panel.repository.BookRepository;
import book.store.admin.panel.repository.BookRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.getAllBook();
    }
}
