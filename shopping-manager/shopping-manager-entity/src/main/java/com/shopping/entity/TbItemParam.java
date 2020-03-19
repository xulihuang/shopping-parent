package com.shopping.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * tb_item_param
 * @author 
 */
@Data
@Accessors(chain = true)
public class TbItemParam implements Serializable {
    private Long id;

    /**
     * 商品类目ID
     */
    private Long itemCatId;

    /**
     * 参数数据，格式为json格式
     */
    private String paramData;

    private Date created;

    private Date updated;

    private static final long serialVersionUID = 1L;
}