package com.example.springboot_cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 快速体验缓存
 *      步骤：
 *           1、开启基于注解的缓存 @EnableCaching
 *           2、标注缓存注解即可
 *                  @Cacheable 主要针对方法配置，能够根据方法的请求参数对其结果进行缓存
 *                  @CacheEvict 清空缓存
 *                  @CachePut 保证方法被调用，又希望结果被缓存。
 */
@SpringBootApplication
@MapperScan("com.example.springboot_cache.mapper")
@EnableCaching
public class SpringbootCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCacheApplication.class, args);
    }

}
