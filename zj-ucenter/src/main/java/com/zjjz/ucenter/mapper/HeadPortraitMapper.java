package com.zjjz.ucenter.mapper;

import com.zjjz.model.user.Headportrait;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-10-31 16:31
 **/
@Mapper
public interface HeadPortraitMapper {

    /**
     * 查找所有头像信息
     * @return
     */
    List<Headportrait> findAllHeadPortrait();

    /**
     * 根据id查找头像信息
     * @param hid
     * @return
     */
    Headportrait findHeadPortraitById(Integer hid);
}
