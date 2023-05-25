package com.example.oss.Controller;

import com.example.oss.utils.uploadUtils;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class uploadController {
    @PostMapping("/upload")
    public String  upload(MultipartFile file) throws IOException {
        if(file.isEmpty())
        {
            return "uploaddefeat1";
            
        }
        String originalFilename = file.getOriginalFilename();
        String ext="."+originalFilename.split("\\.")[1];
        String uuid = UUID.randomUUID().toString();
        String filename=uuid+ext;


        
//        上传图片
        ApplicationHome applicationHome=new ApplicationHome(this.getClass());
        String path = applicationHome.getDir().getParentFile().getAbsolutePath();
       String filepath=path+filename;
        file.transferTo(new File(filepath));
        return "sucess";
    }
    @PostMapping("/upimages")
    public String upimges(MultipartFile file) throws IOException {
        String msg = uploadUtils.uploadimages(file);
        return msg;
    }
}
