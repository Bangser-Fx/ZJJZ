package com.zjjz.zull.service;

import com.zjjz.common.utils.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-11-01 15:55
 **/
@Service
public class LoginService {


    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 获取cookie中的用户信息
     * @param request
     * @return
     */
    public String getTokenFromCookie(HttpServletRequest request) {
        Map<String, String> map = CookieUtil.readCookie(request,  "uid");
        if(map!=null && StringUtils.isNotBlank(map.get("uid"))){
            return map.get("uid");
        }
        return null;
    }

    /**
     * 判断redis中是否含有用户信息
     * @param uid
     * @return
     */
    public boolean getTokenFromRedis(String uid){
        String s = redisTemplate.boundValueOps(uid).get();
        return !StringUtils.isBlank(s);
    }
}
