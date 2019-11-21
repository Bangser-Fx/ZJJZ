package com.zjjz.model.product;

import com.zjjz.common.model.ResponseResult;
import com.zjjz.common.model.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-10-30 20:42
 **/
@Data
@ToString
@NoArgsConstructor
public class UploadResult {

    private Boolean success;

    private String error;

    private String url;

    private String path;

    public UploadResult(Boolean success, String url,String path) {
        this.success = success;
        this.error = null;
        this.url = url;
        this.path = path;
    }

    public UploadResult(String error){
        this.success = false;
        this.error = error;
    }


}
