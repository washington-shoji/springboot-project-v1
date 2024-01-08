package com.example.project1.services;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface MediaFileUploadService {
    Map uploadFile(MultipartFile multipartFile) throws IOException;

    Map deletImage(String publicId) throws IOException;
}
