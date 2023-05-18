package academy.kata.pp_312.dao;

import academy.kata.pp_312.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void update(User user);
    void remove(Long id);
    User getUserById(Long id);
    List<User> listUsers();
}
