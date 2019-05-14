package com.shop.cloth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@ComponentScan(basePackages = { "com.shop.cloth.core.common", "com.shop.cloth.core.service","com.shop.cloth.core.dal","com.shop.cloth.web"})
@MapperScan(basePackages = {"com.shop.cloth.core.dal.dao"})
@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class},scanBasePackages = "com.shop.cloth")

public class ClothApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClothApplication.class, args);
    }

}
