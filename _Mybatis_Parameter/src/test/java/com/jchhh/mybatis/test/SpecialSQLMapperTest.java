package com.jchhh.mybatis.test;

import com.jchhh.mybatis.mapper.SpecialSQLMapper;
import com.jchhh.mybatis.mapper.UserMapper;
import com.jchhh.mybatis.pojo.User;
import com.jchhh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SpecialSQLMapperTest {

    @Test
    public void testGetAllUserId() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<Integer> list = mapper.getAllUserId("t_user");
        list.forEach(System.out::println);
    }

    @Test
    public void testGetUserByLike() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> list = mapper.getUserByLike("a");
        list.forEach(System.out::println);
    }

    @Test
    public void testDeleteMoreUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        mapper.deleteMoreUser("9,10,11,12,13,14,15");
    }

    @Test
    public void testDeleteMoreUserByIdGreater() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        mapper.deleteMoreUserByIdGreater("19", "21");
    }

    @Test
    public void testGetUserList() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> list = mapper.getUserList("t_user");
        list.forEach(System.out::println);
    }

    @Test
    public void testUpdateUserId() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        mapper.updateUserId("t_user", 4, 3);
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        User user = new User(null, "鼠标", "sdsjhi", 56, "女", "wjiwjiodjwij@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
}
