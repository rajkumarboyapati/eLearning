package com.demo.service;

import org.springframework.web.multipart.MultipartFile;

import com.demo.entities.Material;

public interface IMaterialService {
	Material storeFile(MultipartFile file);
	Material getFileUpload(int id);

}
