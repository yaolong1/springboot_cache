package com.example.springboot_cache.service;

import com.example.springboot_cache.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @author yaoLong
 * @date 2019/8/3  16:24
 */
public interface IEmployeeService {
    /**
     * 根据id查找
     * @param id
     * @return
     */
    public Employee getEmpById(Integer id);

    /**
     * 更新员工
     * @param employee
     */
    public void updateEmp(Employee employee);

    /**
     * 根据id删除员工
     * @param id
     */

    public void deleteEmpById(Integer id);

    /**
     * 插入（新增）员工
     * @param employee
     */
    public void insertEmployee(Employee employee);
}
