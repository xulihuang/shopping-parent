package com.shopping.universal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: xlh
 * @Description: 图片信息返回
 * @Date: Create in 14:33 2020/3/18 0018
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class PictureResult {
    /**
     * 上传图片返回值，成功：0	失败：1
     */
    private Integer error;
    /**
     * 回显图片使用的url
     */
    private String url;
    /**
     * 错误时的错误消息
     */
    private String message;

    private PictureResult(Integer error, String url) {
        this.error = error;
        this.url = url;
    }

    public static PictureResult result(Integer error, String url, String message) {
        return new PictureResult(error, url, message);
    }

    public static PictureResult result(Integer error, String url) {
        return new PictureResult(error, url);
    }
}
