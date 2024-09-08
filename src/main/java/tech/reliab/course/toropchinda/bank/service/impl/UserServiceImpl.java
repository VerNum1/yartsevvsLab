package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.DAO.UserDAO;
import tech.reliab.course.toropchinda.bank.entity.User;
import tech.reliab.course.toropchinda.bank.service.UserService;

import java.util.List;

/*
 * A class representing implementation of service for entity User
 * @see tech.reliab.course.toropchinda.bank.service.UserService
 * @see tech.reliab.course.toropchinda.bank.DAO.UserDAO
 */
public class UserServiceImpl implements UserService {
    private final UserDAO bankDAO = new UserDAO();

    @Override
    public User get(long userId) {
        return bankDAO.get(userId).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return bankDAO.getAll();
    }

    @Override
    public void save(User user) {
        bankDAO.save(user);
    }

    public void update(User user) {
        bankDAO.update(user);
    }

    public void delete(long userId) {
        bankDAO.delete(userId);
    }
}
