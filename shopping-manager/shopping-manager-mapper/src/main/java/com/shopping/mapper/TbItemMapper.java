package com.shopping.mapper;

import com.shopping.entity.TbItem;

import java.util.List;

public interface TbItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    TbItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);

    List<TbItem> selectItemList();

    int deleteItems(List<Long> ids);

    List<TbItem> selectItemListByIds(List<Long> ids);

    int updateBatch(List<TbItem> items);
}