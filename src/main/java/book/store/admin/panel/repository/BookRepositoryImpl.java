package book.store.admin.panel.repository;

import book.store.admin.panel.model.Author;
import book.store.admin.panel.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_ALL_BOOK_SQL = "select b.id_book, b.first_image_path, b.second_image_path, b.desc, b.title, b.write_date, b.language, a.id_author, a.full_name from book b inner join author a on b.id_author = a.id_author";
    private static final String SET_BOOK_SQL = "insert into book(title, description, first_image_path, second_image_path, language, write_date, id_author) values(?, ?, ?, ?, ?, ?, ?)";

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
        System.out.println(books);
        return books;
    }

    @Override
    public void addBook(Book book) {
        jdbcTemplate.update(SET_BOOK_SQL, book.getTitle(), book.getDesc(), book.getImagePath1(), book.getImagePath2(), book.getLanguage(), book.getWriteDate().toString(), book.getAuthor().getIdAuthor());
    }

    @Override
    public void editBook(Book book) {
        
    }
}
