package com.jchhh.mybatis.mapper;

import com.jchhh.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

    /**
     * 根据 id 查询用户信息
     */
    User getUserById(@Param("id") Integer id);

    /**
     * 查询所有用户信息
     */
    List<User> getAllUser();

    /**
     * 查询用户的总数量
     */
    Integer getCount();

    /**
     * 根据 id 查询用户信息为 map 集合
     */
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

    /**
     * 根据 age 查询用户信息为 map 集合
     */
    List<Map<String, Object>> getUserByAgeToMap(@Param("age") Integer age);

    //  第二种方式

    /**
     * 通过年龄查询，把 id 作为 map 的键
     * MapKey注解中的字段，一定要是唯一字段，不然含有相同字段的结果，会相互覆盖
     */
    @MapKey("id")
    Map<String, Object> getUserByIdToMap2(@Param("age") Integer age);

}
