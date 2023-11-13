package com.jchhh.ssm.service;

import com.github.pagehelper.PageInfo;
import com.jchhh.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    /**
     * 查询所有的员工信息
     * @return 所有员工的 list
     */
    List<Employee> getAllEmployee();

    /**
     * 获取员工的分页信息
     * @return 分页类--list
     */
    PageInfo<Employee> getEmployeePage(Integer pageNum);

    /**
     * 保存一个用户
     * @param employee
     */
    void saveEmployee(Employee employee);

    /**
     * 通过名字获取用户
     */
    Employee getEmployeeByName(String name);

    /**
     * 根据旧名字 更新用户信息
     */
    void updateEmployee(String oldName, Employee employee);

    /**
     * 根据名字 删除一个用户
     */
    void deleteEmployee(String name);
}
