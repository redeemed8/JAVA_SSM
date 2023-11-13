package com.jchhh.mybatis.mapper;

import com.jchhh.mybatis.pojo.Dept;
import com.jchhh.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {

    /**
     * 通过分步查询 查询员工以及所对应的部门信息 的第二步
     */
    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);

    /**
     * 查询部门以及部门中的员工信息
     */
    Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);

    /**
     * 通过分步查询 查询部门以及部门中的员工信息的 第一步
     */
    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);

}
