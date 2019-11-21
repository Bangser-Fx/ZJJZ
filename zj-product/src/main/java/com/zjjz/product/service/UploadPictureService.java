package com.zjjz.product.service;

import com.zjjz.common.exception.ExceptionCast;
import com.zjjz.common.model.CommonCode;
import com.zjjz.common.model.ResponseResult;
import com.zjjz.model.product.UploadResult;
import org.apache.commons.lang3.StringUtils;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-10-30 21:04
 **/
@Service
public class UploadPictureService {

    @Value("${MyPicBaseUrl}")
    private String baseUrl;

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    public UploadResult uploadPic(MultipartFile file) {
        if (!isImage(file)) {
            ExceptionCast.throwCustomException(CommonCode.UNALLOWFILE);
        }
        String url = upload(file);
        if (StringUtils.isBlank(url)) {
            ExceptionCast.throwCustomException(CommonCode.SERVER_ERROR);
        }
        return new UploadResult(true,baseUrl+url,url);
    }

    //判断是否是图片
    private boolean isImage(MultipartFile file) {
        try {
            // 通过ImageReader来解码这个file并返回一个BufferedImage对象
            // 如果找不到合适的ImageReader则会返回null，我们可以认为这不是图片文件
            // 或者在解析过程中报错，也返回false
            Image image = ImageIO.read(file.getInputStream());
            return image != null;
        } catch (IOException ex) {
            return false;
        }
    }

    //上传图片文件
    private String upload(MultipartFile file) {
        try {
            ClientGlobal.initByProperties("config/fastdfs-client.properties");
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            StorageClient storageClient = new StorageClient1(trackerServer, storageServer);
            String filename = file.getOriginalFilename();
            String extName = filename.substring(filename.lastIndexOf(".") + 1);
            String[] strings = storageClient.upload_file(file.getBytes(), extName, null);
            if (strings != null && strings.length == 2) {
                String fileId = strings[0] + "/" + strings[1];
                return fileId;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String url = "group1/M00/00/00/rBECR125mLiAOMNvAAA0.jpg";
        System.out.println(url.startsWith("group"));
        System.out.println(url.length()-url.lastIndexOf(".")-1);
        String groupName = url.substring(0, url.indexOf('/'));
        String name = url.substring(url.indexOf('/')+1);
        System.out.println(groupName);
        System.out.println(name);
    }
    /**
     * 删除fastDfs中的图片
     * @param url
     * @return
     */
    public UploadResult delete(String url) {
        //判断url的正确性
        if(!url.startsWith("group") || (url.length()-url.lastIndexOf(".")-1)!=3){
            ExceptionCast.throwCustomException(CommonCode.INVALIDPARAM);
        }
        try {
            ClientGlobal.initByProperties("config/fastdfs-client.properties");
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            StorageClient storageClient = new StorageClient1(trackerServer, storageServer);
            String groupName = url.substring(0, url.indexOf('/'));
            String remoteFilename = url.substring(url.indexOf('/') + 1);
            int i = storageClient.delete_file(groupName, remoteFilename);
            if(i!=-1){// 0表示删除成功 -1表示删除失败 2表示该文件不存在
                return new UploadResult(true,null,null);
            }
            return new UploadResult("删除文件失败");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new UploadResult("删除文件失败");
    }
}
