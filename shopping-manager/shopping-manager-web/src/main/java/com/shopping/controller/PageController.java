package com.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: xlh
 * @Description: 页面controller
 * @Date: Create in 16:44 2020/3/17 0017
 */
@Controller
public class PageController {

    // 商品首页
    private static final String INDEX = "index";

    /**
     * 打开首页
     * @return
     */
    @RequestMapping("/")
    public String showIndex() {
        return INDEX;
    }

    /**
     * 展示其他页面
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }
}
