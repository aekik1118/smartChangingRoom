package com.study.cbnu.smart_changing_room.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.cbnu.smart_changing_room.model.User;
import com.study.cbnu.smart_changing_room.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    UserService userService;

    @Test
    public void create_User() throws Exception {
        User user = User.builder()
                .name("controller_name")
                .build();

        mockMvc.perform(post("/api/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(user)))
                    .andDo(print())
                    .andExpect(status().isOk());


    }

    @Test
    public void get_user_id() throws Exception {

        User user = User.builder()
                .name("원경식")
                .build();

        User created_user = userService.create(user);

        mockMvc.perform(get("/api/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("name",user.getName()))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("id").exists());

        userService.delete(created_user.getId());
    }

    @Test
    public void get_user_id_not_exist() throws Exception {

        mockMvc.perform(get("/api/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("name","not_exist"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

}