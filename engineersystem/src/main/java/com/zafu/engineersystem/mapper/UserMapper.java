package com.zafu.engineersystem.mapper;

import com.zafu.engineersystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    //查询所有用户信息
    List<User> getAllUser();

    //新增用户信息
    int addUser(User user);

    //根据姓名删除用户
    int deleteUser(String UserName);

    //根据Id删除用户
    int deleteUserById(int userId);

    //更新用户信息
    int updateUser(User user);

    //根据用户姓名查询用户信息
    User getUserByName(String username);

    //根据用户工号查询用户信息
    User getUserById(int UserId);

    //查询对应名字的用户数量
    int getUserCountByName(String userName);

}
