package com.lc.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/***
 * mybatisplus 的 拦截器插件
 *
 */


@Configuration
@MapperScan("com.lc.mapper")
public class MyBatisPlusConfig {

    @Bean  //乐观锁拦截器
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    @Bean  //分页插件
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    @Bean
    @Profile({"dev", "test"})  //设置dev  test环境开启
    public PerformanceInterceptor performanceIntercepter() {
        PerformanceInterceptor performanceIntercepter =  new PerformanceInterceptor();
        performanceIntercepter.setMaxTime(1);//设置允许sql最大执行时间
        performanceIntercepter.setFormat(true);
        return performanceIntercepter;
    }
}
