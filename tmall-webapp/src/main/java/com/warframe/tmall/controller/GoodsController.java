package com.warframe.tmall.controller;

import cn.exrick.search.service.SearchItemService;
import cn.exrick.search.service.SearchService;
import com.warframe.tmall.common.pojo.AllGoodsResult;
import com.warframe.tmall.common.pojo.Result;
import com.warframe.tmall.common.utils.ResultUtil;
import com.warframe.tmall.domain.dto.front.ProductDet;
import com.warframe.tmall.domain.dto.front.ProductHome;
import com.warframe.tmall.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {

    @Autowired
    private ContentService contentService;
    @Autowired
    private SearchService searchService;
    @Autowired
    private SearchItemService searchItemService;

    @RequestMapping(value = "/goods/productHome", method = RequestMethod.GET)
    public Result<ProductHome> getProductHome() {

        ProductHome productHome = contentService.getProductHome();
        return new ResultUtil<ProductHome>().setData(productHome);
    }

    @RequestMapping(value = "/goods/productDet", method = RequestMethod.GET)
    public Result<ProductDet> getProductDet(Long productId) {

        ProductDet productDet = contentService.getProductDet(productId);
        return new ResultUtil<ProductDet>().setData(productDet);
    }

    @RequestMapping(value = "/goods/allGoods", method = RequestMethod.GET)
    public Result<AllGoodsResult> getAllProduct(@RequestParam(defaultValue = "1") int page,
                                                @RequestParam(defaultValue = "20") int size,
                                                @RequestParam(defaultValue = "") String sort,
                                                @RequestParam(defaultValue = "-1") int priceGt,
                                                @RequestParam(defaultValue = "-1") int priceLte) {

        AllGoodsResult allGoodsResult = contentService.getAllProduct(page, size, sort, priceGt, priceLte);
        return new ResultUtil<AllGoodsResult>().setData(allGoodsResult);
    }

    @RequestMapping(value = "/goods/search", method = RequestMethod.GET)
    public Result<SearchResult> searchProduct(@RequestParam(defaultValue = "") String key,
                                              @RequestParam(defaultValue = "1") int page,
                                              @RequestParam(defaultValue = "20") int size,
                                              @RequestParam(defaultValue = "") String sort,
                                              @RequestParam(defaultValue = "-1") int priceGt,
                                              @RequestParam(defaultValue = "-1") int priceLte) {

        SearchResult searchResult = searchService.search(key, page, size, sort, priceGt, priceLte);
        return new ResultUtil<SearchResult>().setData(searchResult);
    }

    @RequestMapping(value = "/goods/importIndex", method = RequestMethod.GET)
    public String searchProduct() {

        searchItemService.importAllItems();
        return "callback({})";
    }

    private class SearchResult {
    }
}
