package com.jchhh.ssm.dao.impl;

import com.jchhh.ssm.dao.employeeDao;
import com.jchhh.ssm.mapper.EmployeeMapper;
import com.jchhh.ssm.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class employeeDaoImpl implements employeeDao {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeMapper.saveEmployee(employee);
    }

    @Override
    public void deleteEmployee(String name) {
        employeeMapper.deleteEmployee(name);
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return employeeMapper.getEmployeeByName(name);
    }

    @Override
    public void updateEmployee(String oldName, Employee employee) {
        employeeMapper.updateEmployee(oldName, employee.getEmpName(),employee.getAge(),employee.getGender(),employee.getEmail());
    }
}
