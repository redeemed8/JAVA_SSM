package com.jchhh.mybatis.mapper;

import com.jchhh.mybatis.pojo.User;
import java.util.List;

public interface UserMapper {

    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 删除用户信息
     */
    int deleteUser();

    /**
     * 修改用户信息
     */
    int updateUser();

    /**
     * 根据id查询用户信息
     */
    User getUserById();

    /**
     * 查询所有的用户信息
     */
    List<User> getAllUser();

}
