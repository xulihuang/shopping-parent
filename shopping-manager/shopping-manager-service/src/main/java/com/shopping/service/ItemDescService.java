package com.shopping.service;

import com.shopping.entity.TbItemDesc;

import java.util.List;

/**
 * @Author: xlh
 * @Description: 商品描述存储
 * @Date: Create in 9:46 2020/3/20 0020
 */
public interface ItemDescService {

    void saveItemDesc(TbItemDesc itemDesc);

    void deleteItemDesc(List<Long> ids);
}
