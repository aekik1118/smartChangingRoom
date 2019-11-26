package com.study.cbnu.smart_changing_room.service;

import com.study.cbnu.smart_changing_room.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void createUser(){
        User user = User.builder()
                .name("정성진")
                .build();

        User created_user = userService.create(user);

        assertThat(created_user.getName()).isEqualTo(user.getName());

        userService.delete(created_user.getId());
    }

    @Test
    public void get_user(){
        User user = User.builder()
                .name("정성진")
                .build();

        User created_user = userService.create(user);

        Optional<User> get_user = userService.get(created_user.getId());

        assertThat(get_user.get().getName()).isEqualTo(created_user.getName());

        userService.delete(created_user.getId());
    }

    @Test
    public void get_user_by_name(){
        User user = User.builder()
                .name("정성진")
                .build();

        User created_user = userService.create(user);

        Optional<User> get_user = userService.getByName(created_user.getName());

        assertThat(get_user.get().getId()).isEqualTo(created_user.getId());

        userService.delete(created_user.getId());
    }


}