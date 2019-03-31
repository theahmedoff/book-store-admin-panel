package book.store.admin.panel.repository;


import book.store.admin.panel.model.Role;
import book.store.admin.panel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_USER_BY_USERNAME_SQL = "select * from user u inner join role r on u.id_role = r.id_role left join wishlist w on u.id_user = w.id_user where u.username = ?";


    @Override
    public User getUserByUsername(String username) {
        List<User> list = jdbcTemplate.query(GET_USER_BY_USERNAME_SQL, new Object[]{username}, new ResultSetExtractor<List<User>>() {
            @Override
            public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
                Map<Integer, User> map = new HashMap<>();

                while (rs.next()) {
                    User user = map.get(rs.getInt("u.id_user"));

                    if (user == null) {
                        user = new User();
                        user.setIdUser(rs.getInt("u.id_user"));
                        user.setName(rs.getString("u.name"));
                        user.setSurname(rs.getString("u.surname"));
                        user.setUsername(rs.getString("u.username"));
                        user.setEmail(rs.getString("u.email"));
                        user.setPassword(rs.getString("u.password"));
                        user.setStatus(rs.getInt("u.status"));

                        Role role = new Role();
                        role.setIdRole(rs.getInt("r.id_role"));
                        role.setRoleType(rs.getString("r.role_type"));
                        user.setRole(role);

                        map.put(user.getIdUser(), user);
                    }
                }
                return new ArrayList<>(map.values());
            }
        });
        return list.get(0);
    }
}
