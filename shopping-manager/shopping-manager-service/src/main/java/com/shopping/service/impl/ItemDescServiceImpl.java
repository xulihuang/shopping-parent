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

    @Override
    public void deleteItemDesc(List<Long> ids) {
        itemDescMapper.deleteItemDesc(ids);
    }

}
