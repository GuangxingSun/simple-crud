package com.guangxing.controller;

import com.guangxing.dao.DepartmentDao;
import com.guangxing.dao.EmployeeDao;
import com.guangxing.entities.Department;
import com.guangxing.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

/**
 * 查询员工控制类
 *
 * @author Guangxing
 * @create time 2020/3/30 15:55
 **/
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model){

        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }
    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面，查出所有的部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    //添加员工信息
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名称
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        //来到员工列表页面
        System.out.println("保存的员工信息："+employee);
        employeeDao.save(employee);
        //redirect:表示重定向到一个地址    /代表当前项目路径
        //forward:表示转发到一个地址
        return "redirect:/emps";
    }

    //来修改页面，查处员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        model.addAttribute("emp",employeeDao.get(id));


        //来到添加页面，查出所有的部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        //回到修改页面（add是一个修改添加二合一的页面）
        return "emp/add";

    }

    //员工修改,需要提供员工id
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除员工
    @DeleteMapping("/emp/{id}")
    public String deleteEmploee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
