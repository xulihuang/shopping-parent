package com.shopping;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shopping.entity.TbItem;
import com.shopping.mapper.TbItemMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author: xlh
 * @Description:
 * @Date: Create in 17:22 2020/3/17 0017
 */
public class PagehelperTest {

    @Test
    public void PagehelperTest() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-*.xml");
        TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);
        PageHelper.startPage(1, 10);
        List<TbItem> items = mapper.selectItemList();
        System.out.println(JSONObject.toJSONString(items));
        PageInfo<TbItem> pageInfo = new PageInfo<>(items);
        long total = pageInfo.getTotal();
        System.out.printf(String.valueOf(total));
    }
}
