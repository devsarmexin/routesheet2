package com.sepfort.routesheet2.rest;

import com.sepfort.routesheet2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);

}
