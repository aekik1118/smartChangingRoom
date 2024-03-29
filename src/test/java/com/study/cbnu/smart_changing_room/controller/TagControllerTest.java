package com.study.cbnu.smart_changing_room.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class TagControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void get_tag_list_by_id() throws Exception {

        mockMvc.perform(get("/api/tag/list")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id","1"))
                    .andDo(print())
                    .andExpect(status().isOk());

    }

    @Test
    public void get_tag_list_by_clothes_id() throws Exception {

        mockMvc.perform(get("/api/tag/clothes")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id","1"))
                .andDo(print())
                .andExpect(status().isOk());

    }
}