package com.shopping.service;

import com.shopping.entity.TbItem;
import com.shopping.universal.ShoppingResult;

import java.util.List;

public interface ItemService {

    TbItem selectByPrimaryKey(Long id);

    List<TbItem> getItemList(Integer page, Integer row);

    ShoppingResult createItem(TbItem item, String desc);

    void deleteItems(List<Long> ids);

    void updateItem(TbItem tbItem);

    void inStock(List<Long> ids);
}
