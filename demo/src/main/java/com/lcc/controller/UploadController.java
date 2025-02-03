package com.lcc.controller;

import com.lcc.pojo.Result;
import com.lcc.util.AliOSSUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;

    private static Logger log = LoggerFactory.getLogger(UploadController.class);

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        // 获取上传文件名，以日志方式输出
        log.info("上传文件名:{}", file.getOriginalFilename());
        String url = aliOSSUtils.upload(file);
        log.info("文件上传完成，返回文件地址:{}", url);
        return Result.success(url);
    }
}