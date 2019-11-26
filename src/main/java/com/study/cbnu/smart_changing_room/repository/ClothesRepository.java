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
    void delete(Long id);

    @Select("SELECT * FROM CLOTHES_TBL WHERE user_id = #{user_id}")
    List<Clothes> get_clothes_list(long user_id);

    @Select("SELECT CLOTHES_TBL.id, CLOTHES_TBL.name, CLOTHES_TBL.image_path FROM CLOTHES_TBL INNER JOIN TAG_TBL ON CLOTHES_TBL.id = TAG_TBL.clothes_id WHERE TAG_TBL.category = #{test_tag} AND CLOTHES_TBL.user_id = #{user_id}")
    List<Clothes> get_clothes_list_by_tag(long user_id, String test_tag);

}
