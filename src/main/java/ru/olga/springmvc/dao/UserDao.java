package ru.olga.springmvc.dao;

import ru.olga.springmvc.model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    void removeUserById(int id);

    List<User> getAllUsers();

    User showUser(int id);

    void updateUser(User user);
}
