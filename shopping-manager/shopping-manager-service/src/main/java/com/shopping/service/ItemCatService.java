package com.shopping.service;

import com.shopping.entity.TbItemCat;

import java.util.List;

/**
 * @Author: xlh
 * @Description:
 * @Date: Create in 10:15 2020/3/18 0018
 */
public interface ItemCatService {

    List<TbItemCat> getItemCatList(Long parentId);
}
