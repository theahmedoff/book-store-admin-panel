package book.store.admin.panel.controller;

import book.store.admin.panel.model.Blog;
import book.store.admin.panel.model.Book;
import book.store.admin.panel.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book/get-all-book")
    @ResponseBody
    public List<Book> getAllBooks(){
        List<Book> books = bookService.getAllBook();
        return books;
    }

    @RequestMapping("/book/delete/{id}")
    public ResponseEntity delete(@PathVariable("id")int id){
        bookService.deleteBook(id);
        return new ResponseEntity(HttpStatus.OK);
    }



}
