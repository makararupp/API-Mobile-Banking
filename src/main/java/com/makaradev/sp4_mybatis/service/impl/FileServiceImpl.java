package com.makaradev.sp4_mybatis.service.impl;

import com.makaradev.sp4_mybatis.model.FileUpload;
import com.makaradev.sp4_mybatis.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Value("${file.server-path}")
    private String fileServerPath;
    @Override
    public FileUpload uploadFile(MultipartFile file) {
        //Generate unique filename
        String fileName  = UUID.randomUUID().toString();

        //Get file extension {result = 1.jpg, 2.png, ...}
        int lastIndexOfDof = file.getOriginalFilename().lastIndexOf(".")+1;
        String extension = file.getOriginalFilename().substring(lastIndexOfDof);

        fileName = String.format("%s.%s", fileName, extension);
        Path path = Paths.get(fileServerPath +fileName);

        try {
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace(); // or use a logger
            return new FileUpload("".getBytes(), false);
        }
        return new FileUpload(fileName.getBytes(), true);
    }
}
