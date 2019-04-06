package book.store.admin.panel.repository;

import book.store.admin.panel.model.Author;
import book.store.admin.panel.model.Book;
import book.store.admin.panel.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_ALL_BOOK_SQL = "select b.id_book, b.first_image_path, b.second_image_path, b.desc, b.title, b.write_date, b.language, a.id_author, a.full_name from book b inner join author a on b.id_author = a.id_author";
    private static final String SET_BOOK_SQL = "insert into book(title, `desc`, first_image_path, second_image_path, language, write_date, id_author) values(?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE_BOOK_BY_ID_SQL = "delete from book where id_book = ?";
    private static final String SET_STOCK_SQL = "INSERT INTO stock(quantity, price, discount, age_range, last_added_date, id_book) VALUES(?,?,?,?,?,?)";
    private static final String SET_AUTHOR_SQL = "INSERT INTO author(full_name) VALUES(?)";


    @Override
    public List<Book> getAllBook() {
        List<Book> books = jdbcTemplate.query(GET_ALL_BOOK_SQL, new Object[]{}, new ResultSetExtractor<List<Book>>() {
            @Nullable
            @Override
            public List<Book> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Book> list = new ArrayList<>();
                while (rs.next()){
                    Book book = new Book();
                    book.setIdBook(rs.getInt("id_book"));
                    book.setImagePath1(rs.getString("first_image_path"));
                    book.setImagePath2(rs.getString("second_image_path"));
                    book.setLanguage(rs.getString("language"));
                    book.setDesc(rs.getString("desc"));
                    book.setTitle(rs.getString("title"));
                    book.setWriteDate(rs.getDate("write_date").toLocalDate());

                    Author author = new Author();
                    author.setIdAuthor(rs.getInt("id_author"));
                    author.setFullName(rs.getString("full_name"));
                    book.setAuthor(author);

                    list.add(book);
                }
                return list;
            }
        });
        return books;
    }

    @Override
    public void addBook(Stock stock) {
//        jdbcTemplate.update(SET_AUTHOR_SQL, stock.getBook().getAuthor().getFullName());
        KeyHolder keyAuthor = new GeneratedKeyHolder();
        KeyHolder keyBook = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(SET_AUTHOR_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, stock.getBook().getAuthor().getFullName());
            return ps;
        }, keyAuthor);

//        jdbcTemplate.update(SET_BOOK_SQL, stock.getBook().getTitle(), stock.getBook().getDesc(), stock.getBook().getImagePath1(), stock.getBook().getImagePath2(), stock.getBook().getLanguage(), stock.getBook().getWriteDate().toString(), keyAuthor.getKey().intValue());
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(SET_BOOK_SQL,  Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, stock.getBook().getTitle());
            ps.setString(2, stock.getBook().getDesc());
            ps.setString(3, stock.getBook().getImagePath1());
            ps.setString(4, stock.getBook().getImagePath2());
            ps.setString(5, stock.getBook().getLanguage());
            ps.setString(6, stock.getBook().getWriteDate().toString());
            ps.setInt(7, keyAuthor.getKey().intValue());
            return ps;
        }, keyBook);
//        jdbcTemplate.update(SET_STOCK_SQL, stock.getQuantity(), stock.getPrice(), stock.getDiscount(), stock.getAgeRange(), stock.getLastAddedDate().toString(), )
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(SET_STOCK_SQL,  Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, stock.getQuantity());
            ps.setDouble(2, stock.getPrice());
            ps.setInt(3, stock.getDiscount());
            ps.setInt(4, stock.getAgeRange());
            ps.setString(5, stock.getLastAddedDate().toString());
            ps.setInt(6, keyBook.getKey().intValue());
            return ps;
        }, keyBook);

        System.out.println("author id: " + keyAuthor);
        System.out.println("book id: " + keyBook);
    }

    @Override
    public void editBook(Book book) {
        
    }

    @Override
    public void deleteBook(int id) {
        jdbcTemplate.update(DELETE_BOOK_BY_ID_SQL, id);
    }
}
