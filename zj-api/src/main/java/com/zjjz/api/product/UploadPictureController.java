package com.zjjz.api.product;

import com.zjjz.common.model.Response;
import com.zjjz.common.model.ResponseResult;
import com.zjjz.model.product.UploadResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-10-30 20:52
 **/
@Api(value = "商品图片管理",tags = {"商品图片管理"})
public interface UploadPictureController {

    /**
     * 上传图片
     * @param file
     * @return
     */
    @ApiOperation("上传图片")
    UploadResult uploadPic(MultipartFile file);

    /**
     * 删除图片
     * @param url
     * @return
     */
    @ApiOperation("删除图片")
    UploadResult deletePic(String url);
}
