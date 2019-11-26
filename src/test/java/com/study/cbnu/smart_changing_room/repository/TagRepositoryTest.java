package com.study.cbnu.smart_changing_room.repository;

import com.study.cbnu.smart_changing_room.model.Tag;
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
public class TagRepositoryTest {

    @Autowired
    TagRepository tagRepository;

    @Test
    public void mapper_load(){
        System.out.println(tagRepository.getClass().toString());
    }

    @Test
    public void save_tag(){

        List<Tag> before_insert_tagList = tagRepository.selectAll();

        Tag test_tag = Tag.builder()
                .clothes_id(1L)
                .category("test_tag")
                .build();

        tagRepository.save(test_tag);

        List<Tag> after_insert_tagList = tagRepository.selectAll();
        assertThat(before_insert_tagList.size()).isEqualTo(after_insert_tagList.size() - 1);

        Optional<Tag> select_test_tag = tagRepository.get_tag(test_tag.getId());
        assertThat(select_test_tag.get().getCategory()).isEqualTo(test_tag.getCategory());
    }

    @Test
    public void update(){

        String test_category = "testtest11";

        Tag test_tag = Tag.builder()
                .clothes_id(1L)
                .category("test_tag")
                .build();

        tagRepository.save(test_tag);
        test_tag.setCategory(test_category);
        tagRepository.update(test_tag);

        Optional<Tag> optionalTag = tagRepository.get_tag(test_tag.getId());

        assertThat(optionalTag.get().getCategory()).isEqualTo(test_category);
    }

    @Test
    public void delete(){
        Tag test_tag = Tag.builder()
                .clothes_id(1L)
                .category("test_tag")
                .build();

        tagRepository.save(test_tag);

        List<Tag> before_delete_tagList = tagRepository.selectAll();

        tagRepository.delete(test_tag.getId());

        List<Tag> after_delete_tagList = tagRepository.selectAll();

        assertThat(after_delete_tagList.size()).isEqualTo(before_delete_tagList.size() - 1);
    }

    @Test
    public void get_tag_list_by_clothes_id(){

        List<Tag> before_tagList = tagRepository.select_by_clothes_id(1L);

        int add_tag_size = 3;

        for(int i=0; i<add_tag_size; i++){
            Tag test_tag = Tag.builder()
                    .clothes_id(1L)
                    .category("test_tag" + i)
                    .build();

            tagRepository.save(test_tag);
        }

        List<Tag> after_tagList = tagRepository.select_by_clothes_id(1L);

        assertThat(before_tagList.size()).isEqualTo(after_tagList.size() - add_tag_size);
    }

    @Test
    public void get_tag_list_by_user_id_no_duplication(){

        List<String> before_taglist = tagRepository.select_by_user_id_no_duplication(1L);

        int add_tag_size = 3;

        for(int i=0; i<add_tag_size; i++){
            Tag test_tag = Tag.builder()
                    .clothes_id(1L)
                    .category("test_tagtest" + i)
                    .build();

            tagRepository.save(test_tag);
        }

        for(int i=0; i<add_tag_size; i++){
            Tag test_tag = Tag.builder()
                    .clothes_id(2L)
                    .category("test_tagtest" + i)
                    .build();

            tagRepository.save(test_tag);
        }

        List<String> after_taglist = tagRepository.select_by_user_id_no_duplication(1L);

        assertThat(after_taglist.size() - add_tag_size).isEqualTo(before_taglist.size());
    }

}