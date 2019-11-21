package com.zjjz.ucenter.controller;

import com.zjjz.api.ucenter.HeadPortraitController;
import com.zjjz.common.model.QueryResponseResult;
import com.zjjz.model.user.Headportrait;
import com.zjjz.ucenter.service.HeadPortraitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-10-31 17:13
 **/
@CrossOrigin
@RestController
@RequestMapping("/ucenter/headportrait")
public class HeadPortraitControllerImpl implements HeadPortraitController {

    @Autowired
    private HeadPortraitService service;

    @GetMapping("/findAll")
    @Override
    public QueryResponseResult<Headportrait> findAllHeadPortrait() {
        return service.findAllHeadPortrait();
    }

    @GetMapping("/get/{hid}")
    @Override
    public QueryResponseResult<Headportrait> findHeadPortraitByHid(@PathVariable("hid") Integer hid) {
        return service.findHeadPortraitByHid(hid);
    }
}
