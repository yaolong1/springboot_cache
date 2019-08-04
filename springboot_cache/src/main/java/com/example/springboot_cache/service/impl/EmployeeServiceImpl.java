package com.example.springboot_cache.service.impl;

import com.example.springboot_cache.bean.Employee;
import com.example.springboot_cache.mapper.IEmployeeMapper;
import com.example.springboot_cache.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

    /**
     *  注解Cacheable:将方法的运行结果进行缓存；以后再要相同的数据，直接从缓存中获取，不用调用方法；
     *  CacheManager管理多个Cache组件的，对缓存的真正的CRUD操作在Cache组件中，每个缓存组件有有自己唯一的名字；
     *  几个属性：
     *      cacheNames/value:指定缓存组件的名字；
     *      key：缓存数据使用的key;可以用它来指定默认是使用方法参数的值 1-方法的返回值
     *          SpEL; #id;参数id的值
     *      keyGenerator:key的生成器 可以自己指定key的生成器的组件id
     *          keyGenerator/key：二选一使用
     *       cacheManager:指定缓存管理器；或者cacheResolver指定获取解析器
     *       condition:指定符合条件的情况下才缓存；
     *          condition=“#id>0”
     *       unless；否定缓存 当unless指定条件为true，方法返回值就不会被缓存；可以获取到结果进行判断
     *              unless =“#result==null”
     */
    @Cacheable(cacheNames = {"emp"})
    public Employee getEmpById(Integer id) {
        return employeeMapper.getEmpById(id);
    }

    /**
     *  @CachePut：即调用方法又更新缓存
     *  修改了数据库的某个数据，同时更新缓存
     * @param employee
     */
    @Override
    @CachePut(value = "emp",key = "#employee.id")
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
