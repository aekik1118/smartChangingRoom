package com.study.cbnu.smart_changing_room.model;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class TagTest {

    @Test
    public void builder(){
        Tag tag = Tag.builder()
                .clothes_id(3L)
                .category(TagCategory.AUTUMN)
                .build();
        assertThat(tag).isNotNull();
    }

    @Test(expected = NullPointerException.class)
    public void clotes_id_null_check(){
        Tag tag = Tag.builder()
                .category(TagCategory.AUTUMN)
                .build();
    }

    @Test(expected = NullPointerException.class)
    public void category_null_check(){
        Tag tag = Tag.builder()
                .clothes_id(3L)
                .build();
    }

}