package com.yhq.springbootcrud.dao;

import com.yhq.springbootcrud.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    @Insert("insert into user values({id},{username},{password})")
    void insert(User user);

    @Select("select * from user where id=#{id}")
    List<User> selectById(@Param("id")Integer id);

    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    void updateById(User user);

    @Delete("delete from user where id=#{id}")
    void deleteByID(@Param("id")Integer id);

    @Select("select * from user")
    List<User> getAllUsers();

}
