package com.jchhh.ssm.mapper;

import com.jchhh.ssm.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    /**
     * 查询所有的员工信息
     *
     * @return list
     */
    List<Employee> getAllEmployee();

    /**
     * 添加一个员工
     */
    void saveEmployee(Employee employee);

    /**
     * 根据 name删除一个用户信息
     */
    void deleteEmployee(@Param("name") String name);

    /**
     * 根据 name查询一个用户信息
     */
    Employee getEmployeeByName(@Param("name") String name);

    /**
     * 根据名字 更新用户信息
     */
    void updateEmployee(@Param("oldName") String oldName, @Param("empName") String empName, @Param("age") Integer age,
                        @Param("gender") String gender, @Param("email") String email);
}
