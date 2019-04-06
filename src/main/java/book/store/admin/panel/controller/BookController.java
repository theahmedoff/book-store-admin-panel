package book.store.admin.panel.controller;

import book.store.admin.panel.model.Author;
import book.store.admin.panel.model.Blog;
import book.store.admin.panel.model.Book;
import book.store.admin.panel.model.Stock;
import book.store.admin.panel.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
                                    @PathParam("authorNameBook")String authorNameBook,
                                    @PathParam("langBook") String langBook,
                                    @PathParam("priceBook") double priceBook,
                                    @PathParam("quantityBook")int quantityBook,
                                    @PathParam("discountBook") int discountBook,
                                    @PathParam("ageRangeBook")int ageRangeBook){
        Stock stock = new Stock();
        stock.setPrice(priceBook);
        stock.setQuantity(quantityBook);
        stock.setDiscount(discountBook);
        stock.setAgeRange(ageRangeBook);
        stock.setLastAddedDate(LocalDateTime.now());

        Book book = new Book();
        book.setTitle(titleBook);
        book.setDesc(descBook);
        book.setImagePath1(firstImgBook);
        book.setImagePath2(secondImgBook);
        book.setLanguage(langBook);
        book.setWriteDate(LocalDate.now());

        Author author = new Author();
        author.setFullName(authorNameBook);
        book.setAuthor(author);

        stock.setBook(book);

        System.out.println(stock);

        bookService.addBook(stock);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping("/book/delete/{id}")
    public ResponseEntity delete(@PathVariable("id")int id){
        bookService.deleteBook(id);
        return new ResponseEntity(HttpStatus.OK);
    }



}
