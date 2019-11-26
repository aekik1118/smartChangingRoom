package com.study.cbnu.smart_changing_room.service;

import com.study.cbnu.smart_changing_room.model.Clothes;
import com.study.cbnu.smart_changing_room.model.User;
import com.study.cbnu.smart_changing_room.repository.UserRepository;
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
public class ClothesServiceTest {

    @Autowired
    private ClothesService clothesService;

    @Autowired
    private UserService userService;


    @Test
    public void create(){

        User test_user = User.builder()
                .name("test_user_name")
                .build();

        User created_test_user = userService.create(test_user);


        Clothes test_clothes = Clothes.builder()
                .name("test_clothes_name")
                .user_id(created_test_user.getId())
                .build();

        Clothes created_test_clothes = clothesService.create(test_clothes);

        assertThat(created_test_clothes.getName()).isEqualTo(test_clothes.getName());
    }

    @Test
    public void get_clothes(){

        User test_user = User.builder()
                .name("test_user_name")
                .build();

        User created_test_user = userService.create(test_user);


        Clothes test_clothes = Clothes.builder()
                .name("test_clothes_name")
                .user_id(created_test_user.getId())
                .build();

        Clothes created_test_clothes = clothesService.create(test_clothes);

        Optional<Clothes> get_test_clothes = clothesService.getClothes(created_test_clothes.getId());

        assertThat(get_test_clothes.get().getName()).isEqualTo(test_clothes.getName());
    }

    @Test
    public void update(){

        String update_name = "update";

        User test_user = User.builder()
                .name("test_user_name")
                .build();

        User created_test_user = userService.create(test_user);


        Clothes test_clothes = Clothes.builder()
                .name("test_clothes_name")
                .user_id(created_test_user.getId())
                .build();

        Clothes created_test_clothes = clothesService.create(test_clothes);

        test_clothes.setName(update_name);

        Clothes update_test_clothes = clothesService.updateClothes(test_clothes);


        Optional<Clothes> get_test_clothes = clothesService.getClothes(created_test_clothes.getId());

        assertThat(get_test_clothes.get().getName()).isEqualTo(update_name);
    }

    @Test
    public void delete(){
        User test_user = User.builder()
                .name("test_user_name")
                .build();

        User created_test_user = userService.create(test_user);


        Clothes test_clothes = Clothes.builder()
                .name("test_clothes_name")
                .user_id(created_test_user.getId())
                .build();

        Clothes created_test_clothes = clothesService.create(test_clothes);

        clothesService.delete(created_test_clothes.getId());

        Optional<Clothes> get_test_clothes = clothesService.getClothes(created_test_clothes.getId());

        assertThat(get_test_clothes.isPresent()).isEqualTo(false);

    }

    @Test
    public void get_clothes_list(){

        User test_user = User.builder()
                .name("test_user_name")
                .build();

        User created_test_user = userService.create(test_user);

        List<Clothes> before_clothes_list = clothesService.get_clothes_list(created_test_user.getId());

        int clothes_add_size = 10;

        for(int i=0; i<clothes_add_size; i++){
            Clothes clothes = Clothes.builder()
                    .user_id(created_test_user.getId())
                    .name("맨투맨" + i)
                    .image_path(null)
                    .build();

            clothesService.create(clothes);
        }

        List<Clothes> after_clothes_list = clothesService.get_clothes_list(created_test_user.getId());
        assertThat(before_clothes_list.size() + clothes_add_size).isEqualTo(after_clothes_list.size());

    }

}