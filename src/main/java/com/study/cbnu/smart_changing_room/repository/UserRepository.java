package com.study.cbnu.smart_changing_room.repository;

import com.study.cbnu.smart_changing_room.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface UserRepository {

    @Select("SELECT * FROM USER_TBL" )
    List<User> selectAll();

    @Insert("INSERT INTO USER_TBL (id, name) VALUES (#{id}, #{name});")
    @SelectKey(statement = "SELECT nextval('seq_user')", before = true ,keyProperty = "id", resultType = Long.class)
    Long save(User user);

    @Select("SELECT * FROM USER_TBL WHERE id = #{id}")
    Optional<User> getUser(Long id);

    @Update("UPDATE USER_TBL SET name = #{name} WHERE id = #{id}")
    Long update(User user);

    @Delete("DELETE FROM USER_TBL WHERE id = #{id}")
    void delete(Long id);

    @Select("SELECT * FROM USER_TBL WHERE name = #{name}")
    Optional<User> getUserByName(String name);
}
