package com.lc;


//import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.lc.mapper")
public class SpirngmvcApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpirngmvcApplication.class, args);
    }
}
