package com.shopping.mapper;

import com.shopping.entity.TbItemDesc;

import java.util.List;

public interface TbItemDescMapper {
    int deleteByPrimaryKey(Long itemId);

    int insert(TbItemDesc record);

    int insertSelective(TbItemDesc record);

    TbItemDesc selectByPrimaryKey(Long itemId);

    int updateByPrimaryKeySelective(TbItemDesc record);

    int updateByPrimaryKey(TbItemDesc record);

    int deleteItemDesc(List<Long> ids);
}