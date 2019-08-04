package com.example.springboot_cache.controller;

import com.example.springboot_cache.bean.Employee;
import com.example.springboot_cache.service.IEmployeeService;
import com.example.springboot_cache.service.impl.EmployeeServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
     * @param id
     * @return
     */
    @GetMapping("/employee/{id}")
    @Cacheable(cacheNames = {"emp"})
    public Employee getEmployById(@PathVariable("id") Integer id){
        System.out.println(employeeService.getEmpById(id));
        return  employeeService.getEmpById(id);
    }
}
