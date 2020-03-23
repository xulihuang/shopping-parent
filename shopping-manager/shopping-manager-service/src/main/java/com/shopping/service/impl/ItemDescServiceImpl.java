package com.shopping.service.impl;

import com.shopping.entity.TbItemDesc;
import com.shopping.mapper.TbItemDescMapper;
import com.shopping.service.ItemDescService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: xlh
 * @Description: 存储商品描述
 * @Date: Create in 9:48 2020/3/20 0020
 */
@Service
public class ItemDescServiceImpl implements ItemDescService {

    @Resource
    private TbItemDescMapper itemDescMapper;

    @Override
    public void saveItemDesc(TbItemDesc itemDesc) {
        itemDescMapper.insert(itemDesc);
    }

    /**
     * 根据商品ID批量删除描述信息
     * @param ids
     */
    @Override
    public void deleteItemDesc(List<Long> ids) {
        itemDescMapper.deleteItemDesc(ids);
    }

    /**
     * 根据商品ID获取描述
     * @param id
     * @return
     */
    @Override
    public TbItemDesc getItemDescByItemId(String id) {
        return itemDescMapper.selectByPrimaryKey(Long.parseLong(id));
    }

    /**
     * 更新商品描述
     * @param itemDesc
     */
    @Override
    public void updateItemDesc(TbItemDesc itemDesc) {
        itemDescMapper.updateByPrimaryKeySelective(itemDesc);
    }

}
