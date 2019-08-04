package com.example.springboot_cache.controller;

import com.example.springboot_cache.bean.Employee;
import com.example.springboot_cache.service.IEmployeeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yaoLong
 * @date 2019/8/3  16:28
 */
@RestController
public class EmployeeController {

    @Resource
    IEmployeeService employeeService;

    /**
     * @param id
     * @return
     * 查询
     */
    @GetMapping("/getEmployee/{id}")
    public Employee getEmployById(@PathVariable("id") Integer id){
        System.out.println(employeeService.getEmpById(id));
        return  employeeService.getEmpById(id);
    }


    /**
     * @param employee
     * @return
     * 更新
     */

    @PostMapping(value = "/employee")
    public Employee updateEmp(@RequestBody Employee employee){
        System.out.println(employee+"--------------------------------------");
        employeeService.updateEmp(employee);
        return employee;
    }
}
