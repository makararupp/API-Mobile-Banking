package com.makaradev.sp4_mybatis.service;

import com.makaradev.sp4_mybatis.model.FileUpload;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    FileUpload uploadFile(MultipartFile file);
}
