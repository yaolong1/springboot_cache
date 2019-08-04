package com.example.springboot_cache.service.impl;

import com.example.springboot_cache.bean.Employee;
import com.example.springboot_cache.mapper.IEmployeeMapper;
import com.example.springboot_cache.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yaoLong
 * @date 2019/8/3  16:25
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeMapper employeeMapper;
    @Override
    public Employee getEmpById(Integer id) {
        return employeeMapper.getEmpById(id);
    }

    @Override
    public void updateEmp(Employee employee) {
        employeeMapper.updateEmp(employee);
    }

    @Override
    public void deleteEmpById(Integer id) {
        employeeMapper.deleteEmpById(id);
    }

    @Override
    public void insertEmployee(Employee employee) {
        employeeMapper.insertEmployee(employee);
    }
}
