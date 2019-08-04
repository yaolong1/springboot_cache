package com.example.springboot_cache.mapper;

import com.example.springboot_cache.bean.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author yaoLong
 * @date 2019/8/3  16:06
 *员工持久层
 */
@Repository
public interface IEmployeeMapper {

    /**
     * 根据id查找
     * @param id
     * @return
     */
    @Select("select * from employee where id=#{id} ")
    public Employee getEmpById(@Param("id") Integer id);

    /**
     * 更新员工
     * @param employee
     */
    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId}")
    public void updateEmp(@Param("employee")Employee employee);

    /**
     * 根据id删除员工
     * @param id
     */
    @Delete("delete from employee where id=#{id}")
    public void deleteEmpById(@Param("id") Integer id);

    /**
     * 插入（新增）员工
     * @param employee
     */
    @Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{d_id})")
    public void insertEmployee(@Param("employee") Employee employee);
}
