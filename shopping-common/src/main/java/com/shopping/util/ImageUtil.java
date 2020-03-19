package com.shopping.util;

import java.util.Random;

/**
 * @Author: xlh
 * @Description: 图片工具类
 * @Date: Create in 14:44 2020/3/18 0018
 */
public class ImageUtil {
    /**
     * 获取图片名称
     * @return
     */
    public static String getImageName() {
        StringBuffer stringBuffer = new StringBuffer("");
        long mills = System.currentTimeMillis();
        Random random = new Random();
        int end_3 = random.nextInt(999);
        // 不足三位前面补0
        stringBuffer.append(mills + String.format("%03d", end_3));
        return stringBuffer.toString();
    }
}
