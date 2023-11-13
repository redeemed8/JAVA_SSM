package com.jchhh.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.jchhh.ssm.pojo.Employee;
import com.jchhh.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 查询所有的员工信息-->/employee-->get
 * 查询员工的分页信息-->/employee/page/1-->get
 * 跳转到添加页面-->/to/add-->get
 * 添加员工信息-->/employee-->post
 * 修改员工信息-->/employee-->put
 * 根据 id删除员工信息-->/employee/1-->delete
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee/page/{pageNum}", method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("pageNum") Integer pageNum, Model model) {
        //  获取员工的分页信息
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNum);
        //  将分页数据共享到请求域中
        model.addAttribute("page", page);
        return "employee_list";
    }

    //  在这里无实际用途，被上面的分页功能取代了
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model) {
        //  查询所有的员工信息
        List<Employee> list = employeeService.getAllEmployee();
        //  将员工信息在请求域中共享
        model.addAttribute("list", list);
        //  跳转到 employee_list.html
        return "employee_list";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String saveEmployee(Employee employee) {
        //  保存员工信息
        employeeService.saveEmployee(employee);
        //  重定向到列表功能    :/employee
        return "redirect:/employee/page/1";
    }

    @RequestMapping(value = "/employee/{name}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("name") String name, Model model) {
        //  根据名字查询员工信息
        Employee employee = employeeService.getEmployeeByName(name);
        //  将员工信息共享到请求域中
        model.addAttribute("employee", employee);
        //  跳转到 employee_update.html
        return "employee_update";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String updateEmployee(Employee employee,Model model) {
        //  获取以前的旧名字
        Employee oldEmp = (Employee) model.getAttribute("employee");
        String oldName = null;
        if(oldEmp != null){
            oldName = oldEmp.getEmpName();
        }
        System.out.println(oldName);
        //  修改员工信息
        employeeService.updateEmployee(oldName, employee);
        //  重定向到列表功能
        return "redirect:/employee/page/1";     //  不直接写employee的原因是，list那个页面只设置了接收分页功能
    }

    @RequestMapping(value = "/employee/{name}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("name") String name){
        //  删除员工信息
        employeeService.deleteEmployee(name);
        //  重定向到列表功能
        return "redirect:/employee/page/1";
    }

}
