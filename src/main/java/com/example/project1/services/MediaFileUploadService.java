package com.example.project1.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface MediaFileUploadService {
    String uploadFile(MultipartFile multipartFile) throws IOException;
}
