package com.yuanlrc.school.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuanlrc.school.entity.Rescource;
import com.yuanlrc.school.service.UploadService;
import com.yuanlrc.school.common.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {

    @Override
    public String upload(MultipartFile file) throws IOException, NoSuchAlgorithmException {
        byte[] data = file.getBytes();
        Rescource rescource = new Rescource();
        QueryWrapper<Rescource> wrapper = new QueryWrapper<>();
        String hash = FileUtil.calcETag(file.getInputStream(),file.getSize());
        wrapper.eq("hash",hash);
        wrapper.eq("source","local");
        rescource = rescource.selectOne(wrapper);
        if( rescource!= null){
            return rescource.getWebUrl();
        }
        String extName = file.getOriginalFilename().substring(
                file.getOriginalFilename().lastIndexOf("."));
        String fileName = UUID.randomUUID() + extName;
        String contentType = file.getContentType();
        StringBuffer sb = new StringBuffer(ResourceUtils.getURL("classpath:").getPath());
        String filePath = sb.append("static/upload/").toString();
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(data);
        out.flush();
        out.close();
        String webUrl = "/static/upload/"+fileName;
        rescource = new Rescource();
        rescource.setFileName(fileName);
        rescource.setFileSize(new java.text.DecimalFormat("#.##").format(file.getSize()/1024)+"kb");
        rescource.setHash(hash);
        rescource.setFileType(contentType);
        rescource.setWebUrl(webUrl);
        rescource.setSource("local");
        rescource.insert();
        return webUrl;
    }
}
