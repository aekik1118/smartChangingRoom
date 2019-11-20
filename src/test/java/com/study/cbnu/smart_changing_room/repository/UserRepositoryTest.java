package com.study.cbnu.smart_changing_room.repository;

import com.study.cbnu.smart_changing_room.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void mapper_load(){
        System.out.println(userRepository.getClass().toString());
    }

    @Test
    public void save_user(){

        List<User> users = userRepository.selectAll();

        User user = User.builder()
                .name("test_name")
                .build();

        Long is_get_user = userRepository.save(user);

        List<User> after_save_users = userRepository.selectAll();

        Optional<User> user1 = userRepository.getUser(user.getId());

        assertThat(user1.get().getName()).isEqualTo(user.getName());
        assertThat(after_save_users.size()).isEqualTo(users.size()+1);
    }

    @Test
    public void update(){
        String update_name = "update_name";

        User user = User.builder()
                .name("test_name")
                .build();
        Long is_get_user = userRepository.save(user);

        user.setName(update_name);

        Long update = userRepository.update(user);

        Optional<User> user1 = userRepository.getUser(user.getId());

        assertThat((user1).get().getName()).isEqualTo(update_name);
    }

    @Test
    public void delete(){
        User user = User.builder()
                .name("test_name")
                .build();
        Long is_get_user = userRepository.save(user);

        List<User> users = userRepository.selectAll();

        userRepository.delete(user.getId());

        List<User> users2 = userRepository.selectAll();

        assertThat(users.size()).isEqualTo(users2.size() + 1);

    }

}