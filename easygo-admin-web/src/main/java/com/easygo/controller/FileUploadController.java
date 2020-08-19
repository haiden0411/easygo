package com.easygo.controller;

import com.easygo.utils.FastDFSClient;
import com.easygo.utils.MessageResults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author：胡灯
 * Date：2020-08-19 22:42
 * Description：<描述>
 */
@Controller
@Scope("prototype")
public class FileUploadController {
    @Value("${FILE_SERVER_URL}")
    private String FILE_SERVER_URL;

    @RequestMapping("/file_upload")
    @ResponseBody
    public MessageResults uploadImg(MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        System.out.println("上传的原始文件名是："+originalFilename);
        //获取文件名后缀
        String extentname = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        System.out.println("文件后缀为："+extentname);

        try {
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:config/fdfs_client.conf");
            String url = fastDFSClient.uploadFile(file.getBytes(), extentname);
            String fullpath = FILE_SERVER_URL+url;
            System.out.println("文件上传后全地址是："+fullpath);
            return new MessageResults(200,fullpath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new MessageResults(500,null);
    }

}
