package book.store.admin.panel.controller;

import book.store.admin.panel.model.Blog;
import book.store.admin.panel.model.Book;
import book.store.admin.panel.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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

    @PostMapping("/book/add-book")
    public ResponseEntity addedBlog(@PathParam("titleBook") String titleBook,
                                    @PathParam("descBook") String descBook,
                                    @PathParam("firstImgBook")String firstImgBook,
                                    @PathParam("secondImgBook") String secondImgBook,
                                    @PathParam("authorIdBook")String authorIdBook){
        System.out.println(titleBook);
        System.out.println(descBook);
        System.out.println(firstImgBook);
        System.out.println(secondImgBook);
        System.out.println(authorIdBook);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping("/book/delete/{id}")
    public ResponseEntity delete(@PathVariable("id")int id){
        bookService.deleteBook(id);
        return new ResponseEntity(HttpStatus.OK);
    }



}
