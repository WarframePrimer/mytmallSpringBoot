package com.warframe.tmall.controller;


import com.warframe.tmall.common.pojo.KindEditorResult;
import com.warframe.tmall.common.pojo.Result;
import com.warframe.tmall.common.utils.QiniuUtil;
import com.warframe.tmall.common.utils.ResultUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class ImageController {

    @RequestMapping(value = "/image/imageUpload",method = RequestMethod.POST)
    public Result<Object> uploadFile(@RequestParam("file") MultipartFile files,
                                     HttpServletRequest request){

        String imagePath=null;
        // 文件保存路径
        String filePath = request.getSession().getServletContext().getRealPath("/upload")+"\\"
                + QiniuUtil.renamePic(files.getOriginalFilename());
        // 转存文件
        try {
            //保存至服务器
            File file=new File((filePath));
            files.transferTo(file);
            //上传七牛云服务器
            imagePath= QiniuUtil.qiniuUpload(filePath);
            // 路径为文件且不为空则进行删除
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultUtil<Object>().setData(imagePath);
    }

    @RequestMapping(value = "/kindeditor/imageUpload",method = RequestMethod.POST)
    public KindEditorResult kindeditor(@RequestParam("imgFile") MultipartFile files, HttpServletRequest request){

        KindEditorResult kindEditorResult=new KindEditorResult();
        // 文件保存路径
        String filePath = request.getSession().getServletContext().getRealPath("/upload")+"\\"
                + QiniuUtil.renamePic(files.getOriginalFilename());
        //检查文件
        String message=QiniuUtil.isValidImage(request,files);
        if(!message.equals("valid")){
            kindEditorResult.setError(1);
            kindEditorResult.setMessage(message);
            return kindEditorResult;
        }
        // 转存文件
        try {
            //保存至服务器
            File file=new File((filePath));
            files.transferTo(file);
            //上传七牛云服务器
            String imagePath=QiniuUtil.qiniuUpload(filePath);
            // 路径为文件且不为空则进行删除
            if (file.isFile() && file.exists()) {
                file.delete();
            }
            kindEditorResult.setError(0);
            kindEditorResult.setUrl(imagePath);
            return kindEditorResult;
        } catch (IOException e) {
            e.printStackTrace();
        }
        kindEditorResult.setError(1);
        kindEditorResult.setMessage("上传失败");
        return kindEditorResult;
    }
}
