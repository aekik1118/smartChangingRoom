package com.study.cbnu.smart_changing_room.service;

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
public class TagServiceTest {

    @Autowired
    TagService tagService;

    @Test
    public void create(){
        Tag test_tag = Tag.builder()
                .clothes_id(1L)
                .category("test_tag")
                .build();

        Tag created_tag = tagService.create(test_tag);

        assertThat(created_tag.getCategory()).isEqualTo(test_tag.getCategory());
    }

    @Test
    public void get_tag(){
        Tag test_tag = Tag.builder()
                .clothes_id(1L)
                .category("test_tag")
                .build();

        Tag created_tag = tagService.create(test_tag);

        Optional<Tag> get_tag = tagService.get_tag(test_tag.getId());

        assertThat(get_tag.get().getCategory()).isEqualTo(test_tag.getCategory());
    }

    @Test
    public void delete(){
        Tag test_tag = Tag.builder()
                .clothes_id(1L)
                .category("test_tag")
                .build();
        Tag created_tag = tagService.create(test_tag);

        tagService.delete(test_tag.getId());

        Optional<Tag> get_tag = tagService.get_tag(test_tag.getId());
        assertThat(get_tag.isPresent()).isEqualTo(false);
    }

    @Test
    public void get_tag_list_by_clothes_id(){

        List<Tag> before_tagList = tagService.get_list_by_clothes_id(1L);

        int add_tag_size = 3;

        for(int i=0; i<add_tag_size; i++){
            Tag test_tag = Tag.builder()
                    .clothes_id(1L)
                    .category("test_tag12" + i)
                    .build();

            tagService.create(test_tag);
        }

        List<Tag> after_tagList = tagService.get_list_by_clothes_id(1L);

        assertThat(before_tagList.size()).isEqualTo(after_tagList.size() - add_tag_size);
    }

    @Test
    public void get_tag_list_by_user_id_no_duplication(){

        List<String> before_taglist = tagService.get_list_by_user_id_no_duplication(1L);

        int add_tag_size = 3;

        for(int i=0; i<add_tag_size; i++){
            Tag test_tag = Tag.builder()
                    .clothes_id(1L)
                    .category("test_tagtest12" + i)
                    .build();

            tagService.create(test_tag);
        }

        for(int i=0; i<add_tag_size; i++){
            Tag test_tag = Tag.builder()
                    .clothes_id(2L)
                    .category("test_tagtest12" + i)
                    .build();

            tagService.create(test_tag);
        }

        List<String> after_taglist = tagService.get_list_by_user_id_no_duplication(1L);

        assertThat(after_taglist.size() - add_tag_size).isEqualTo(before_taglist.size());
    }

}