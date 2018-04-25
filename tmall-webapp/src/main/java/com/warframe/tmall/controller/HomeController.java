//package com.warframe.tmall.controller;
//
//import com.warframe.tmall.domain.web.Category;
//import com.warframe.tmall.domain.web.Product;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
///**
// * @author yaojiabin
// * @Description'
// * @date 2018-04-17 15:07
// */
//@Slf4j
//@Controller
//@RequestMapping("/home")
//public class HomeController {
//
////    @Autowired
////    private CategoryService categoryService;
////
////    @Autowired
////    private ProductService productService;
//
//    /**
//     * register.do和login.do只是单纯的到指定的页面，没有任何额外操作
//     *
//     * @return
//     */
//
//    @RequestMapping("/f_register")
//    public String register() {
//
//        return "/frontPage/register";
//    }
//
//    @RequestMapping("/f_login")
//    public String login() {
//
//        return "/frontPage/login";
//    }
//
//
//    //首页
//    @RequestMapping("/")
//    public String home() {
//
////        //获取所有分类
////        List<Category> categoryList = categoryService.listAll();
////
////        for (Category category : categoryList) {
////            List<Product> productList = productService.listProductByCategoryId(0, productService.getTotalNumberByCategoryId(category.getId()), category.getId());
////
////
////            //将该分类的所有商品都赋值给category的products属性
////            category.setProducts(productList);
////
////            //给每个分类设置productsByRow
////            category.setProductsByRow(category.createProductsByRows(productList));
////
////
////        }
////
////
////        modelAndView.addObject("categoryList", categoryList);
////        //modelAndView.addObject("productsByCategoryMap", productsByCategoryMap);
//        return "/frontPage/home";
//    }
//
//
//}
