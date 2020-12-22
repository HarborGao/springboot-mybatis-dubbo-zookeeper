package com.harbor.provider.mapper;

import com.harbor.common.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Results(id = "userMap", value = {
            @Result(column = "userName", property = "userName"),
            @Result(column = "userPassword", property = "userPassword")})
    @Select("SELECT * FROM user")
    List<User> getAll();

    @Select("SELECT * FROM user t WHERE t.userName = #{userName}")
    @ResultMap("userMap")
    User getOne(String userName);

    @Insert("INSERT into user values(#{userName},#{userPassword})")
    int addUser(User user);
}