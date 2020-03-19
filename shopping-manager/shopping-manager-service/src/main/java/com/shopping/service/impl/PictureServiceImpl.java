package com.shopping.service.impl;

import com.shopping.service.PictureService;
import com.shopping.universal.PictureResult;
import com.shopping.util.FtpUtil;
import com.shopping.util.ImageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: xlh
 * @Description:
 * @Date: Create in 14:52 2020/3/18 0018
 */
@Slf4j
@Service
public class PictureServiceImpl implements PictureService {

    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;
    @Value("${FILI_UPLOAD_PATH}")
    private String FILI_UPLOAD_PATH;
    @Value("${FTP_SERVER_IP}")
    private String FTP_SERVER_IP;
    @Value("${FTP_SERVER_PORT}")
    private Integer FTP_SERVER_PORT;
    @Value("${FTP_SERVER_USERNAME}")
    private String FTP_SERVER_USERNAME;
    @Value("${FTP_SERVER_PASSWORD}")
    private String FTP_SERVER_PASSWORD;


    @Override
    public PictureResult uploadFile(MultipartFile uploadFile) {
        String pictureUrl = savePicture(uploadFile);
        return PictureResult.result(0, IMAGE_BASE_URL + pictureUrl);
    }

    /**
     * 保存图片
     * @param multipartFile
     * @return
     */
    private String savePicture(MultipartFile multipartFile) {
        String pictureUrl = null;
        try {
            if (!multipartFile.isEmpty()) {
                // 上传文件以日期为单位分开存放，可以提高图片的查询速度
                String filePath = "/" + new SimpleDateFormat("yyyy").format(new Date())
                        + "/" + new SimpleDateFormat("MM").format(new Date())
                        + "/" + new SimpleDateFormat("dd").format(new Date());
                // 取原始文件名
                String originalFilename = multipartFile.getOriginalFilename();
                // 新文件名
                String newFileName = ImageUtil.getImageName() +
                        originalFilename.substring(originalFilename.lastIndexOf("."));
                // 上传图片
                FtpUtil.uploadFile(FTP_SERVER_IP, FTP_SERVER_PORT, FTP_SERVER_USERNAME
                        , FTP_SERVER_PASSWORD, FILI_UPLOAD_PATH, filePath
                        , newFileName, multipartFile.getInputStream());
                pictureUrl = filePath + "/" + newFileName;
            }
        } catch (Exception e) {
            log.error("上传文件失败：" + e.getMessage());
        }
        return pictureUrl;
    }
}
