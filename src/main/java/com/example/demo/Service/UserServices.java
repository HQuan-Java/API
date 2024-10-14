package com.example.demo.Service;

import com.example.demo.Model.User;
import java.util.List;

public interface UserServices {
    // Hàm lấy danh sách user
    List<User> getAllUser();

    // Hàm thêm user
    User addUser(User user);

    // Hàm update user
    User updateUser(long id, User user);

    // Hàm xóa user
    boolean deleteUser(long id);
}
