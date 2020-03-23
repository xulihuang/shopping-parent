package com.shopping.controller;

import com.shopping.constants.CommonConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: xlh
 * @Description:
 * @Date: Create in 16:21 2020/3/20 0020
 */
@Controller
@RequestMapping(CommonConstants.REST_PAGE)
public class RestPageController {

    private static final String ITEM_EDIT = "item-edit";

    @RequestMapping("/item-edit")
    public String getItemPage(@RequestParam String _) {
        return ITEM_EDIT;
    }
}
