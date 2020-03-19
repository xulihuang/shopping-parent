package com.shopping.controller;

import com.shopping.constants.CommonConstants;
import com.shopping.service.PictureService;
import com.shopping.universal.PictureResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @Author: xlh
 * @Description:
 * @Date: Create in 15:29 2020/3/18 0018
 */
@Controller
@RequestMapping(CommonConstants.PIC)
public class PrictureController {

    @Resource
    private PictureService pictureService;

    /**
     * 上传图片
     * @param multipartFile
     * @return PictureResult
     */
    @RequestMapping("/upload")
    @ResponseBody
    public PictureResult upload(MultipartFile multipartFile) {
        // 上传图片
        PictureResult pictureResult = pictureService.uploadFile(multipartFile);
        // 返回上传结果
        return pictureResult;
    }
}
