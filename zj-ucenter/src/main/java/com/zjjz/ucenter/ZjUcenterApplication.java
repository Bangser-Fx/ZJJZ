package com.zjjz.ucenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author bangser
 */
@EnableEurekaClient
@SpringBootApplication
@EntityScan("com.zjjz.model.user")//扫描实体类
@ComponentScan(basePackages = {"com.zjjz"})
public class ZjUcenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZjUcenterApplication.class, args);
    }

}
