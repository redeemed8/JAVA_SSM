package com.jchhh.mybatis.test;

import com.jchhh.mybatis.mapper.UserMapper;
import com.jchhh.mybatis.pojo.User;
import com.jchhh.mybatis.utils.IdUtils;
import com.jchhh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ParameterTest {

    /**
     * 重置 某个表的主键id
     */
    @Test
    public void testResetUserId() {
        String tableName = "t_user";
        IdUtils.resetUserId(tableName);
    }

    @Test
    public void testGetUserByUsername() {
        //  仅仅查询单个用户
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUsername("徐铂钧");
        System.out.println(user);
    }

    @Test
    public void testCheckLogin() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin("徐铂钧", "888888");
        System.out.println(user);
    }

    @Test
    public void testCheckLoginByMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "徐铂钧");
        map.put("password", "888888");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = new User(null, "电脑", "1314520", 18, "男", "wcsa3dadsaads@qq.com");
        User user2 = new User(null, "傻逼", "1422424", 23, "男", "fdfjfgrfth@qq.com");
        User user3 = new User(null, "哈哈", "1242485", 78, "男", "gerre44@qq.com");
        User user4 = new User(null, "tom", "956526", 98, "女", "hftgjt55@qq.com");
        User user5 = new User(null, "MaKaBaKa", "1221642", 101, "女", "fgjfij4@qq.com");
        User user6 = new User(null, "玛卡巴卡", "561264", 32, "男", "fjggji45@qq.com");
        User user7 = new User(null, "陈浩男", "1654951", 5, "男", "sdauwu24454@qq.com");
        mapper.insertUser(user1);
        mapper.insertUser(user2);
        mapper.insertUser(user3);
        mapper.insertUser(user4);
        mapper.insertUser(user5);
        mapper.insertUser(user6);
        mapper.insertUser(user7);
    }

    @Test
    public void testCheckLoginByParam() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLoginByParam("admin", "123456");
        System.out.println(user);
    }

}
