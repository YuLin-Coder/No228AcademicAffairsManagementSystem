package com.yuanlrc.school.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public interface UploadService {

    public String upload(MultipartFile file) throws IOException, NoSuchAlgorithmException;
}
