package com.jchhh.mybatis.test;

import com.jchhh.mybatis.mapper.CacheMapper;
import com.jchhh.mybatis.pojo.Emp;
import com.jchhh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class CacheMapperTest {

    /**
     * mybatis的 一级缓存：
     *      一级缓存 SqlSession 级别
     *      在相同的 SqlSession 中 执行相同的语句，第二次以后会从缓存中获取
     *      必须保证是在同一个 SqlSession 中
     *      默认是开启的，一般也不会去关闭
     *      ---使一级缓存失效的四种情况：
     *          1. 不同的 SqlSession 对应不同的一级缓存
     *          2. 同一个 SqlSession 但是查询条件不同
     *          3. 同一个 SqlSession 两次查询期间执行了任何一次增删改操作
     *          4. 同一个 SqlSession 两次查询期间手动清空了缓存
     */

    @Test
    public void testGetEmpById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        //  一级缓存测试
        Emp emp1 = mapper.getEmpById(8);
        System.out.println(emp1);
        System.out.println();

        mapper.insertEmp(new Emp(null,"爱丽丝",13,"女"));
        //  失效
        Emp emp2 = mapper.getEmpById(8);
        System.out.println(emp2);
        System.out.println();

        //  可以手动清空缓存
        sqlSession.clearCache();
        Emp emp3 = mapper.getEmpById(8);
        System.out.println(emp3);
    }

    /**
     * mybatis 的二级缓存：
     *      是 SqlSessionFactory 级别的，即通过同一个 SqlSessionFactory 所获取的 SqlSession 对象
     *      查询的数据会被缓存，在通过同一个 SqlSessionFactory 获取的 SqlSession 查询相同的数据会从缓存中获取
     *      ---mybatis 二级缓存的开启条件：
     *          1. 配置全局文件：cacheEnabled=true  默认为true
     *          2. 在映射文件中设置标签 < cache />
     *          3. 二级缓存必须在 SqlSession 关闭或提交之后有效
     *          4. 查询的数据所转换的实体类类型必须实现序列化的接口
     *      ---使二级缓存失效的方法：
     *          两次查询之间执行了任意的增删改，会使 一二 级缓存失效
     */

    @Test
    public void testCache_2() {
        //  测试二级缓存
        SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);;
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);

        Emp emp1 = mapper1.getEmpById(8);
        System.out.println(emp1);
        sqlSession1.close();

        Emp emp2 = mapper2.getEmpById(8);
        System.out.println(emp2);
        sqlSession2.close();
    }
}
