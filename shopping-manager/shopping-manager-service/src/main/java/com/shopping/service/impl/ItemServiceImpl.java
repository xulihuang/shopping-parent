package com.shopping.service.impl;

import com.github.pagehelper.PageHelper;
import com.shopping.entity.TbItem;
import com.shopping.mapper.TbItemMapper;
import com.shopping.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
