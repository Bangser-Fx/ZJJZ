package com.zjjz.ucenter.mapper;

import com.zjjz.model.user.Admin;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author bangser
 * @version 1.0
 * @date 2019-10-31 16:38
 **/
@Mapper
public interface AdminMapper {

    /**
     * 根据用户名获取管理员
     * @param aname
     * @return
     */
    Admin findAdminByAname(String aname);


    /**
     * 查找该用户名的个数
     * @param aname
     * @return
     */
    Integer findAnameNumer(String aname);
}
