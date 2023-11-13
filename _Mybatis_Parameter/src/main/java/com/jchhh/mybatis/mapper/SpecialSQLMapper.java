package com.jchhh.mybatis.mapper;

import com.jchhh.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSQLMapper {

    /**
     * 获取 某个表 所有用户的 id
     */
    List<Integer> getAllUserId(@Param("tableName") String tableName);

    /**
     * 通过用户名模糊查询用户信息
     */
    List<User> getUserByLike(@Param("mohu") String mohu);

    /**
     * 批量删除     指定一些id进行删除
     */
    void deleteMoreUser(@Param("ids") String ids);

    /**
     * 批量清除2    通过指定范围删除
     */
    void deleteMoreUserByIdGreater(@Param("start") String start, @Param("end") String end);

    /**
     * 动态设置表名，获取某个表里的所有用户信息
     */
    List<User> getUserList(@Param("tableName") String tableName);

    /**
     * 重置 某个表的主键id
     */
    void resetUserId(@Param("tableName") String tableName);

    /**
     * 将 某表 的 某个 id值 修改为 另一个 id值
     */
    void updateUserId(@Param("tableName") String tableName, @Param("start_id") Integer start_id, @Param("end_id") Integer end_id);

    /**
     * 添加用户信息，并获取自增的主键
     */
    void insertUser(User user);
}
