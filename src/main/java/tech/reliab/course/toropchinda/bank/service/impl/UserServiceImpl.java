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
    private final UserDAO userDAO = new UserDAO();

    @Override
    public User get(long userId) {
        return userDAO.get(userId).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }


    public void update(User user) {
        userDAO.update(user);
    }

    public void delete(long userId) {
        userDAO.delete(userId);
    }

    @Override
    public void outputUserInfo(Long id){ userDAO.outputUserInfo(id); }
}
