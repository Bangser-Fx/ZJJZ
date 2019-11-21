package com.zjjz.ucenter.service;

import com.zjjz.common.exception.ExceptionCast;
import com.zjjz.common.model.CommonCode;
import com.zjjz.common.model.QueryResponseResult;
import com.zjjz.common.model.QueryResult;
import com.zjjz.model.user.Headportrait;
import com.zjjz.ucenter.mapper.HeadPortraitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-10-31 17:13
 **/
@Service
public class HeadPortraitService {

    @Autowired
    private HeadPortraitMapper mapper;

    /**
     * 获取所有头像信息
     * @return
     */
    public QueryResponseResult<Headportrait> findAllHeadPortrait() {
        List<Headportrait> allHeadPortrait = mapper.findAllHeadPortrait();
        if(allHeadPortrait==null){
            ExceptionCast.throwCustomException(CommonCode.SERVER_ERROR);
        }
        QueryResult<Headportrait> result = new QueryResult<>();
        result.setList(allHeadPortrait);
        result.setTotal(allHeadPortrait.size());
        return new QueryResponseResult<>(CommonCode.SUCCESS,result);
    }

    /**
     * 根据id获取头像信息
     * @param hid
     * @return
     */
    public QueryResponseResult<Headportrait> findHeadPortraitByHid(Integer hid) {
        Headportrait portrait = mapper.findHeadPortraitById(hid);
        if(portrait==null){
            ExceptionCast.throwCustomException(CommonCode.SERVER_ERROR);
        }
        QueryResult<Headportrait> result = new QueryResult<>();
        result.setObj(portrait);
        result.setTotal(1);
        return new QueryResponseResult<>(CommonCode.SUCCESS,result);
    }
}
