package book.store.admin.panel.repository;

import book.store.admin.panel.model.Blog;
import book.store.admin.panel.model.User;
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
public class BlogRepositoryImpl implements BlogRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //Sql Sorgular
    private static final String GET_ALL_BLOG_SQL = "select b.id_blog, b.title, b.desc, b.share_date, b.image_path, u.id_user, u.username from blog b inner join user u on b.id_user = u.id_user";

    @Override
    public List<Blog> getAllBlog() {
        List<Blog> blogs = jdbcTemplate.query(GET_ALL_BLOG_SQL, new Object[]{}, new ResultSetExtractor<List<Blog>>() {
            @Nullable
            @Override
            public List<Blog> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Blog> list = new ArrayList<>();
                while (rs.next()){
                    Blog blog = new Blog();
                    blog.setId(rs.getInt("id_blog"));
                    blog.setTitle(rs.getString("title"));
                    blog.setDesc(rs.getString("desc"));
                    blog.setShareDate(rs.getTimestamp("share_date").toLocalDateTime());
                    blog.setImagePath(rs.getString("image_path"));
                    User user = new User();
                    user.setIdUser(rs.getInt("id_user"));
                    user.setUsername(rs.getString("username"));
                    blog.setUser(user);
                    list.add(blog);
                }
                return list;
            }
        });
        return blogs;
    }
}
