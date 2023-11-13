package com.jchhh.mybatis.mapper;

import com.jchhh.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {

    /**
     * 根据员工 id 查询员工信息
     */
    Emp getEmpById(@Param("empId") Integer empId);

    /**
     * 添加员工信息
     */
    void insertEmp(Emp emp);

}
