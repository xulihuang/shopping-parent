package com.shopping.view;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: xlh
 * @Description: 存储更新商品时的信息
 * @Date: Create in 17:08 2020/3/20 0020
 */
@Data
@Accessors(chain = true)
public class ItemVo implements Serializable {

    /**
     * 商品id，同时也是商品编号
     */
    private String id;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品卖点
     */
    private String sellPoint;

    /**
     * 商品价格，单位为：分
     */
    private long price;

    /**
     * 库存数量
     */
    private Integer num;

    /**
     * 商品条形码
     */
    private String barcode;

    /**
     * 商品图片
     */
    private String image;

    /**
     * 所属类目，叶子类目
     */
    private String cid;

    /**
     * 商品描述
     */
    private String desc;

    private String[] itemParams;

    private String itemParamId;
}
