package com.jchhh.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jchhh.mybatis.mapper.EmpMapper;
import com.jchhh.mybatis.pojo.Emp;
import com.jchhh.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class PageTest {

    @Test
    public void testPage() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //  查询功能之前开启分页功能
        Page<Object> page = PageHelper.startPage(4, 2);

        List<Emp> list = mapper.selectByExample(null);      //没有条件就查询所有数据

        //  查询功能之后可以获取分页相关的所有数据
        //  第二个参数：导航分页的页码数
        PageInfo<Emp> pageInfo = new PageInfo<>(list, 5);

        list.forEach(System.out::println);
        System.out.println(pageInfo);
    }

}
