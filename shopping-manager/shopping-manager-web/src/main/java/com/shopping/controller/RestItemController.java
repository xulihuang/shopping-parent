package com.shopping.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.shopping.constants.CommonConstants;
import com.shopping.entity.TbItem;
import com.shopping.service.ItemDescService;
import com.shopping.service.ItemService;
import com.shopping.universal.ShoppingResult;
import com.shopping.view.ItemVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: xlh
 * @Description:
 * @Date: Create in 10:19 2020/3/20 0020
 */
@Controller
@RequestMapping(CommonConstants.REST_ITEM)
public class RestItemController {

    @Resource
    private ItemDescService descService;

    @Resource
    private ItemService itemService;


    /**
     * 删除商品
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    @ResponseBody
    public ShoppingResult deleteItems(String ids) {
        List idList = Arrays.stream(ids.split(","))
                .map(s -> Long.parseLong(s.trim()))
                .collect(Collectors.toList());
        itemService.deleteItems(idList);
        descService.deleteItemDesc(idList);
        return ShoppingResult.ok();
    }

    /**
     * 根据商品ID查询商品
     * @param id
     * @return
     */
    @RequestMapping("/query/item/desc/{id}")
    @ResponseBody
    public ShoppingResult getItemById(@PathVariable String id) {
        return ShoppingResult.ok(descService.getItemDescByItemId(id));
    }

    /**
     * 根军商品ID查询规格
     * @param id
     * @return ShoppingResult
     */
    @RequestMapping("/param/item/query/{id}")
    @ResponseBody
    public ShoppingResult getItemParamById(@PathVariable String id) {
        return ShoppingResult.ok();
    }

    /**
     * 修改商品信息
     * @return ShoppingResult
     */
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    @ResponseBody
    public ShoppingResult updateItem(TbItem item) {
        // 更新商品
//        TbItem item = new TbItem();
//        BeanUtils.copyProperties(itemVo, item);

        // 更新商品描述
        return ShoppingResult.ok();
    }

}
