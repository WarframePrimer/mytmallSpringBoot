package com.warframe.tmall.item.controller;


import com.warframe.tmall.domain.TbItemDesc;
import com.warframe.tmall.item.service.ItemService;
import com.warframe.tmall.item.vo.TbItemVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 商品查询 Controller
 *
 * @author xubin.
 * @create 2017-02-06 下午3:50
 */

@Controller
@Slf4j
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{id}")
    public String  getItemByItemId(@PathVariable("id") Long itemId, Model model) {

        TbItemVO item = new TbItemVO(itemService.getItemById(itemId));

        TbItemDesc itemDesc = itemService.getItemDescById(itemId);

        model.addAttribute("item", item);
        model.addAttribute("itemDesc", itemDesc);

        return "item";
    }

}
