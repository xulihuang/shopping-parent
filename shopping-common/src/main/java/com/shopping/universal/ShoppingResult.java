package com.shopping.universal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: xlh
 * @Description:
 * @Date: Create in 16:11 2020/3/19 0019
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class ShoppingResult<T> {

    /**
     * 状态
     */
    private Integer status;

    /**
     * 信息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    public static <T> ShoppingResult<T> build(Integer status, String msg, T data) {
        return new ShoppingResult(status, msg, data);
    }

    public static <T> ShoppingResult<T> ok(T data) {
        return new ShoppingResult(200, "成功", data);
    }

    public static <T> ShoppingResult<T> ok() {
        return new ShoppingResult(200, "成功", null);
    }
}
