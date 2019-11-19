package com.study.cbnu.smart_changing_room.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void builder(){
        User user = User.builder()
                .name("asafeg")
                .build();

        assertThat(user).isNotNull();
    }

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void check_empty_name(){
        User user = User.builder()
                .name("")
                .build();
    }

}