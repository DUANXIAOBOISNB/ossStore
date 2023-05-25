package com.example.oss.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public class uploadUtils {
    public static final String URL="https://myduanbucket.oss-cn-beijing.aliyuncs.com/";
    public static String uploadimages(MultipartFile file) throws IOException {
//        生成文件名
        String originalFilename = file.getOriginalFilename();
        String ext="."+originalFilename.split("\\.")[1];
        String uuid = UUID.randomUUID().toString();
        String filename=uuid+ext;
//        地域节点
        String endpoint="http://oss-cn-beijing.aliyuncs.com";
         String accesskeyid = "LTAI5tKrTXbZiAfiN8Qht3Mg";
        String accesskeysecret = "IfvxszrmvNU5P1v189bvjz9G0yA3Qe";
//        oss客户端对象
        OSS ossClient = new OSSClientBuilder().build(endpoint, accesskeyid, accesskeysecret);
        ossClient.putObject("myduanbucket",filename,file.getInputStream());
        ossClient.shutdown();
        return URL+filename;
    }

}
