package com.springboot.officesystem.service;

import com.springboot.officesystem.model.Request;
import com.springboot.officesystem.model.User;
import com.springboot.officesystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public Boolean deleteUser(Long userId) {
        try {
            userRepository.deleteById(userId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public User getUserById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        return user;
    }

    @Override
    public User updateUser(User user){
        Boolean exist = userRepository.existsById(user.getUserId());
        if (exist != null) {
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    @Override
    public User login(Long id){
        User user = userRepository.findById(id).orElse(null   );
        if (user != null) {
            user.setStatus(true);
            userRepository.save(user);
            return user;
        } else { return null; }
    }
    @Override
    public User logout(Long id){
        User user = userRepository.findById(id).orElse(null   );
        if (user != null) {
            user.setStatus(false);
            userRepository.save(user);
            return user;
        } else { return null; }
    }

    @Override
    public List<User> getAccount(Boolean type){
        if (!type) {
            return userRepository.getUserAccounts();
        } else { return userRepository.getManagerAccounts(); }
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
}
