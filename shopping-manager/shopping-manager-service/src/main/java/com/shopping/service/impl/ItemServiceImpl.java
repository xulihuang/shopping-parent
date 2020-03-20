package com.shopping.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.shopping.entity.TbItem;
import com.shopping.entity.TbItemDesc;
import com.shopping.mapper.TbItemMapper;
import com.shopping.service.ItemDescService;
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

    @Resource
    private ItemDescService descService;

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
     * @param desc
     * @return
     */
    @Override
    public ShoppingResult createItem(TbItem item, String desc) {
        Date date = new Date();
        Long itemId = IdUtil.getItemId();
        // 新增商品
        item.setId(itemId)
                .setStatus((byte) 1)
                .setCreated(date)
                .setUpdated(date);
        itemMapper.insert(item);

        // 设置商品描述信息
        if(!StringUtils.isEmpty(desc)) {
            TbItemDesc itemDesc = new TbItemDesc();
            itemDesc.setItemId(itemId)
                    .setItemDesc(desc)
                    .setCreated(date)
                    .setUpdated(date);
            descService.saveItemDesc(itemDesc);
        }
        return ShoppingResult.ok();
    }

    /**
     * 删除商品
     * @param ids
     */
    @Override
    public void deleteItems(List<Long> ids) {
        itemMapper.deleteItems(ids);
    }
}
