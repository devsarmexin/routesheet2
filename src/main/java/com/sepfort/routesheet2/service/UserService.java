package com.sepfort.routesheet2.service;

import com.sepfort.routesheet2.model.User;
import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public interface UserService {
    User addUser(User user);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Integer id);

    void delete(Integer id);
}
