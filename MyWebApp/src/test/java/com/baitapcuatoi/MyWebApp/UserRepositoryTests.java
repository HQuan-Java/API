package com.baitapcuatoi.MyWebApp;

import com.baitapcuatoi.MyWebApp.user.User;
import com.baitapcuatoi.MyWebApp.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired private UserRepository repo;

    @Test
    public void testAddnew() {
        User user = new User();
        user.setEmail("huyrrru76@gmail.com");
        user.setPassword("72366t");
        user.setFirstName("Revi");
        user.setLastName("Alex");

        User savedUser = repo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<User> users = repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);
        for (User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate() {
        Integer userId = 3;
        Optional<User> optionalUser = repo.findById(userId);
        User user = optionalUser.get();
        user.setPassword("hell333");
        repo.save(user);

        User updateUser = repo.findById(userId).get();
        Assertions.assertThat(updateUser.getPassword()).isEqualTo("hell333");

    }

    @Test
    public void testGet(){
        Integer userId = 3;
        Optional<User> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }

    @Test
    public void testDelete(){
        Integer userId = 3;
        repo.deleteById(userId);

        Optional<User> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();
    }
}
