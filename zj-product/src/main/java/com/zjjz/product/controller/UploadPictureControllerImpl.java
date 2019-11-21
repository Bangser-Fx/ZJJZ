package com.zjjz.product.controller;

import com.zjjz.api.product.UploadPictureController;
import com.zjjz.common.model.ResponseResult;
import com.zjjz.model.product.UploadResult;
import com.zjjz.product.service.UploadPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-10-30 20:53
 **/
@RestController
@RequestMapping("/product/pic")
public class UploadPictureControllerImpl implements UploadPictureController {

    @Autowired
    private UploadPictureService pictureService;

    @PostMapping("/upload")
    @Override
    public UploadResult uploadPic(MultipartFile file) {
        return pictureService.uploadPic(file);
    }

    @GetMapping("/delete")
    @Override
    public UploadResult deletePic(String url) {
        return pictureService.delete(url);
    }
}
