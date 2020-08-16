package com.sepfort.routesheet2.service.impl;

import com.sepfort.routesheet2.model.Role;
import com.sepfort.routesheet2.model.Status;
import com.sepfort.routesheet2.model.User;
import com.sepfort.routesheet2.repository.UserRepo;
import com.sepfort.routesheet2.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder;
    private Logger log = Logger.getLogger(Log.class.getName());

    @Autowired
    public UserServiceImpl(UserRepo userRepo, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User addUser(User user) {
        Set<Role> roles = new TreeSet<>();
        roles.add(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(roles);
        user.setStatus(Status.ACTIVE);
        User registeredUser = userRepo.save(user);
        log.info(String.format("In register user : %s successfully registered", registeredUser));
        return registeredUser;
    }

    @Override
    public List<User> getAll() {
        List<User> resultUser = userRepo.findAll();
        log.info(String.format("In getAll - %s found users", resultUser.size()));
        return resultUser;
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepo.findByUsername(username);
        log.info(String.format("In findByUsername, found %s", user));
        return user;
    }

    @Override
    public User findById(Integer id) {
        User user = userRepo.findById(id).orElse(null);
        if (user == null) {
            log.info(String.format("In findById - not found user by id = %s", id));
            return null;
        }
        log.info(String.format("In findById, found %s", user));
        return user;
    }

    @Override
    public void delete(Integer id) {
        userRepo.deleteById(id);
        log.info(String.format("In delete, delete user with id = %s", id));
    }
}
