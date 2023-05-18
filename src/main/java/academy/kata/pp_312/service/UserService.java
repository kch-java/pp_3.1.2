package academy.kata.pp_312.service;

import academy.kata.pp_312.model.User;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService {
    void add(User user);
    void update(@Valid User user);
    void remove(Long id);
    User getUserById(Long id);
    List<User> listUsers();
}
