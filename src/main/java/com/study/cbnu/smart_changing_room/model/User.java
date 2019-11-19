package com.study.cbnu.smart_changing_room.model;

import lombok.*;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.logging.log4j.util.Strings.isNotEmpty;

@Builder @Getter @Setter
@EqualsAndHashCode(of = "id")
@ToString
public class User {

    private final Long id;

    private String name;

    public User(String name) {
        this(null, name);
    }

    public User(Long id, String name) {
        this.id = id;

        checkArgument(isNotEmpty(name), "User name must be provided.");
        this.name = name;
    }
}
