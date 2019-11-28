package com.study.cbnu.smart_changing_room.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.cbnu.smart_changing_room.model.ClothesDTO;
import com.study.cbnu.smart_changing_room.model.User;
import com.study.cbnu.smart_changing_room.service.ClothesService;
import com.study.cbnu.smart_changing_room.service.TagService;
import com.study.cbnu.smart_changing_room.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ClothesControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ClothesService clothesService;

    @Autowired
    UserService userService;

    @Autowired
    TagService tagService;

    @Test
    public void create_clothes() throws Exception {
        User user = User.builder()
                .name("clothes_test_user_name")
                .build();

        User created_user = userService.create(user);

        List<String> test_tag_list = new ArrayList<>(10);

        for(int i=0; i<5; i++){
            test_tag_list.add("test_tag1" + i);
        }

        ClothesDTO clothesDTO = ClothesDTO.builder()
                .user_id(created_user.getId())
                .name("clothes_test_name")
                .tag_list(test_tag_list)
                .build();

        mockMvc.perform(post("/api/clothes")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(clothesDTO)))
                    .andDo(print())
                    .andExpect(jsonPath("id").exists())
                    .andExpect(status().isOk());

        userService.delete(created_user.getId());
    }

    @Test
    public void create_clothes_no_tag() throws Exception {
        User user = User.builder()
                .name("clothes_test_user_name")
                .build();

        User created_user = userService.create(user);

        ClothesDTO clothesDTO = ClothesDTO.builder()
                .user_id(created_user.getId())
                .name("clothes_test_name")
                .build();

        mockMvc.perform(post("/api/clothes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(clothesDTO)))
                .andDo(print())
                .andExpect(jsonPath("id").exists())
                .andExpect(status().isOk());

        userService.delete(created_user.getId());
    }

    @Test
    public void get_clothes_list() throws Exception {

        mockMvc.perform(get("/api/clothes/list")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id", "1"))
                    .andDo(print())
                    .andExpect(status().isOk());

    }

    @Test
    public void get_clothes_list_with_tag() throws Exception {

        mockMvc.perform(get("/api/clothes/listWithTag")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id", "1")
                .param("tag","겨울용"))
                    .andDo(print())
                    .andExpect(status().isOk());

    }

}