package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.User;

import java.util.List;

// Interface for entity of database  user
public interface UserService {
    User get(long userId);
    void save(User user);
    void update(User user);
    void delete(long userId);
    List<User> getAll();
}
