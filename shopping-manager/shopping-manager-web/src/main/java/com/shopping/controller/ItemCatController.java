package com.shopping.controller;

import com.shopping.constants.CommonConstants;
import com.shopping.entity.TbItemCat;
import com.shopping.service.ItemCatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xlh
 * @Description:
 * @Date: Create in 10:27 2020/3/18 0018
 */
@Controller
@RequestMapping(CommonConstants.ITEM_CAT)
public class ItemCatController {

    @Resource
    private ItemCatService itemCatService;

    /**
     * 获取商品类目树
     * @param parentId
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public List categoryList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
        List catList = new ArrayList();
        List<TbItemCat> list = itemCatService.getItemCatList(parentId);
        list.forEach(itemCat -> {
            Map node = new HashMap();
            node.put("id", itemCat.getId());
            node.put("text", itemCat.getName());
            node.put("state", itemCat.getIsParent() ? "closed" : "open");
            catList.add(node);
        });
        return catList;
    }
}
