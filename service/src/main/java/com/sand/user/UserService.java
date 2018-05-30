package com.sand.user;

import java.util.List;

public interface UserService {
    User findById(Long id);
    List<User> findAll();
    User save(User user);
}
