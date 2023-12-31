package com.example.project1.services.impl;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.project1.services.MediaFileUploadService;

@Service
public class MediaFileUploadServiceImpl implements MediaFileUploadService {

    private final Cloudinary cloudinary;

    @Autowired
    public MediaFileUploadServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public Map uploadFile(MultipartFile multipartFile) throws IOException {
        cloudinary.config.secure = true;
        return cloudinary.uploader()
                .upload(multipartFile.getBytes(),
                        Map.of("public_id", UUID.randomUUID().toString()));
    }

    @Override
    public Map deletImage(String publicId) throws IOException {
        cloudinary.config.secure = true;
        return cloudinary.uploader().destroy(publicId, ObjectUtils.asMap("resource_type", "image"));
    }

}
