package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userServices;

    //Test
    @GetMapping("/")
    public String test(){
        return "Quân đẹp trai";
    }

    //API lấy danh sách user
    @GetMapping("/list")
    public List<User> getAllUser(){
        return userServices.getAllUser();
    }

    //API add user
    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return userServices.addUser(user);
    }

    //API update user
    @PostMapping("/update")
    public User updateUser(@RequestParam("id") long id,@RequestBody User user){
        return userServices.updateUser(id, user);
    }

    //API xóa user
    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(@PathVariable("id") long id){
        return  userServices.deleteUser(id);
    }
}
