package com.study.cbnu.smart_changing_room.repository;

import com.study.cbnu.smart_changing_room.model.Tag;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface TagRepository {
    @Select("SELECT * FROM TAG_TBL")
    List<Tag> selectAll();

    @Insert("INSERT INTO TAG_TBL (id, clothes_id, category) VALUES (#{id}, #{clothes_id}, #{category});")
    @SelectKey(statement = "SELECT nextval('seq_tag')", before = true, keyProperty = "id", resultType = Long.class)
    Long save(Tag test_tag);

    @Select("SELECT * FROM TAG_TBL WHERE id = #{id}")
    Optional<Tag> get_tag(Long id);

    @Update("UPDATE TAG_TBL SET category = #{category} WHERE id = #{id}")
    Long update(Tag test_tag);

    @Delete("DELETE FROM TAG_TBL WHERE id = #{id}")
    void delete(Long id);

    @Select("SELECT * FROM TAG_TBL WHERE clothes_id = #{clothes_id}")
    List<Tag> select_by_clothes_id(Long clothes_id);

    @Select("SELECT DISTINCT TAG_TBL.category FROM TAG_TBL INNER JOIN CLOTHES_TBL ON CLOTHES_TBL.id = TAG_TBL.clothes_id WHERE CLOTHES_TBL.user_id = #{user_id}")
    List<String> select_by_user_id_no_duplication(long user_id);
}
