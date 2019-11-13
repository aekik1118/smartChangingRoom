package com.study.cbnu.smart_changing_room.model;

import lombok.*;

@Builder @Getter @Setter
@EqualsAndHashCode(of = "id")
@ToString
public class User {

    private final Long id;

    private String name;

}
