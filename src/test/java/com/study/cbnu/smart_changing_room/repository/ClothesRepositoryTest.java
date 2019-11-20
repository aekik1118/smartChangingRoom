package com.study.cbnu.smart_changing_room.repository;

import com.study.cbnu.smart_changing_room.model.Clothes;
import com.study.cbnu.smart_changing_room.model.ClothesStatus;
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
public class ClothesRepositoryTest {

    @Autowired
    ClothesRepository clothesRepository;

    @Test
    public void mapper_load(){
        System.out.println(clothesRepository.getClass().toString());
    }

    @Test
    public void save_clothes(){
        List<Clothes> before_insert_clothes = clothesRepository.selectAll();

        Clothes clothes1 = Clothes.builder()
                .user_id(1L)
                .name("파랑 맨투맨")
                .image_path(null)
                .status(ClothesStatus.NOT_USING)
                .build();

        Long save = clothesRepository.save(clothes1);

        List<Clothes> clothes2 = clothesRepository.selectAll();

        assertThat(before_insert_clothes.size()).isEqualTo(clothes2.size() - 1);

        Optional<Clothes> clothesOptional = clothesRepository.get_clothes(clothes1.getId());
        System.out.println(clothesOptional.get().toString());
        assertThat(clothesOptional.get().getName()).isEqualTo(clothes1.getName());
    }

    @Test
    public void update(){
        String updata_name = "test_name";

        Clothes clothes = Clothes.builder()
                .user_id(1L)
                .name("파랑 맨투맨")
                .image_path(null)
                .status(ClothesStatus.NOT_USING)
                .build();

        clothesRepository.save(clothes);

        clothes.setName(updata_name);

        clothesRepository.update(clothes);

        Optional<Clothes> clothes1 = clothesRepository.get_clothes(clothes.getId());

        assertThat(clothes1.get().getName()).isEqualTo(updata_name);
    }

    @Test
    public void delete(){
        Clothes clothes = Clothes.builder()
                .user_id(1L)
                .name("파랑 맨투맨")
                .image_path(null)
                .status(ClothesStatus.NOT_USING)
                .build();
        clothesRepository.save(clothes);

        List<Clothes> before_delete_clothes = clothesRepository.selectAll();

        clothesRepository.delete(clothes);

        List<Clothes> after_delete_clothes = clothesRepository.selectAll();

        assertThat(before_delete_clothes.size()).isEqualTo(after_delete_clothes.size() + 1);
    }

}