package com.shopping.service.impl;

import com.shopping.entity.TbItemCat;
import com.shopping.mapper.TbItemCatMapper;
import com.shopping.service.ItemCatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: xlh
 * @Description:
 * @Date: Create in 10:16 2020/3/18 0018
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Resource
    private TbItemCatMapper itemCatMapper;

    /**
     * 获取商品类目
     * @param parentId
     * @return List<TbItemCat>
     */
    @Override
    public List<TbItemCat> getItemCatList(Long parentId) {
        return itemCatMapper.selectItemCatListByParentId(parentId);
    }
}
