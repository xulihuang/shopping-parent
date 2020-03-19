package com.shopping.service;

import com.shopping.universal.PictureResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: xlh
 * @Description: 图片服务
 * @Date: Create in 14:32 2020/3/18 0018
 */
public interface PictureService {

    PictureResult uploadFile(MultipartFile uploadFile);
}
