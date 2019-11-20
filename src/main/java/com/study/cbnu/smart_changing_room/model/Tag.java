package com.study.cbnu.smart_changing_room.model;

import lombok.*;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.logging.log4j.util.Strings.isNotEmpty;

@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Tag {

    private final Long id;

    private final Long clothes_id;

    private String category;

    public Tag(Long clothes_id, String category) {
        this(null, clothes_id, category);
    }

    public Tag(Long id, Long clothes_id, String category) {
        this.id = id;

        checkNotNull(clothes_id, "clothes_id must be provided.");
        this.clothes_id = clothes_id;

        checkArgument(isNotEmpty(category), "category must be provided.");
        this.category = category;
    }
}
