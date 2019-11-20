package com.study.cbnu.smart_changing_room.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.logging.log4j.util.Strings.isNotEmpty;

@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Clothes {

    private final Long id;

    private final Long user_id;

    private String name;

    private String image_path;

    private ClothesStatus status = ClothesStatus.NOT_USING;

    private Long using_count = 0L;

    private final LocalDateTime register_at;

    private final LocalDateTime recent_usage_at;

    public Clothes(Long user_id, String name, String image_path) {
        this(null, user_id, name, image_path, null, null, null, null);
    }

    public Clothes(Long id, Long user_id, String name, String image_path, ClothesStatus status, Long using_count, LocalDateTime register_at, LocalDateTime recent_usage_at) {
        this.id = id;

        checkNotNull(user_id, "user_id must be provided.");
        this.user_id = user_id;

        checkArgument(isNotEmpty(name), "clothes name must be provided.");
        this.name = name;

        this.image_path = image_path;

        if(status == null){
            status = ClothesStatus.NOT_USING;
        }
        this.status = status;

        if(using_count == null){
            using_count = 0L;
        }
        this.using_count = using_count;

        if(register_at == null){
            register_at = LocalDateTime.now();
        }
        this.register_at = register_at;

        if(recent_usage_at == null){
            recent_usage_at = LocalDateTime.now();
        }
        this.recent_usage_at = recent_usage_at;
    }
}
