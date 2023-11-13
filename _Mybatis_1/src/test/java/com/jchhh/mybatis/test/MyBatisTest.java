package com.jchhh.mybatis.test;

import com.jchhh.mybatis.mapper.UserMapper;
import com.jchhh.mybatis.pojo.User;
import com.jchhh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    public void test_Insert() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(false);        //  意为关闭自动提交

        //  获取 UserInsert的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //  调用mapper接口中的方法，实现添加用户信息的功能
        int ret = mapper.insertUser();

        //  提供 sql 语句的唯一标识并找到 sql 并执行，唯一标识是 namespace.sqlId
        //int ret = sqlSession.insert("com.jchhh.mybatis.mapper.UserMapper.insertUser");

        System.out.println("结果:" + ret);
        //  我们要手动提交和回滚
        sqlSession.commit();
        //  释放资源
        sqlSession.close();
    }
//  变向劝退...
    @Test
    public void test_Update() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int ret = mapper.updateUser();
        System.out.println("结果:" + ret);
        sqlSession.close();
    }

    @Test
    public void test_Delete() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int ret = mapper.deleteUser();
        System.out.println("结果:" + ret);
        sqlSession.close();
    }

    @Test
    public void test_Select() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById();
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void test_Select2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(System.out::println);
        sqlSession.close();
    }


}
