package com.example.demo.Service;


import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServicesImpl implements UserServices{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        if (user!=null){
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User updateUser(long id, User user) {
        if (user!=null){
            User user1=userRepository.getById(id);
            if (user1!=null){
                user1.setName(user.getName());
                user1.setEmail(user.getEmail());
                user1.setPhoneNumber(user.getPhoneNumber());
                user1.setDateOfBirth(user.getDateOfBirth());

                return userRepository.save(user1);
            }
        }
        return null;
    }

    @Override
    public boolean deleteUser(long id) {
        if (id>=1){
            User user=userRepository.getById(id);
            if (user!=null){
                userRepository.delete(user);
                return true;
            }
        }
        return false;
    }
}

