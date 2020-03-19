package com.shopping.controller;


import com.github.pagehelper.PageInfo;
import com.shopping.constants.CommonConstants;
import com.shopping.universal.RestResponse;
import com.shopping.entity.TbItem;
import com.shopping.service.ItemService;
import com.shopping.universal.ShoppingResult;
import com.sun.tools.javac.jvm.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: xlh
 * @Description: 商品controller
 * @Date: Create in 10:27 2020/3/17 0017
 */
@Controller
@RequestMapping(CommonConstants.ITEM)
public class ItemController {

    @Resource
    private ItemService itemService;

    @RequestMapping("/get/{id}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long id) {
        return itemService.selectByPrimaryKey(id);
    }

    @RequestMapping("/list")
    @ResponseBody
    public RestResponse getItemlist(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "30") Integer rows) {
        List<TbItem> items = itemService.getItemList(page, rows);
        PageInfo<TbItem> pageInfo = new PageInfo<>(items);
        return RestResponse.result(Integer.valueOf(String.valueOf(pageInfo.getTotal())), items);
    }

    /**
     * 新增商品
     * @param item
     * @return ShoppingResult
     */
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ResponseBody
    public ShoppingResult saveItem(TbItem item) {
        return itemService.createItem(item);
    }
}
