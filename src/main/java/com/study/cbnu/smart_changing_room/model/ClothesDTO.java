package com.study.cbnu.smart_changing_room.model;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@ToString
public class ClothesDTO{

    private Long user_id;

    private String name;

    private String image_path;

    private List<String> tag_list;
}
