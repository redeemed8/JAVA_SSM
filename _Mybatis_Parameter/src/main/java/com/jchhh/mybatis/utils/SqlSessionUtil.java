package com.jchhh.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {

    /**
     * 参数写一个true就会自动提交
     */
    public static SqlSession getSqlSession(boolean mode) {
        SqlSession sqlSession = null;
        try {
            //  获取核心配置文件的输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //  获取 SqlSessionFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //  获取 SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            //  获取 SqlSession 对象，是MyBatis提供的操作数据库的对象
            sqlSession = sqlSessionFactory.openSession(mode);       //   参数写一个true就会自动提交，默认false
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }

}
