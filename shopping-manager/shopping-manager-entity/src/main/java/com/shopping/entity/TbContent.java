package com.shopping.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * tb_content
 * @author 
 */
@Data
@Accessors(chain = true)
public class TbContent implements Serializable {
    private Long id;

    /**
     * 内容类目ID
     */
    private Long categoryId;

    /**
     * 内容标题
     */
    private String title;

    /**
     * 子标题
     */
    private String subTitle;

    /**
     * 标题描述
     */
    private String titleDesc;

    /**
     * 链接
     */
    private String url;

    /**
     * 图片绝对路径
     */
    private String pic;

    /**
     * 图片2
     */
    private String pic2;

    /**
     * 内容
     */
    private String content;

    private Date created;

    private Date updated;

    private static final long serialVersionUID = 1L;
}