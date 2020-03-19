package com.shopping.service.impl;

import com.github.pagehelper.PageHelper;
import com.shopping.entity.TbItem;
import com.shopping.mapper.TbItemMapper;
import com.shopping.service.ItemService;
import com.shopping.universal.ShoppingResult;
import com.shopping.util.IdUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 商品管理service
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private TbItemMapper itemMapper;

    @Override
    public TbItem selectByPrimaryKey(Long id) {
        return itemMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TbItem> getItemList(Integer page, Integer row) {
        PageHelper.startPage(page, row);
        return itemMapper.selectItemList();
    }

    /**
     * 新增商品
     * @param item
     * @return
     */
    @Override
    public ShoppingResult createItem(TbItem item) {
        Date date = new Date();
        Long itemId = IdUtil.getItemId();
        item.setId(itemId)
                .setStatus((byte) 1)
                .setCreated(date)
                .setUpdated(date);
        itemMapper.insert(item);
        return ShoppingResult.ok();
    }
}
