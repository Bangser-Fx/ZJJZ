package com.zjjz.ucenter.service;

import com.alibaba.fastjson.JSON;
import com.zjjz.common.exception.ExceptionCast;
import com.zjjz.common.model.*;
import com.zjjz.common.utils.CookieUtil;
import com.zjjz.model.user.Admin;
import com.zjjz.ucenter.config.LoginConfig;
import com.zjjz.ucenter.mapper.AdminMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-10-31 16:57
 **/
@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private LoginConfig loginConfig;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 管理员登录
     * @param loginRequest
     * @param response
     * @return
     */
    public LoginResult<Admin> login(LoginRequest loginRequest, HttpServletResponse response) {
        if(loginRequest==null || StringUtils.isBlank(loginRequest.getUsername()) || StringUtils.isBlank(loginRequest.getPassword())){
            ExceptionCast.throwCustomException(CommonCode.INVALIDPARAM);
        }
        //验证登录
        Admin admin = adminMapper.findAdminByAname(loginRequest.getUsername());
        String password = DigestUtils.md5DigestAsHex(loginRequest.getPassword().getBytes());
        if(admin==null || !admin.getApassword().equals(password)){
            ExceptionCast.throwCustomException(CommonCode.LOGINFAIL);
        }
        //登录成功，将用户id写入cookie，并将用户信息存到redis
        admin.setApassword(null);
        CookieUtil.addCookie(response,loginConfig.getCookieDomainBS(),"/","admin",admin.getAid().toString(),loginConfig.getCookieMaxAge(),false);
//        String jsonString = JSON.toJSONString(admin);
//        redisTemplate.boundValueOps("admin:"+admin.getAid()).set(jsonString,loginConfig.getTokenValiditySeconds(), TimeUnit.SECONDS);
        return new LoginResult<>(CommonCode.LOGINSUCCESS,admin);
    }

    /**
     * 管理员退出登录
     * @param request
     * @param response
     * @return
     */
    public ResponseResult logout(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> map = CookieUtil.readCookie(request, "admin");
        if(map!=null && StringUtils.isNotBlank(map.get("admin"))){
            //删除cookie
            String aid = map.get("admin");
            CookieUtil.addCookie(response,loginConfig.getCookieDomainBS(),"/","admin",null,0,false);
        }
        return ResponseResult.SUCCESS();
    }

    /**
     * 根据用户id从redis中获取用户信息
     * @param aid
     * @return
     */
    public QueryResponseResult<Admin> getAdminFromRedis(Integer aid) {
        String adminJson = redisTemplate.boundValueOps("admin:"+aid.toString()).get();
        if(StringUtils.isBlank(adminJson)){
            ExceptionCast.throwCustomException(CommonCode.IDOVERTIME);
        }
        Admin admin = JSON.parseObject(adminJson, Admin.class);
        QueryResult<Admin> result = new QueryResult<>();
        result.setObj(admin);
        return new QueryResponseResult<>(CommonCode.SUCCESS,result);
    }
}
