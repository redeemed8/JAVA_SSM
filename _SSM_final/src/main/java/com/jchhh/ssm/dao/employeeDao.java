package com.jchhh.ssm.dao;

import com.jchhh.ssm.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface employeeDao {

    /**
     * 获取所有用户信息
     */
    List<Employee> getAllEmployee();

    /**
     * 保存一个用户信息
     */
    void saveEmployee(Employee employee);

    /**
     * 根据 id删除一个用户信息
     */
    void deleteEmployee(String name);

    /**
     * 根据名字查询用户信息
     */
    Employee getEmployeeByName(String name);

    void updateEmployee(String oldName, Employee employee);
}
