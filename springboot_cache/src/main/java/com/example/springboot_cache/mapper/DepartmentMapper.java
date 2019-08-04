package com.example.springboot_cache.mapper;

import org.springframework.stereotype.Repository;

/**
 * @author yaoLong
 * @date 2019/8/3  16:07
 * 部门持久层
 */
@Repository
public interface DepartmentMapper {
    /**
     * 根据id查找
     */
    public void finDepartmentdById(Integer id);
}
