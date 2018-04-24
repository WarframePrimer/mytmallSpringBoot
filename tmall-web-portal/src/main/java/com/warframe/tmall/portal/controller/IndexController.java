package com.warframe.tmall.portal.controller;


import com.warframe.tmall.portal.service.PortalContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cynicism on 17/1/27.
 */
@Controller
public class IndexController {

    @Autowired
    private PortalContentService portalContentService;

    @Value("${big_ad_index}")
    private long Big_AD_INDEX;


    @RequestMapping("/index")
    public String index(Model model) {


        return "index";
    }
    @RequestMapping("/index2")
    public String index2() {

        return "index";
    }
    @RequestMapping("/sideBar/popupLogin")
    public String popupLogin() {

        return "popupLogin";
    }


    //[LString;{"buttonPositionTop":false,"buttonPositionLeft":false,"largeIcon":true,"assistantFirstStart":false,"showWarnings":true,"scriptVersion":1}
    @RequestMapping("/adguard-ajax-api/api")
    @ResponseBody
    public String adguard() {

        return "[LString;{\"buttonPositionTop\":false,\"buttonPositionLeft\":false,\"largeIcon\":true,\"assistantFirstStart\":false,\"showWarnings\":true,\"scriptVersion\":1}";
    }
}
