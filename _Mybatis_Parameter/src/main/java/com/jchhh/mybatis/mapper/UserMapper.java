package com.jchhh.mybatis.mapper;

import com.jchhh.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;
import java.util.Map;

public interface UserMapper {

    /**
     * 根据用户名查询用户信息
     */
    User getUserByUsername(String username);

    /**
     * 验证登录
     */
    User checkLogin(String username, String password);

    /**
     * 验证登录  以 map 集合作为参数
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 添加用户信息,使用实体类的属性
     */
    void insertUser(User user);

    /**
     * 验证登录，使用注解 @Param,会把注解和参数存入 map
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);

}
