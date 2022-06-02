package com.springboot.officesystem.service;
import com.springboot.officesystem.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User addUser(User user);
    public List<User> getAllUsers();
    public Boolean deleteUser(Long userId);
    public User getUserById(Long userId);
    public User updateUser(User user);

    public User login(Long userId);
    public User logout(Long userId);

    public List<User> getAccount(Boolean type);

}
