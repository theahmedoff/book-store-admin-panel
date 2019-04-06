package book.store.admin.panel.repository;


import book.store.admin.panel.model.Role;
import book.store.admin.panel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_USER_BY_USERNAME_SQL = "select u.id_user, u.name, u.surname, u.password, u.username, u.email, u.status, r.id_role, r.role_type from user u inner join role r on u.id_role = r.id_role where u.username = ?";
    private static final String GET_USER_BY_STATUS_SQL = "select u.id_user, u.name, u.surname, u.username, u.email, u.status, r.id_role, r.role_type from user u inner join role r on u.id_role = r.id_role where u.status = ?";
    private static final String GET_ALL_USER_SQL = "select u.id_user, u.name, u.surname, u.username, u.email, u.status, r.id_role, r.role_type from user u inner join role r on u.id_role = r.id_role";

    @Override
    public List<User> getAllUser() {
        List<User> users = jdbcTemplate.query(GET_ALL_USER_SQL, new Object[]{}, new ResultSetExtractor<List<User>>() {
            @Nullable
            @Override
            public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<User> list = new ArrayList<>();
                while (rs.next()) {
                    User user = new User();
                    user.setIdUser(rs.getInt("id_user"));
                    user.setName(rs.getString("name"));
                    user.setSurname(rs.getString("surname"));
                    user.setUsername(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    user.setStatus(rs.getInt("status"));
                    user.setPassword(rs.getString("password"));

                    Role role = new Role();
                    role.setIdRole(rs.getInt("id_role"));
                    role.setRoleType(rs.getString("role_type"));
                    user.setRole(role);

                    list.add(user);
                }
                return list;
            }
        });
        System.out.println("User---------------");
        System.out.println(users);
        return users;
    }

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
                        user.setStatus(rs.getInt("u.status"));
                        user.setPassword(rs.getString("u.password"));

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

    @Override
    public List<User> getUserByStatus(int status) {
        List<User> users = jdbcTemplate.query(GET_USER_BY_STATUS_SQL, new Object[]{status}, new ResultSetExtractor<List<User>>() {
            @Nullable
            @Override
            public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<User> list = new ArrayList<>();
                while (rs.next()) {
                    User user = new User();
                    user.setIdUser(rs.getInt("id_user"));
                    user.setName(rs.getString("name"));
                    user.setSurname(rs.getString("surname"));
                    user.setUsername(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    user.setStatus(rs.getInt("status"));

                    Role role = new Role();
                    role.setIdRole(rs.getInt("id_role"));
                    role.setRoleType(rs.getString("role_type"));
                    user.setRole(role);

                    list.add(user);
                }
                return list;
            }
        });
        System.out.println("User---------------");
        System.out.println(users);
        return users;
    }
}
