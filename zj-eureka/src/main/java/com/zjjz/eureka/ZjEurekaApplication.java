package com.zjjz.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author bangser
 */
@EnableEurekaServer
@SpringBootApplication
public class ZjEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZjEurekaApplication.class, args);
    }

}
