package com.study.cbnu.smart_changing_room.model;

import lombok.*;

import static com.google.common.base.Preconditions.checkNotNull;

@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Tag {

    private final Long id;

    private final Long clothes_id;

    private TagCategory category;

    public Tag(Long clothes_id, TagCategory category) {
        this(null, clothes_id, category);
    }

    public Tag(Long id, Long clothes_id, TagCategory category) {
        this.id = id;

        checkNotNull(clothes_id, "clothes_id must be provided.");
        this.clothes_id = clothes_id;

        checkNotNull(category, "category must be provided.");
        this.category = category;
    }
}
