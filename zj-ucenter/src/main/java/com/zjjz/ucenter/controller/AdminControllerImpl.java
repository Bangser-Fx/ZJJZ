package com.zjjz.ucenter.controller;

import com.zjjz.api.ucenter.AdminController;
import com.zjjz.common.model.LoginRequest;
import com.zjjz.common.model.LoginResult;
import com.zjjz.common.model.QueryResponseResult;
import com.zjjz.common.model.ResponseResult;
import com.zjjz.model.user.Admin;
import com.zjjz.ucenter.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-10-31 17:10
 **/
@RestController
@RequestMapping("/ucenter/admin")
public class AdminControllerImpl implements AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    @Override
    public LoginResult<Admin> login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        return adminService.login(loginRequest,response);
    }

    @GetMapping("/get/{aid}")
    @Override
    public QueryResponseResult<Admin> getAdminFromRedis(@PathVariable("aid") Integer aid) {
        return adminService.getAdminFromRedis(aid);
    }

    @GetMapping("/logout")
    @Override
    public ResponseResult Logout(HttpServletRequest request,HttpServletResponse response) {
        return adminService.logout(request,response);
    }
}
