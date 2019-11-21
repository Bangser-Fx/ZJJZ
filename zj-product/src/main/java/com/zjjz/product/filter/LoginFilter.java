package com.zjjz.product.filter;

import com.zjjz.common.exception.ExceptionCast;
import com.zjjz.common.model.CommonCode;
import com.zjjz.common.utils.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-11-01 16:12
 **/
public class LoginFilter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, String> map = CookieUtil.readCookie(request, "admin");
        if(map==null || StringUtils.isBlank(map.get("admin"))){
            ExceptionCast.throwCustomException(CommonCode.UNAUTHORISE);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
