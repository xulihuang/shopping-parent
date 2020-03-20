package com.shopping.controller;

import com.shopping.constants.CommonConstants;
import com.shopping.service.ItemDescService;
import com.shopping.service.ItemService;
import com.shopping.universal.ShoppingResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
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

}
