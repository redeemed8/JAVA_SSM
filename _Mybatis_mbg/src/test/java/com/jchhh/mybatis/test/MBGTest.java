package com.jchhh.mybatis.test;

import com.jchhh.mybatis.mapper.EmpMapper;
import com.jchhh.mybatis.pojo.Emp;
import com.jchhh.mybatis.pojo.EmpExample;
import com.jchhh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MBGTest {

    @Test
    public void testMBG() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.selectByPrimaryKey(1);
        System.out.println(emp);
    }

    @Test
    public void testMBG_2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        EmpExample example = new EmpExample();
        //  ↓ 这种方法名格式： and + 字段名 + 什么样的条件（大于 。。 小于。。等等）
        example.createCriteria().andEmpNameEqualTo("张三");
        example.or().andGenderEqualTo("女");
        List<Emp> list = mapper.selectByExample(example);
        list.forEach(System.out::println);
    }

    @Test
    public void testMBG_3() {
        //  测试根据主键修改
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = new Emp(3, "王五", 15, "男", 3);
        mapper.updateByPrimaryKey(emp);
        //  如果使用选择性修改  那么如果值为null  就意为着不修改
    }

}
