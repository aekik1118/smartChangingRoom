package com.study.cbnu.smart_changing_room.repository;

import com.study.cbnu.smart_changing_room.model.Clothes;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface ClothesRepository {

    @Select("SELECT * FROM CLOTHES_TBL")
    List<Clothes> selectAll();

    @Insert("INSERT INTO CLOTHES_TBL (id, user_id, name, image_path, status) VALUES (#{id}, #{user_id}, #{name}, #{image_path}, #{status});")
    @SelectKey(statement = "SELECT nextval('seq_clothes')", before = true, keyProperty = "id", resultType = Long.class)
    Long save(Clothes clothes);

    @Select("SELECT * FROM CLOTHES_TBL WHERE id = #{id}")
    Optional<Clothes> get_clothes(Long id);

    @Update("UPDATE CLOTHES_TBL SET name = #{name}, image_path = #{image_path}, status = #{status} WHERE id = #{id}")
    Long update(Clothes clothes);

    @Delete("DELETE FROM CLOTHES_TBL WHERE id = #{id}")
    void delete(Clothes clothes);
}
