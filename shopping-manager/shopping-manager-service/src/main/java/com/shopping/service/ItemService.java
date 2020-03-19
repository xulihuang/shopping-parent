package com.shopping.service;

import com.shopping.entity.TbItem;

import java.util.List;

public interface ItemService {

    TbItem selectByPrimaryKey(Long id);

    List<TbItem> getItemList(Integer page, Integer row);
}
