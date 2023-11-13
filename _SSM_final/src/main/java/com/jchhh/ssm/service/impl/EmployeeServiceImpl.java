package com.jchhh.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jchhh.ssm.dao.employeeDao;
import com.jchhh.ssm.dao.impl.employeeDaoImpl;
import com.jchhh.ssm.mapper.EmployeeMapper;
import com.jchhh.ssm.pojo.Employee;
import com.jchhh.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private employeeDao employeeDao;

    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }

    public PageInfo<Employee> getEmployeePage(Integer pageNum) {
        //  开启分页功能
        PageHelper.startPage(pageNum, 5);
        //  查询所有的员工信息
        List<Employee> list = employeeDao.getAllEmployee();
        //  获取分页相关数据
        PageInfo<Employee> page = new PageInfo<>(list, 5);
        return page;
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeDao.saveEmployee(employee);
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return employeeDao.getEmployeeByName(name);
    }

    @Override
    public void updateEmployee(String oldName, Employee employee) {
        employeeDao.updateEmployee(oldName,employee);
    }

    @Override
    public void deleteEmployee(String name) {
        employeeDao.deleteEmployee(name);
    }

}
