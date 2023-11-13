package com.jchhh.mybatis.utils;

import com.jchhh.mybatis.mapper.SpecialSQLMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class IdUtils {

    /**
     * 重置 某个表的主键id
     */
    public static void resetUserId(String tableName) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        //  先获取表的所有用户id
        List<Integer> list = mapper.getAllUserId(tableName);
        int index = 1;
        for (; index <= list.size(); ++index) {
            //  将 id 为 start的 修改为 end
            mapper.updateUserId(tableName, list.get(index - 1), index);
        }
    }

}
