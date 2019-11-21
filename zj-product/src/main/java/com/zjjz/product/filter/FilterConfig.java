package com.zjjz.product.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-11-01 16:23
 **/
@Configuration
public class FilterConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginFilter())
                .addPathPatterns("/product/add")
                .addPathPatterns("/product/update/**")
                .addPathPatterns("/product/delete/**");
    }
}
