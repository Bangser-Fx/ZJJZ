package com.zjjz.zull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author bangser
 */
@SpringBootApplication
@EnableZuulProxy
public class ZjZullApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZjZullApplication.class, args);
    }

}
