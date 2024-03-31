package com.yuanlrc.school;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.yuanlrc.*.mapper")
@SpringBootApplication
public class NiceschoolapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NiceschoolapiApplication.class, args);
    }
}


