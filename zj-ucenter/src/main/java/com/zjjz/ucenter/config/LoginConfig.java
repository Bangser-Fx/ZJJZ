package com.zjjz.ucenter.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "login")
@Data
@ToString
public class LoginConfig {
    private Integer tokenValiditySeconds;//令牌在redis的过期时间
    private String cookieDomain;    //验证通过后跳转的域名(前台)
    private String cookieDomainBS;    //验证通过后跳转的域名(后台)
    private Integer cookieMaxAge;   //cookie的存活时间（-1，当浏览器关闭则消除）
}
