package com.dl.blog_app.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dl.blog_app.services.FileService;

@Service
public class FileServiceImpl implements FileService {

    // Implements the uploadImage method
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        String name = file.getOriginalFilename();

        if (name == null || name.isEmpty()) {
            throw new IOException("Invalid file name");
        }

        String randomID = UUID.randomUUID().toString();
        String fileExtension = name.substring(name.lastIndexOf("."));
        String fileNameWithUUID = randomID + fileExtension;

        String filePath = path + File.separator + fileNameWithUUID;

        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        Path targetLocation = Paths.get(filePath);
        Files.copy(file.getInputStream(), targetLocation);

        return fileNameWithUUID;
    }

    // Implements the getResource method
    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath = path + File.separator + fileName;

        File file = new File(fullPath);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + fileName);
        }

        return new FileInputStream(file);
    }
}
