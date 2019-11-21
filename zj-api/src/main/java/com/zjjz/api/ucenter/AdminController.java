package com.zjjz.api.ucenter;

import com.zjjz.common.model.*;
import com.zjjz.model.user.Admin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-10-31 17:00
 **/
@Api(value = "管理员的登录与退出",tags = {"管理员的登录与退出"})
public interface AdminController {

    /**
     * 管理员登录
     * @param loginRequest
     * @param response
     * @return
     */
    @ApiOperation("管理员登录")
    LoginResult<Admin> login(LoginRequest loginRequest, HttpServletResponse response);

    /**
     * 从缓存中获取用户信息
     * @param aid
     * @return
     */
    @ApiOperation("从缓存中获取用户信息")
    QueryResponseResult<Admin> getAdminFromRedis(Integer aid);

    /**
     * 管理员退出登录
     * @param request
     * @param response
     * @return
     */
    @ApiOperation("管理员退出")
    ResponseResult Logout(HttpServletRequest request, HttpServletResponse response);
}
