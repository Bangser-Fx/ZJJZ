package com.zjjz.zull.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.zjjz.common.model.CommonCode;
import com.zjjz.common.model.ResponseResult;
import com.zjjz.zull.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-11-01 15:55
 **/
@Component
public class LoginFilter extends ZuulFilter {


    @Autowired
    private LoginService loginService;


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //获取上下文对象
        RequestContext requestContext = RequestContext.getCurrentContext();

        //从cookie中获取uid
        String token = loginService.getTokenFromCookie(requestContext.getRequest());
        if(token==null){
            refuseAccess(requestContext);
            return null;
        }
        if(!loginService.getTokenFromRedis(token)){
           refuseAccess(requestContext);
           return null;
        }
        return null;
    }


    //拒绝访问
    private void refuseAccess(RequestContext requestContext){
        requestContext.setSendZuulResponse(false);//拒绝访问
        requestContext.setResponseStatusCode(200);//设置响应码
        //设置相应体
        ResponseResult result = new ResponseResult(CommonCode.UNAUTHORISE);
        String jsonString = JSON.toJSONString(result);
        requestContext.setResponseBody(jsonString);
        requestContext.getResponse().setContentType("application/json;charset=UTF-8");
    }
}
