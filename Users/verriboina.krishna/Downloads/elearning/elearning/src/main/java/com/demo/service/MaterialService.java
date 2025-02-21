package com.demo.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.entities.Material;
import com.demo.repository.MaterialRepository;
@Service
public class MaterialService implements IMaterialService{
	@Autowired
	MaterialRepository materialRepository;
	@Override
	public Material storeFile(MultipartFile file) {
		Material f=new Material();
		f.setFileName(file.getOriginalFilename());
		f.setFileType(file.getContentType());
		try {
			f.setData(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return materialRepository.save(f);
	}
 
	@Override
	public Material getFileUpload(int id) {
		// TODO Auto-generated method stub
		return materialRepository.findById(id).orElseThrow(()->new RuntimeException("failed"+id));
	}

}
