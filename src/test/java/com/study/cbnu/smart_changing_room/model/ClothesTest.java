package com.study.cbnu.smart_changing_room.model;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ClothesTest {

    @Test
    public void builder(){
        Clothes clothes = Clothes.builder()
                .name("청바지")
                .user_id(1L)
                .build();
        assertThat(clothes).isNotNull();
    }

    @Test(expected = NullPointerException.class)
    public void user_id_null_check(){
        Clothes clothes = Clothes.builder()
                .name("청바지")
                .build();
    }

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void name_empty_check(){
        Clothes clothes = Clothes.builder()
                .user_id(1L)
                .name("")
                .build();
    }

}